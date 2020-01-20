/*
Name:         CreditCardList.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for storing the
              the credit cards in class form and allowing the
              user to manipulate the list by adding, removing,
              and searching. Additionally, it manages the parsing,
              reading, and writing of the credit card to the text file.
*/

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
		creditCards = new ArrayList<CreditCard>();
		try {
			/*
			We should first try and parse the user's credit cards from the file.
			 */
			BufferedReader in = new BufferedReader(new FileReader(this.filePath));
			String input = in.readLine();
			length = Integer.parseInt(input) - 1;
			for (int i = 0; i < length; i++) {
				parsedCreditCard = new CreditCard(in.readLine(), Integer.parseInt(in.readLine()),
						Integer.parseInt(in.readLine()), new DateTime(in.readLine()));
				creditCards.add(parsedCreditCard);

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

	// Allows the user to add a CreditCard to the ArrayList with an object
	public boolean addCreditCard(CreditCard creditCard) {
		try {
			this.creditCards.add(creditCard);
			length++;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Allows the user to obtain a CreditCard object with the index
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

	// Allows the user to write the database to the text file.
	public void updateFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write("" + length);
			out.newLine();
			for (int i = 0; i < length; i++) {
				/*
				 * out.write(creditCards.get(i).getName()); out.newLine();
				 * out.write(""+creditCards.get(i).getNumber()); out.newLine();
				 * out.write(""+creditCards.get(i).getPin()); out.newLine();
				 * out.write(creditCards.get(i).getExpiryDate().toString());
				 * 
				 */
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