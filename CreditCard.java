public class CreditCard extends Card {
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