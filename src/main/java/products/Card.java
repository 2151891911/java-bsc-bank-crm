package products;

public class Card {
	
	private String ownerName;
	private String cardtype;

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public Card(String ownerName, String cardtype) {
		super();
		this.ownerName = ownerName;
		this.cardtype = cardtype;
	}

	public Card() {
		super();
	}

}
