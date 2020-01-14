public class CreditCard extends Card {
	String name;
	String retailer;
	int number;
	int balance;
	int pin;
	DateTime expiryDate;

	int maxBalance;

	public CreditCard(String name, String retailer, int number, int pin, DateTime expiryDate, int maxBalance) {
		this.name = name;
		this.retailer = retailer;
		this.number = number;
		this.pin = pin;
		this.expiryDate = expiryDate;
		this.maxBalance = maxBalance;
	}

	public CreditCard(String name, String retailer, int number, int pin, DateTime expiryDate) {
		this.name = name;
		this.retailer = retailer;
		this.number = number;
		this.pin = pin;
		this.expiryDate = expiryDate;
		this.maxBalance = -1;
	}

	public String toString() {
		return this.name;
	}

}