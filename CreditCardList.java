import java.io.*;
import java.util.*;

public class CreditCardList {
	private ArrayList<CreditCard> creditCards;
	private String filePath;
	public int length;

	public CreditCardList(ArrayList<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public CreditCardList() {
		this.creditCards = new ArrayList<CreditCard>();
	}

	public CreditCardList(String filePath) {
		this.filePath = filePath;
		CreditCard parsedCreditCard;
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.filePath));
			String input;
			while ((input = in.readLine()) != null) {
				length = Integer.parseInt(input);
				for (int i = 0; i < length; i++) {
					parsedCreditCard = new CreditCard(in.readLine(), Integer.parseInt(in.readLine()),
							Integer.parseInt(in.readLine()), new DateTime(in.readLine()));
					creditCards.add(parsedCreditCard);
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

	public boolean addCreditCard(String name, int number, int pin, DateTime expiryDate) {
		try {
			this.creditCards.add(new CreditCard(name, number, pin, expiryDate));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addCreditCard(CreditCard creditCard) {
		try {
			this.creditCards.add(creditCard);
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

	public void updateFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(length);
			out.newLine();
			for (int i = 0; i < length; i++) {
				out.write(creditCards.get(i).toString());
				out.newLine();
			}
			out.close();
		} catch (IOException iox) {

		}
	}

	public String toString() {
		return "There are " + creditCards.size() + " cards in this list.";
	}

}