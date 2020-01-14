public abstract class Card {
	protected String name;
	protected String retailer;
	protected int number;
	protected double balance;
	protected int pin;
	protected DateTime expiryDate;

	public Card(String nick, int numb, int pin, DateTime expiry){
		this.name = nick;
		this.number = numb;
		this.pin = pin;
		this.expiryDate = expiry;
	}

	abstract public String toString();
	abstract public boolean editCard(int option, String newValue);
	//option 1: name
	//option 2: number
	//option 3: pin
	//option 4: expiryDate
	
}