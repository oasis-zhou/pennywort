package insurance.fd.validation;

import insurance.fd.context.AppContext;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	/**
	   * The main method to do the validation.
	   * @param ruleSetID The Spring Bean Name of a RuleSet implementation class.
	   * @param dataContext A map which contains the objects needed by the validations. 
	   * @return The result of the validation.
	   * @throws Exception Exceptions.
	   */
	  @SuppressWarnings("unchecked")
	  public ValidationResult validate(String ruleSetID, Map<?, ?> dataContext){
		 
	    RuleSet ruleSet = (RuleSet) AppContext.getBean(ruleSetID,RuleSet.class);
	    ValidationResult result = new ValidationResult();
	    for (ValidationRule rule : ruleSet.getRules()) {
	      
	      ValidationResult oneResult = rule.validate(dataContext);
	      if (oneResult != null && oneResult.isFailed()) {
	        result.getMessages().addAll(oneResult.getMessages());
	       
	        result.getAdditionalInformations().putAll(
	            oneResult.getAdditionalInformations());
	        result.setFailed(true);
	      }
	    }
	    return result;
	  }
}
