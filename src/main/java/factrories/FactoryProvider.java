package factrories;

public class FactoryProvider {

	public static BankProductFactory<?> getFactory(String choice) {
		
		// depending on the choice we evoke the respective factory
		if (choice.equals("Card")) {
			return new CardFactory();
		} else
			return new InsuranceFactory();
	}

	
}
