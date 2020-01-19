public abstract class Card {
	protected String name;
	protected int number;
	protected int pin;
	protected DateTime expiryDate;

	public Card(String nick, int numb, int pin, DateTime expiry){
		this.name = nick;
		this.number = numb;
		this.pin = pin;
		this.expiryDate = expiry;
	}

	public String toString(){
		return name+ "\n" + number + "\n" + pin + "\n" + expiryDate.toString();
	}

}