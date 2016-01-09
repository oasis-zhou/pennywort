package insurance.price;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import insurance.pd.model.FormulaSpec;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FmsService {

	private static Logger logger = LoggerFactory.getLogger(FmsService.class);


	public Map evalWithFormula(FormulaSpec formula,Map factors){

		Map result = null;
		try {
			logger.debug("*****All factors==" + factors + "\n");

			Binding binding = new Binding();
			List<String> factorKeys = formula.getFactors();

			for(String key : factorKeys){
				binding.setVariable(key, factors.get(key));
			}
			
			binding.setVariable("language", "Groovy");
			GroovyShell shell = new GroovyShell(binding);
			Object value = shell.evaluate(formula.getBody());
			
			result = (Map)value;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return result;
	}
}
