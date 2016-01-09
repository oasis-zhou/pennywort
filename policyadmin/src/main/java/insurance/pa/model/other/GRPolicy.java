package insurance.pa.model.other;

import insurance.pa.model.Coverage;
import insurance.pa.model.Insured;
import insurance.pa.model.Policy;

import java.util.ArrayList;
import java.util.List;

public class GRPolicy extends Policy {

	private GRInsured insured;
	
	@Override
	public List<Insured> getInsureds() {
		List<Insured> insureds = new ArrayList<Insured>();
		insureds.add(this.getInsured());
		return insureds;
	}

	@Override
	public List<Coverage> getCoverages() {
		return this.getInsured().getCoverages();
	}

	public GRInsured getInsured() {
		return insured;
	}

	public void setInsured(GRInsured insured) {
		this.insured = insured;
	}
	
	

}
