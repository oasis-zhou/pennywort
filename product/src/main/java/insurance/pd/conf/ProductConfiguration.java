package insurance.pd.conf;

import insurance.fd.conf.SystemConfig;
import insurance.fd.context.AppContext;
import insurance.fd.ratetable.model.RateItem;
import insurance.fd.ratetable.model.RateTable;
import insurance.fd.ratetable.model.ScopeFactor;
import insurance.fd.ratetable.model.ValueFactor;
import insurance.pd.model.CoverageSpec;
import insurance.pd.model.DeductibleSpec;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.InsuredSpec;
import insurance.pd.model.LimitSpec;
import insurance.pd.model.ProductSpec;
import insurance.pd.model.RuleSetSpec;
import insurance.pd.model.RuleSpec;
import insurance.pd.model.TagSpec;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

@SuppressWarnings("serial")
@Component
public class ProductConfiguration implements Serializable {

	@Autowired
	private SystemConfig sysConf;

	private static final String PRODUCT_FILE_PATH = "classpath*:product-*.xml";
	private static final String FORMULA_FILE_PATH = "classpath*:formula-*.xml";
	private static final String RATE_TABLE_FILE_PATH = "classpath*:ratetable-*.xml";


	private Map<String, ProductSpec> productConfigMap = new HashMap<String, ProductSpec>();
	private Map<String, FormulaSpec> formulaConfigMap = new HashMap<String, FormulaSpec>();
	private Map<String, RateTable> rateTableConfigMap = new HashMap<String, RateTable>();

	public ProductSpec getProduct(String productId) throws Exception {
		ProductSpec product = (ProductSpec) productConfigMap.get(productId);
		if (product == null) {
			//load product configuration info
			loadFormula();
			loadProduct();

			product = (ProductSpec) productConfigMap.get(productId);	
			if( product == null)
				throw new RuntimeException("The product (id=" + productId + ") is not found!");
		}
		return product;
	}

	public FormulaSpec getFormula(String formulaId) throws Exception {
		FormulaSpec formula = (FormulaSpec) formulaConfigMap.get(formulaId);
		if (formula == null) {
			//load formula configuration info
			loadFormula();

			formula = (FormulaSpec) formulaConfigMap.get(formulaId);	
			if( formula == null)
				throw new RuntimeException("The formula (id=" + formulaId + ") is not found!");
		}
		return formula;
	}
	
	public RateTable getRateTable(String code) throws Exception {
		RateTable rateTable = (RateTable) rateTableConfigMap.get(code);
		if (rateTable == null) {
			//load rate table configuration info
			loadRateTable();

			rateTable = (RateTable) rateTableConfigMap.get(code);	
			if( rateTable == null)
				throw new RuntimeException("The rate table (code=" + code + ") is not found!");
		}
		return rateTable;
	}

	public void loadProduct() throws Exception {
		productConfigMap.clear();

		SAXReader reader = new SAXReader();
		
		Resource[] resfiles = AppContext.getApplicationContext().getResources(PRODUCT_FILE_PATH);

		for (Resource resfile : resfiles) {
			InputStream is = resfile.getInputStream();
			Document document = reader.read(new InputStreamReader(is));
			Element root = document.getRootElement();
			ProductSpec product = loadProductConfig(root);

			productConfigMap.put(product.getUuid(),product);
		}
	}

	public void loadFormula() throws Exception {

		formulaConfigMap.clear();

		SAXReader reader = new SAXReader();

		Resource[] resfiles = AppContext.getApplicationContext().getResources(FORMULA_FILE_PATH);

		for (Resource resfile : resfiles) {
			InputStream is = resfile.getInputStream();
			Document document = reader.read(new InputStreamReader(is));
			Element root = document.getRootElement();
			Map<String,FormulaSpec> formulaMap = loadFormulaConfig(root);

			formulaConfigMap.putAll(formulaMap);
		}

	}

	public void loadRateTable() throws Exception {

		rateTableConfigMap.clear();

		SAXReader reader = new SAXReader();

		Resource[] resfiles = AppContext.getApplicationContext().getResources(RATE_TABLE_FILE_PATH);

		for (Resource resfile : resfiles) {
			InputStream is = resfile.getInputStream();
			Document document = reader.read(new InputStreamReader(is));
			Element root = document.getRootElement();
			Map<String,RateTable> rateTableMap = loadRateTableConfig(root);

			rateTableConfigMap.putAll(rateTableMap);
		}

	}

