package strategies;

import products.Card;

/* Cards give the customer a bonus when he/she uses the card, but the bonus is different for each card type. 
 * For example, a debit card gives 5 units of bonus and a credit card gives 10. 
 * Lets illustrate this via design pattern: strategy. */


// this is our context - we set and execute the respective strategy via the context
public class CardDeactivationContext {
	
	private Card card;
	//we initialize resources -> subject and strategy/choices
	private CardDeactivationStrategy deactivate;


	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public CardDeactivationStrategy getDeactivate() {
		return deactivate;
	}

	public void setDeactivate(CardDeactivationStrategy deactivate) {
		this.deactivate = deactivate;
	}
	
	public CardDeactivationContext() {};
	
	
	public CardDeactivationContext(Card card, CardDeactivationStrategy deactivate) {
		super();
		this.card = card;
		this.deactivate = deactivate;
	}

	// has a method for execution of de-activation - it takes the property set up by the entire context
	// in other words it takes the member variable/subject
	public void deactivateCard() {
		deactivate.executeDeactivation(card);
	}

	

}
