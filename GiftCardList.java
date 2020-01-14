import java.util.ArrayList;

public class GiftCardList {
	private ArrayList<GiftCard> giftcards;
	int length;

	public GiftCardList(ArrayList<GiftCard> giftcards) {
		this.giftcards = giftcards;
		this.length = giftcards.size();
	}

	public GiftCardList() {
		this.giftcards = new ArrayList<GiftCard>();
		this.length = 0;
	}

	public boolean addGiftCard(GiftCard newGiftCard) {
		try {
			this.giftcards.add(newGiftCard);
			length++;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "lmao";
	}

}