public class GiftCard extends Card {
	private String name;
	private String retailer;
	private int number;
	private double balance;
	private int pin;
	private DateTime expiryDate;

	public GiftCard(String name, String retailer,int number, double balance, int pin, DateTime expiryDate) {
		super(name, number, pin, expiryDate);
		this.balance = balance;
this.retailer = retailer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRetailer() {
		return this.retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public DateTime getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(DateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double compareTo(GiftCard other) {
		return this.balance - other.balance;
	}

	public String toString() {
		return this.name + "\n" + this.retailer + "\n" + this.number + "\n" + this.balance + "\n" + this.pin + "\n" + this.expiryDate.toString();
	}

}