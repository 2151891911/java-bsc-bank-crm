package choice;


//defines the consent options of the Customer
public enum Consent {

	//Customer can choose ONLY between yes or no
	AFFIRM("yes"), DECLINE("no");
	
	
	
	//same primitive type as value in ENUM property
	private String value;
	
	
	//to calculate the price
	//ENUM private constructor
	private Consent(String option) {
		this.value = option;
	}


	public String getValue() {
		return value;
	}
	
}
