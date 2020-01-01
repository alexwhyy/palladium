public class GiftCard {
	String name;
	int number;
	double balance;
	int pin;
	Date expiryDate;
	int cardId;

	public GiftCard(String name, int number, double balance, int pin, Date expiryDate, int cardId) {
		this.name = name;
		this.number = number;
		this.balance = balance;
		this.pin = pin;
		this.expiryDate = expiryDate;
		this.cardId = cardId;
	}

	public String getName() {
		return this.name;
	}

	public double getBalance() {
		return this.balance;
	}

	public double compareTo(GiftCard other) {
		return this.balance - other.balance;
	}

	public String toString() {
		return this.name;
	}

}