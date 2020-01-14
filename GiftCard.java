public class GiftCard extends Card {
	private String name;
	private String retailer;
	private int number;
	private double balance;
	private int pin;
	private DateTime expiryDate;

	public GiftCard(String name, int number, double balance, int pin, DateTime expiryDate) {
		super(name, number, pin, expiryDate);
		this.balance = balance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		return this.name;
	}

	public boolean editCard(int option, String newValue) {
	//option 1: name
	//option 2: number
	//option 3: pin
	//option 4: expiryDate
	//option 5: balance
		if (option == 1) {
			this.name = newValue;
			return true;
		} else if (option == 2) {
			this.number = Integer.parseInt(newValue);
			return true;
		} else if (option == 3) {
			this.pin = Integer.parseInt(newValue);
			return true;
		} else if (option == 4) {
			this.expiryDate = new DateTime(newValue);
			return true;
		} else if (option == 5) {
			this.balance = Integer.parseInt(newValue);
			return true;
		} else {
			return false;
		}
	}

}