import java.util.ArrayList;

public class CreditCardList {
	private ArrayList<CreditCard> cards;
	public int length;

	public CreditCardList(ArrayList<CreditCard> cards) {
		this.cards = cards;
		this.length = cards.size();
	}

	public CreditCardList() {
		this.length = 0;
		this.cards = new ArrayList<CreditCard>();
	}

	public boolean addCard(CreditCard new_card) {
		try {
			this.cards.add(new_card);
			length++;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "";
	}

}