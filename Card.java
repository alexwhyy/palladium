public abstract class Card {
	protected String name;
	protected int number;
	protected int pin;
	protected Date expiryDate;

	public Card(String nick, int numb, int pin, Date expiry){
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