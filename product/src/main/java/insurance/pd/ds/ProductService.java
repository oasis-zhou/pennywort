package insurance.pd.ds;

import insurance.pd.model.CoverageSpec;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.InsuredSpec;
import insurance.pd.model.ProductSpec;

public interface ProductService {

	public ProductSpec findProduct(String productId);
	
	public InsuredSpec findInsuredSpec(String productId);
	
	public CoverageSpec findCoverageSpec(String productId,String coverageId);
	
	public FormulaSpec findFormula(String formulaId);
}
