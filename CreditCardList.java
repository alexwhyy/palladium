import java.util.ArrayList;

public class CreditCardList {
	private ArrayList<CreditCard> cards;

	public CreditCardList(ArrayList<CreditCard> cards) {
		this.cards = cards;
	}

	public boolean addCard(CreditCard new_card) {
		try {
			this.cards.add(new_card);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "There are " this.cards.size() + " cards in this list.";
	}

}