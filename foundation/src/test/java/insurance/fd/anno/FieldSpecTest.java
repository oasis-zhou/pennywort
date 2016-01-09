package insurance.fd.anno;

import insurance.AbstractTest;
import insurance.fd.conf.SystemConfig;
import insurance.fd.model.BaseModel;
import insurance.fd.pub.Guid;
import insurance.fd.utils.JsonHelper;
import insurance.fd.utils.ObjFieldUtil;

import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class FieldSpecTest extends AbstractTest{

	@Autowired
	private SystemConfig config;
	
	@Autowired
	private JsonHelper jsonHelper;
	
//	@Test
	public void fieldTest(){
		
		BaseModel base = new BaseModel();
		
		Map<String,Object> fields = ObjFieldUtil.getFieldValueByFieldSpecCode(base);
		
		System.out.print("******fields==" + fields);
	}
	
//	@Test
	public void fieldTest2(){
		
		TestModel m = new TestModel();
		m.setTest("tst");
		
		Map<String,Object> fields = ObjFieldUtil.getFieldValueByFieldSpecCode(m);
		
		System.out.print("******fields==" + fields);
	}
	
	public enum OfferType {
		AMOUNT, RATE;
	}
	
	@Test
	public void fieldTest3(){
		
		OfferType o1 = OfferType.AMOUNT;
		
		if(o1.equals(OfferType.AMOUNT)){
			System.out.print("******OfferType.AMOUNT==");
		}else{
			System.out.print("******OfferType.AMOUNT!=");
		}
		
//		String format = config.env().getProperty("date.format");
//		
//		System.out.print("******fields==" + format);
		
//		int str = UUID.randomUUID().hashCode();
//		System.out.print("******hashcode==" + str);
	
		//******hashcode==595932998
	}
	
	
	
//	@Test
	public void test1(){
		TestModel m = new TestModel();
		
		Boolean t = m.getClass().isAssignableFrom(BaseModel.class);
		
		Boolean t2 = BaseModel.class.isAssignableFrom(m.getClass());
		
		Boolean t3 = BaseModel.class.isAssignableFrom(BaseModel.class);
		
		System.out.print("******check1==" + t);
		System.out.print("******check2==" + t2);
		System.out.print("******check3==" + t3);
	}
	
}
