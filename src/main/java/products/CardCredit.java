package products;
import java.time.LocalDate;


public class CardCredit extends Card {
	
	private int cardNumber;
	private LocalDate expDate;
	private int Pin;
	
	
	//getters and setters
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public LocalDate getExpDate() {
		return expDate;
	}
	
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	
	public int getPin() {
		return Pin;
	}
	
	public void setPin(int pin) {
		Pin = pin;
	}
	

	
	public CardCredit(int cardNumber, LocalDate expDate, int pin, String ownerName, String cardtype) {
		super(ownerName, cardtype);
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		Pin = pin;
	}

	public CardCredit() {
		super();
	}
	
	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", expDate=" + expDate + ", Pin=" + Pin + "]";
	}
	
	
	
	
	

}
