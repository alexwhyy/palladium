public class GiftCard extends Card {
	private String name;
	private int number;
	private double balance;
	private int pin;
	private Date expiryDate;
	private int cardId;

	public GiftCard(String name, int number, double balance, int pin, Date expiryDate, int cardId) {
		super(name, number, pin, expiryDate, cardId);
		this.balance = balance;
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