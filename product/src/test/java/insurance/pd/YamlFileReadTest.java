package insurance.pd;

import insurance.AbstractTest;

import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;


public class YamlFileReadTest extends AbstractTest{

	String CONFIG_FILE_PATH = "/META-INF/product-config.yml";
	
	
	
	@Test
	public void readFile(){
		try{
			InputStream input = this.getClass().getResourceAsStream(CONFIG_FILE_PATH);
			Yaml yaml = new Yaml();
			Map<String, Object> object = (Map<String, Object>) yaml.load(input);
			
			System.out.print("###File Content==" + object);
			
//			String path = getClass().getResource("/META-INF/product-config.yml").getPath();
//			
//			System.out.print("###File path==" + path);
			
//			ProductConfiguration conf = ProductConfiguration.getConfiguration();
//			List<String> s = conf.findProductConfigFile();
//			System.out.print("###File path==" + s);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
