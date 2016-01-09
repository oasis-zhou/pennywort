package insurance.fd.validation;

import java.util.Map;

public interface ValidationRule {

	/**
	   * Validate the rule.
	   * @param dataContext A map which contains the objects needed by the validations.
	   * @return The result of the validation. 
	   * @throws Exception Exception
	   */
	  public ValidationResult validate(Map dataContext);
}