	protected ProductSpec loadProductConfig(Element root) throws Exception{

		SimpleDateFormat dateFormat = sysConf.getSysDateFormat();
		//product info
		ProductSpec product = new ProductSpec();
		Element productElement = root;
		product.setUuid(productElement.attributeValue("uuid"));
		product.setCode(productElement.attributeValue("code"));
		product.setName(productElement.attributeValue("name"));
		if(productElement.elementText("valid") != null)
			product.setValid(Boolean.parseBoolean(productElement.elementText("valid")));
		product.setVersion(productElement.attributeValue("version"));
		if(productElement.elementText("effDate") != null){
			product.setEffectiveDate(dateFormat.parse(productElement.elementText("effDate")));
		}
		if(productElement.elementText("expDate") != null){
			product.setExpiredDate(dateFormat.parse(productElement.elementText("expDate")));
		}
		product.setDescription(productElement.elementText("desc"));

		//product insured info
		Element induredElement = productElement.element("insured");
		InsuredSpec insured = new InsuredSpec();
		if(induredElement.elementText("cate") != null)
			insured.setCategory(Integer.parseInt(induredElement.elementText("cate")));

		List<TagSpec> insuredTags = parseTagElement(induredElement);
		insured.getTags().addAll(insuredTags);

		Element iformulasElement = induredElement.element("formulas");
		List<FormulaSpec> insuredFormulas = parseFormulaElement(iformulasElement);
		insured.getFormulas().addAll(insuredFormulas);	

		product.setInsured(insured);

		//product coverage info
		Element coveragesElement = productElement.element("coverages");	
		if(coveragesElement != null){
			List<Element> coverageElements = coveragesElement.elements();
			for (Element coverageElement : coverageElements) {
				CoverageSpec coverage = new CoverageSpec();
				coverage.setUuid(coverageElement.attributeValue("uuid"));
				coverage.setName(coverageElement.attributeValue("name"));
				coverage.setCode(coverageElement.attributeValue("code"));
				coverage.setDescription(coverageElement.elementText("desc"));

				List<TagSpec> coverageTags = parseTagElement(coverageElement);
				coverage.getTags().addAll(coverageTags);

				Element cformulasElement = coverageElement.element("formulas");
				List<FormulaSpec> coverageFormulas = parseFormulaElement(cformulasElement);
				coverage.getFormulas().addAll(coverageFormulas);

				Element limitElement = coverageElement.element("limit");
				if(limitElement != null){
					LimitSpec limit = new LimitSpec();
					limit.setIndemnityType(limitElement.elementText("indemnityType"));
					limit.setPattern(limitElement.elementText("pattern"));
					limit.setValue(limitElement.elementText("value"));
					coverage.setLimit(limit);
				}

				Element deductibleElement = coverageElement.element("Deductible");
				if(deductibleElement != null){
					DeductibleSpec deductible = new DeductibleSpec();
					deductible.setPattern(deductibleElement.elementText("pattern"));
					deductible.setValue(deductibleElement.elementText("value"));
					coverage.setDeductible(deductible);
				}

				product.getCoverages().add(coverage);
			}
		}

		//product formula info
		Element pformulasElement = productElement.element("formulas");
		List<FormulaSpec> productFormulas = parseFormulaElement(pformulasElement);
		product.getFormulas().addAll(productFormulas);

		//product tag info
		List<TagSpec> productTags = parseTagElement(productElement);
		product.getTags().addAll(productTags);

		//product rule set info
		Element rulesetsElement = productElement.element("rulesets");
		if(rulesetsElement != null){
			List<Element> rulesetElements = rulesetsElement.elements();
			for (Element rulesetElement : rulesetElements) {
				RuleSetSpec ruleSet = new RuleSetSpec();
				ruleSet.setUuid(rulesetElement.attributeValue("uuid"));
				ruleSet.setName(rulesetElement.attributeValue("name"));

				List<Element> ruleElements = rulesetElement.elements("rule");
				for (Element ruleElement : ruleElements) {
					RuleSpec rule = new RuleSpec();
					rule.setUuid(ruleElement.attributeValue("uuid"));
					rule.setName(ruleElement.attributeValue("name"));
					rule.setBody(ruleElement.elementText("body"));

					String factorsStr = ruleElement.elementText("factors");
					if(factorsStr != null){
						String[] factors = factorsStr.split(",");
						List<String> factorList = Arrays.asList(factors);
						rule.getFactors().addAll(factorList);
					}
					ruleSet.getRules().add(rule);
				}

				product.getRuleSets().add(ruleSet);
			}
		}

		return product;
	}

