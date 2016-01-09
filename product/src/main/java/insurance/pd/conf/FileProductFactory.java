package insurance.pd.conf;

import insurance.fd.ratetable.model.RateTable;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.ProductSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FileProductFactory {
	private static Logger logger = LoggerFactory.getLogger(FileProductFactory.class);
	
	@Autowired
	private ProductConfiguration configuration;

	@Cacheable(value="product")
	public ProductSpec findProduct(String productId)  {
		try{
			logger.debug("Load product " + productId +" first.\n");
			return configuration.getProduct(productId);
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}
	
	@Cacheable(value="formula")
	public FormulaSpec findFormula(String formulaId)  {
		try{
			logger.debug("Load formula " + formulaId +" first.\n");
			return configuration.getFormula(formulaId);
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}
	
	@Cacheable(value="ratetable")
	public RateTable findRateTable(String rateTableCode)  {
		try{
			logger.debug("Load rate table " + rateTableCode +" first.\n");
			return configuration.getRateTable(rateTableCode);
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	@CacheEvict(value="product",allEntries=true)// clear cache
	public void refreshCache() { 
	} 

}