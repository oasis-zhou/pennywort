package insurance.price.model;



public interface PricingModelBuilder<T extends ModelWithFee> {

	public PricingModel build(T model);
}
