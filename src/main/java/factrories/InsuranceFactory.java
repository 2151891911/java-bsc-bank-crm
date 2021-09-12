package factrories;
import products.InsuranceAuto;
import products.InsuranceLife;
import repos.Insurance;

public class InsuranceFactory implements BankProductFactory<Insurance> {

	
	public Insurance getInsurance(String insuranceType) {

		if (insuranceType == null) {
			return null;

		} else if (insuranceType.equalsIgnoreCase("AUTO")) {
			return new InsuranceAuto();

		} else if (insuranceType.equalsIgnoreCase("CREDIT")) {
			return new InsuranceLife();

		}
		return null;
	}
	
		
	
	
	
	@Override
	public Insurance create(String insuranceType) {
		if (insuranceType.equals("AUTO")) {
			//returns directly a new obj
			return new InsuranceAuto();
		} else
			return new InsuranceLife();
	}
}
