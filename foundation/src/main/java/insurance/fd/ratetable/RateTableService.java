package insurance.fd.ratetable;

import insurance.fd.ratetable.model.RateTable;

import java.util.Map;

public interface RateTableService {

	public Map<String,String> findRate(RateTable table,Map<String,String> factors);
}
