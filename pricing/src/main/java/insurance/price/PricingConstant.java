package insurance.price;

public class PricingConstant {

	//Fee source type
	public static final int FEE_SOURCE_NEWBIZ_PREMIUM = 1;
	public static final int FEE_SOURCE_NEWBIZ_TAXFEE = 2;
	public static final int FEE_SOURCE_NEWBIZ_COMMISSION = 3;
	
	public static final int FEE_SOURCE_ENDO_PREMIUM = 6;
	public static final int FEE_SOURCE_ENDO_TAXFEE = 7;
	public static final int FEE_SOURCE_ENDO_COMMISSION = 8;

	//internal fix rating factor key
	public static final String FORMULA_FACTOR = "FORMULA";
	public static final String MULTI_FORMULA_FACTOR = "MULTI_FORMULA";
	public static final String DISTRIBUTION_FACTOR = "DISTRIBUTION_FACTOR";
	public static final String LIMIT_FACTOR = "LIMIT_FACTOR";
	public static final String AOA_LIMIT_AMOUNT = "AOA_LIMIT_AMOUNT";
	public static final String AOP_LIMIT_AMOUNT = "AOP_LIMIT_AMOUNT";	
	public static final String FIX_PREMIUM_FACTOR = "FIX_PREMIUM";
	public static final String FIX_COMMISSION_FACTOR = "FIX_COMMISSION";
	
	//definition rating factor key
	public static final String COMMISSION_RATE_FACTOR = "COMMISSION_RATE";
	public static final String PREMIUM_ANP_FACTOR = "PREMIUM_ANP";
	
	public static final String ENDORSEMENT_TYPE_FACTOR = "ENDORSEMENT_TYPE";
	public static final String ORIGINAL_FEE_ANP = "ORIGINAL_FEE_ANP";
	public static final String NEW_FEE_ANP = "NEW_FEE_ANP";
	public static final String ORIGINAL_POL_EFF_DATE = "ORIGINAL_POL_EFF_DATE";
	public static final String ORIGINAL_POL_EXP_DATE = "ORIGINAL_POL_EXP_DATE";
	public static final String NEW_POL_EFF_DATE = "NEW_POL_EFF_DATE";
	public static final String NEW_POL_EXP_DATE = "NEW_POL_EXP_DATE";
	public static final String ENDO_EFF_DATE = "ENDO_EFF_DATE";
	public static final String ENDO_PRO_RATE = "ENDO_PRO_RATE";

	//definition fee type
	public static final String FEE_TYPE_SGP = "SGP";
	public static final String FEE_TYPE_AGP = "AGP";
	public static final String FEE_TYPE_SNP = "SNP";
	public static final String FEE_TYPE_ANP = "ANP";
	
	public static final String FEE_TYPE_APP = "APP";
	
	public static final String FEE_TYPE_COMMISSION = "COMMISSION";
	
	public static final String FEE_TYPE_ADMIN_FEE = "ADMIN_FEE";


}
