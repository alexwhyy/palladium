public class CreditCard extends Card {
	private String name;
	private int number;
	private int pin;
	private DateTime expiryDate;

	public CreditCard(String name, int number, int pin, DateTime expiryDate) {
		super(name, number, pin, expiryDate);
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

	public String toString() {
		return this.name + "\n" + this.number + "\n" + this.pin + "\n" + this.expiryDate.toString();
	}

}