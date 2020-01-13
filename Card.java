public abstract class Card {
	protected String name;
	protected int number;
	protected int pin;
	protected Date expiryDate;
	protected int cardId;

	public Card(String nick, int numb, int pin, Date expiry, int ID){
		this.name = nick;
		this.number = numb;
		this.pin = pin;
		this.expiryDate = expiry;
		this.cardId = ID;
	}

	abstract public Card compareTo(Card other);
	abstract public String toString();
	abstract public boolean editCard(int option);
	//option 1: name
	//option 2: number
	//option 3: pin
	//option 4: expiryDate
	
}