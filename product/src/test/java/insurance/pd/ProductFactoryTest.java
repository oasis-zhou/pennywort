package insurance.pd;


import insurance.AbstractTest;
import insurance.pd.conf.FileProductFactory;
import insurance.pd.model.ProductSpec;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductFactoryTest extends AbstractTest{
	
	@Autowired
	private FileProductFactory productFactory;
	
	@Test
	public void loadProduct(){
		String productId = "GR:1";
		
		ProductSpec product = productFactory.findProduct(productId);
		
		Assert.assertEquals("GR:1", product.getUuid());
		
		ProductSpec productSecond = productFactory.findProduct(productId);
		
		Assert.assertEquals("GR:1", productSecond.getUuid());
	}

}
