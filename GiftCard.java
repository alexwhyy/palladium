public class GiftCard extends Card {
	private String name;
	private String retailer;
	private int number;
	private double balance;
	private int pin;
	private DateTime expiryDate;

	public GiftCard(String name, String retailer, int number, double balance, int pin, DateTime expiryDate) {
		this.name = name;
		this.retailer = retailer;
		this.number = number;
		this.balance = balance;
		this.pin = pin;
		this.expiryDate = expiryDate;
	}

	public double compareTo(GiftCard other) {
		return this.balance - other.balance;
	}

	public String toString() {
		return this.name;
	}

	public boolean editCard(int option) {
	//option 1: name
	//option 2: number
	//option 3: pin
	//option 4: expiryDate
	//option 5: balance
		if (option == 1) {
			
		}
	}

}