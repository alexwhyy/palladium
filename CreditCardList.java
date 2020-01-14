import java.util.*;

public class CreditCardList {
	private ArrayList<CreditCard> creditCards;

	public CreditCardList(ArrayList<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public CreditCardList() {
		this.creditCards = new ArrayList<CreditCard>();
	}

	public boolean addCreditCard(String name, int number, int pin, Date expiryDate) {
		try {
			this.creditCards.add(new CreditCard(name, number, pin, expiryDate));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "There are " + creditCards.size() + " cards in this list.";
	}

}