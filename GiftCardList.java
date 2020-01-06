import java.util.ArrayList;

public class GiftCardList {
	private ArrayList<GiftCard> giftcards;

	public GiftCardList(ArrayList<GiftCard> giftcards) {
		this.giftcards = giftcards;
	}

	public boolean addGiftCard(GiftCard newGiftCard) {
		try {
			this.giftcards.add(newGiftCard);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "lmao";
	}

}