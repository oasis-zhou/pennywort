package insurance.pd.ds.impl;

import insurance.pd.conf.FileProductFactory;
import insurance.pd.ds.ProductService;
import insurance.pd.model.CoverageSpec;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.InsuredSpec;
import insurance.pd.model.ProductSpec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private FileProductFactory productFactory;

	@Override
	public ProductSpec findProduct(String productId) {

		ProductSpec product = productFactory.findProduct(productId);
		return product;
	}

	@Override
	public InsuredSpec findInsuredSpec(String productId){
		ProductSpec product = productFactory.findProduct(productId);

		return product.getInsured();
	}

	@Override
	public CoverageSpec findCoverageSpec(String productId,String coverageId){
		CoverageSpec coverageRet = null;

		ProductSpec product = productFactory.findProduct(productId);
		List<CoverageSpec> coverages = product.getCoverages();
		for(CoverageSpec coverage : coverages){
			if(coverage.getUuid().equals(coverageId)){
				coverageRet = coverage;
			}
		}
		return coverageRet;
	}

	@Override
	public FormulaSpec findFormula(String formulaId){
		
		return productFactory.findFormula(formulaId);
	}


}
