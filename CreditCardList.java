import java.util.*;

public class CreditCardList {
	private ArrayList<CreditCard> creditCards;
	public int length;

	public CreditCardList(ArrayList<CreditCard> creditCards) {
		this.creditCards = creditCards;
		this.length = creditCards.size();
	}

	public CreditCardList() {
		this.creditCards = new ArrayList<CreditCard>();
		this.length = 0;
	}

	public boolean addCreditCard(CreditCard creditCard) {
		try {
			this.creditCards.add(creditCard);
			length++;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CreditCard getCreditCardIndex(int index) {
		if (index < 0 || index > this.length - 1) {
			return null;
		} else {
			return this.creditCards.get(index);
		}
	}

	public boolean removeCreditCard(int index) {
		try {
			this.creditCards.remove(index);
			length--;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "There are " + creditCards.size() + " cards in this list.";
	}

}