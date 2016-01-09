package insurance.price;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import insurance.AbstractTest;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;



public class GroovyTest extends AbstractTest{

//	@Test
	public void testScript(){

		String script = "x = limit_limitAmount * 0.1; return ['premium':x];";

		Binding binding = new Binding();

		binding.setVariable("limit_limitAmount", new BigDecimal(9.00));

		binding.setVariable("language", "Groovy");
		GroovyShell shell = new GroovyShell(binding);
		Object value = shell.evaluate(script);

		Map result = (Map)value;
		
		System.out.print("####Result==" + result);
	}
	
	@Test
	public void groovyCallJava(){
		
		String script = "insurance.price.GroovyCallJava caller = new insurance.price.GroovyCallJava(); x = caller.call();return x + parameter;";

		Binding binding = new Binding();

		binding.setVariable("parameter", "Java");

		binding.setVariable("language", "Groovy");
		GroovyShell shell = new GroovyShell(binding);
		Object value = shell.evaluate(script);

		
		
		System.out.print("####Result==" + value);
	}
}
