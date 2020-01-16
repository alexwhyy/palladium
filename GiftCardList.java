import java.util.*;

public class GiftCardList {
	private ArrayList<GiftCard> giftCards;

	public GiftCardList(ArrayList<GiftCard> giftCards) {
		this.giftCards = giftCards;
	}

	public GiftCardList() {
		this.giftCards = new ArrayList<GiftCard>();
	}

	public boolean addGiftCard(GiftCard giftCard) {
		try {
			this.giftCards.add(giftCard);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "alex gay";
	}

}