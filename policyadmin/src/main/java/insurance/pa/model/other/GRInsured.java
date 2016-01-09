package insurance.pa.model.other;

import insurance.pa.model.Coverage;
import insurance.pa.model.Insured;

import java.util.ArrayList;
import java.util.List;

public class GRInsured  extends Insured{

	private List<Coverage> coverages;
	
	@Override
	public List<Coverage> getCoverages(){
		if(coverages == null){
			coverages = new ArrayList<Coverage>();
		}
		return coverages;
	}

	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}
}
