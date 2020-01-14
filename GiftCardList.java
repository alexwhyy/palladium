import java.util.*;

public class GiftCardList {
	private ArrayList<GiftCard> giftCards;

	public GiftCardList(ArrayList<GiftCard> giftCards) {
		this.giftCards = giftCards;
	}

	public GiftCardList() {
		this.giftCards = new ArrayList<GiftCard>();
	}

	public boolean addGiftCard(String name, int number, double balance, int pin, Date expiryDate) {
		try {
			this.giftCards.add(new GiftCard(name, number, balance, pin, expiryDate));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "alex gay";
	}

}