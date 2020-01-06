public abstract class Card {
	private String name;
	private int number;
	private int pin;
	private Date expiryDate;

	abstract public Card compareTo();
	abstract public String toString();

}

class GiftCard extends Card {
	public GiftCard(String name, int number, int pin, Date expiryDate) {
		this.name = name;
		this.number = number;
		this.pin = pin;
		this.expiryDate = expiryDate;


	}

	public Card compareTo(Card other) {
		return this
	}

	public String toString() {
		return this.name;
	}
}

class CreditCard extends Card {
	String name;
	int number;
	int pin;
	Date expiryDate;
	int cardId;

	public CreditCard(String name, int number, int pin, Date expiryDate, int cardId) {
		this.name = name;
		this.number = number;
		this.pin = pin;
		this.expiryDate = expiryDate;
		this.cardId = cardId;
	}

	public String toString() {
		return this.name;
	}
}