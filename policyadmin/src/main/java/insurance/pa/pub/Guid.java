package insurance.pa.pub;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Guid {

	private static Logger logger = LoggerFactory.getLogger(Guid.class);

	
	public String generateEndorsementNumber(){
		
		return generate();
	}
	
	public String generatePolicyNumber(){
		
		return generate();
	}

	public static String generate(){

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
