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

}