	protected Map<String,FormulaSpec> loadFormulaConfig(Element root) throws Exception{

		Map<String,FormulaSpec> formulaMap = new HashMap<String,FormulaSpec>();

		List<FormulaSpec> formulas = parseFormulaElement(root);
		for(FormulaSpec spec : formulas){
			formulaMap.put(spec.getUuid(), spec);
		}

		return formulaMap;
	}

	protected Map<String,RateTable> loadRateTableConfig(Element root) throws Exception{

		Map<String,RateTable> rateTableMap = new HashMap<String,RateTable>();

		List<RateTable> rateTables = parseRateTableElement(root);
		for(RateTable spec : rateTables){
			rateTableMap.put(spec.getCode(), spec);
		}

		return rateTableMap;
	}

	private List<RateTable> parseRateTableElement(Element rateTableElement) throws Exception{

		SimpleDateFormat dateFormat = sysConf.getSysDateFormat();

		List<RateTable> rateTables = new ArrayList<RateTable>();

		RateTable rateTable = new RateTable();
		rateTables.add(rateTable);
		rateTable.setCode(rateTableElement.attributeValue("code"));
		rateTable.setName(rateTableElement.attributeValue("name"));
		if(rateTableElement.elementText("valid") != null)
			rateTable.setValid(Boolean.parseBoolean(rateTableElement.elementText("valid")));
		rateTable.setVersion(rateTableElement.attributeValue("version"));
		if(rateTableElement.elementText("effDate") != null){
			rateTable.setEffectiveDate(dateFormat.parse(rateTableElement.elementText("effDate")));
		}
		if(rateTableElement.elementText("expDate") != null){
			rateTable.setExpiredDate(dateFormat.parse(rateTableElement.elementText("expDate")));
		}
		rateTable.setDescription(rateTableElement.elementText("desc"));

		Element rateItemsElement = rateTableElement.element("rateitems");
		List<Element> rateItemElements = rateItemsElement.elements();
		for (Element rateItemElement : rateItemElements) {
			RateItem item = new RateItem();
			rateTable.getItems().add(item);

			List<Element> factorElements = rateItemElement.elements("factor");
			for(Element factorElement : factorElements){
				String fName = factorElement.attributeValue("name");
				boolean isScope = Boolean.parseBoolean(factorElement.attributeValue("isScope"));
				if(isScope){
					ScopeFactor factor = new ScopeFactor();
					factor.setName(fName);
					factor.setMaxFactor(factorElement.elementText("maxValue"));
					factor.setMinFactor(factorElement.elementText("minValue"));
					item.getRateFactors().put(fName, factor);
				}else{
					ValueFactor factor = new ValueFactor();
					factor.setName(fName);
					factor.setValue(factorElement.getText());
					item.getRateFactors().put(fName, factor);
				}
			}

			List<Element> valueElements = rateItemElement.elements("ratevalue");
			for(Element valueElement : valueElements){
				item.getRateValues().put(valueElement.attributeValue("name"), valueElement.getText());		
			}
		}

		return rateTables;
	}

	private List<FormulaSpec> parseFormulaElement(Element formulasElement) {
		List<FormulaSpec> formulas = new ArrayList<FormulaSpec>();

		if(formulasElement != null){
			List<Element> formulaElements = formulasElement.elements();
			for (Element formulaElement : formulaElements) {
				FormulaSpec formula = new FormulaSpec();
				formula.setUuid(formulaElement.attributeValue("uuid"));

				FormulaSpec commonFormula = formulaConfigMap.get(formula.getUuid());
				if(commonFormula == null){
					formula.setName(formulaElement.attributeValue("name"));
					formula.setAim(formulaElement.attributeValue("aim"));
					formula.setBody(formulaElement.elementText("body"));

					String factorsStr = formulaElement.elementText("factors");
					if(factorsStr != null){
						String[] factors = factorsStr.split(",");
						List<String> factorList = Arrays.asList(factors);
						formula.getFactors().addAll(factorList);
					}
				}else{
					formula = commonFormula;
				}

				formulas.add(formula);
			}
		}
		return formulas;
	}

	private List<TagSpec> parseTagElement(Element element) {
		List<TagSpec> tags = new ArrayList<TagSpec>();
		Element tagsElement = element.element("tags");
		if(tagsElement != null){
			List<Element> tagElements = tagsElement.elements();
			for (Element tagElement : tagElements) {
				TagSpec tag = new TagSpec();
				tag.setName(tagElement.attributeValue("name"));
				tag.setValue(tagElement.getText());
				tags.add(tag);
			}
		}

		return tags;
	}




}
