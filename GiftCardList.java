import java.io.*;
import java.util.*;

public class GiftCardList {
	private ArrayList<GiftCard> giftCards;
	private String filePath;
	private int length;
	
	public GiftCardList(ArrayList<GiftCard> giftCards) {
		this.giftCards = giftCards;
	}

	public GiftCardList(String filePath) {
		this.filePath = filePath;
		GiftCard parsedGiftCard;
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.filePath));
			String input;
			while ((input = in.readLine()) != null) {
				length = Integer.parseInt(input);
				for (int i = 0; i < length; i++) {
					parsedGiftCard = new GiftCard(in.readLine(),Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Integer.parseInt(in.readLine()), new DateTime(in.readLine()));
					giftCards.add(parsedGiftCard);
				}
			}
			in.close();
		} catch (IOException iox) {
			System.out.println(" ____________________________________");
			System.out.println("|                                    |");
			System.out.println("| File Reading Error!                |");
			System.out.println("|                                    |");
			System.out.println("|____________________________________|");
			System.out.println("Error: " + iox + "\n");
		}
		
	}

	public boolean addGiftCard(String name, int number, double balance, int pin, DateTime expiryDate) {
		try {
			this.giftCards.add(new GiftCard(name, number, balance, pin, expiryDate));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	private void updateFile(){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(length);
			out.newLine();
			for (int i = 0 ; i < length; i ++){
				out.write(giftCards.get(i).toString());
				out.newLine();
			}
			out.close();
		}catch (IOException iox){

		}
	}
	public String toString() {
		return "alex gay";
	}

}