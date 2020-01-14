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

	public boolean editCard(int option, String newValue) {
		//option 1: name
		//option 2: number
		//option 3: pin
		//option 4: expiryDate
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
		} else {
			return false;
		}
	}

	public String toString() {
		return this.name;
	}

}