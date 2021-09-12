package factrories;
import products.Card;
import products.CardCredit;
import products.CardDebit;
import strategies.CardDeactivationStrategy;

// a class that demonstrates factory pattern - also demonstrates nodes of return cases
public class CardFactory implements BankProductFactory<Card> {

	public Card getCard(String cardType) {

		if (cardType == null) {
			return null;

		} else if (cardType.equalsIgnoreCase("DEBIT")) {
			return new CardDebit();

		} else if (cardType.equalsIgnoreCase("CREDIT")) {
			return new CardDebit();

		}
		return null;
	}

	@Override
	public Card create(String cardType) {

		if (cardType.equals("DEBIT")) {
			return new CardDebit();
		} else
			return new CardCredit();
	}
	
	
}
