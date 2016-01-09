package insurance.fd.pub;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;



public class Guid {
	
	private static Map<BizCodeType,String> rulesMap=null;
	
	
	static{
		rulesMap = new HashMap<BizCodeType,String>();
		
		rulesMap.put(BizCodeType.QUOTATION_NUMBER, "{PRODUCT_CODE}{YEAR}{MONTH}{DAY}{RANDOM_NUMBER}");
		rulesMap.put(BizCodeType.POLICY_NUMBER, "{ORGAN_CODE}{PRODUCT_CODE}{YEAR}{MONTH}{DAY}{RANDOM_NUMBER}");
		rulesMap.put(BizCodeType.ENDORSEMENT_NUMBER,"ENDO{YEAR}{MONTH}{DAY{RANDOM_NUMBER}");
		rulesMap.put(BizCodeType.BCP_PAYMENT_NUMBER,"PAY{YEAR}{MONTH}{DAY}{RANDOM_NUMBER}");
		rulesMap.put(BizCodeType.BCP_COLLECTION_NUMBER, "COL{YEAR}{MONTH}{DAY}{RANDOM_NUMBER}");
	}
	
	
	public static String generateBizCode(BizCodeType codeType,Map<String,String> factors){
		
		String code = rulesMap.get(codeType);
		
		for(Entry entry : factors.entrySet()){
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			
			code = code.replace("{" + key + "}", value);
		}
		
		if(code.indexOf("{RANDOM_NUMBER}") > 0){
			 int randomNumber = randomNumber();
			 
			 code = code.replace("{RANDOM_NUMBER}", String.valueOf(randomNumber));
		}
		
		return code;
	}
	
	
	public static int randomNumber(){
		
		return Math.abs(UUID.randomUUID().hashCode());
	}

	public static String generateUuid(){

		return UUID2String(UUID.randomUUID());
	}

	private static String UUID2String(UUID uuid) {
		long mostSigBits = uuid.getMostSignificantBits();
		long leastSigBits = uuid.getLeastSignificantBits();
		return (digits(mostSigBits >> 32, 8) +
				digits(mostSigBits >> 16, 4) +
				digits(mostSigBits, 4) +
				digits(leastSigBits >> 48, 4) +
				digits(leastSigBits, 12));
	}

	private static String digits(long val, int digits) {
		long hi = 1L << (digits * 4);
		return Long.toHexString(hi | (val & (hi - 1))).substring(1);
	}
	
	

}
