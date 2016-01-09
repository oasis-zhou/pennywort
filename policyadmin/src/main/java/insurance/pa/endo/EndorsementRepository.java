package insurance.pa.endo;

import insurance.pa.model.Endorsement;

public interface EndorsementRepository {

	public Long create(Endorsement endorsement);

	public void save(Endorsement endorsement);

	public Endorsement load(Long endoId);
}
