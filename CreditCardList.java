import java.util.*;

public class CreditCardList {
	private ArrayList<CreditCard> creditCards;

	public CreditCardList(ArrayList<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public CreditCardList() {
		this.creditCards = new ArrayList<CreditCard>();
	}

	public boolean addCreditCard(CreditCard creditCard) {
		try {
			this.creditCards.add(creditCard);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeCreditCard(int index) {
		try {
			this.creditCards.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "There are " + creditCards.size() + " cards in this list.";
	}

}