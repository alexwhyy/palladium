public abstract class Card {
	protected String name;
	protected String retailer;
	protected int number;
	protected double balance;
	protected int pin;
	protected DateTime expiryDate;

	abstract public String toString();
	
}