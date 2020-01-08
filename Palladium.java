/*
File name:     Palladium.java
Description:   
*/

import java.io.*;
import java.util.Scanner;

public class Palladium {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// starts the program, welcomeUi() will call all the other methods
		welcomeUi();
	}

	public static void welcomeUi() {
		System.out.println(" ________________________________");
		System.out.println("|                                |");
		System.out.println("| Welcome to Palladium           |");
		System.out.println("| The financial toolkit          |");
		System.out.println("|                                |");
		System.out.println("| Login                     (1)  |");
		System.out.println("| Signup                    (2)  |");
		System.out.println("|________________________________|");
		System.out.println("");

		int userWelcomeChoice = 0;
		while (userWelcomeChoice != 1 || userWelcomeChoice != 2) {
			System.out.print("> ");
			userWelcomeChoice = Palladium.sc.nextInt();
			// flush the input:
			Palladium.sc.nextLine();

			if (userWelcomeChoice == 1) {
				logInUi();
			} else if (userWelcomeChoice == 2) {
				signUpUi();
			}
		}
	}

	public static void logInUi() {
		String username, password;

		System.out.println("");
		System.out.println("Please enter your username: ");
		System.out.print("> ");
		username = Palladium.sc.nextLine();
		System.out.println("Please enter your password: ");
		System.out.print("> ");
		password = Palladium.sc.nextLine();

		// temp:
		mainMenuUi();
	}

	public static void signUpUi() {
		String username, password;

		System.out.println("");
		System.out.println("Please enter your username: ");
		System.out.print("> ");
		username = Palladium.sc.nextLine();
		System.out.println("Please enter your password: ");
		System.out.print("> ");
		password = Palladium.sc.nextLine();

		// temp:
		mainMenuUi();

	}

	public static void mainMenuUi() {
		int userMenuChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Palladium Menu                         |");
			System.out.println("|                                        |");
			System.out.println("| Accounts and Payments             (1)  |");
			System.out.println("| Shopping                          (2)  |");
			System.out.println("| Memberships and Subscriptions     (3)  |");
			System.out.println("| Coupons and Giftcards             (4)  |");
			System.out.println("| Notifications                     (5)  |");
			System.out.println("| Search                            (6)  |");
			System.out.println("|________________________________________|");

			System.out.print("> ");
			userMenuChoice = Palladium.sc.nextInt();
			Palladium.sc.nextLine();

			switch (userMenuChoice) {
			case 0:
				// do nothing so it goes back
				break;
			case 1:
				// redirect to accounts and payments
				accountsAndPaymentsUi();
				break;
			case 2:
				// redirect to shopping
				shoppingUi();

				break;
			case 3:
				// redirect to Memberships and Subscriptions
				membershipsAndSubscriptionsUi();

				break;
			case 4:
				// coupons and giftcards

				break;
			case 5:
				// notifications
				break;
			case 6:
				// serach
				break;
			}
		} while (userMenuChoice != 0);
	}

	public static void accountsAndPaymentsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Accounts and Payments                  |");
			System.out.println("|________________________________________|");

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

		} while (userChoice != 0);
	}

	public static void shoppingUi() {
		int userShoppingChoice;
		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Shopping                               |");
			System.out.println("|                                        |");
			System.out.println("| Shopping Cart                     (1)  |");
			System.out.println("| Wishlist                          (2)  |");
			System.out.println("|________________________________________|");

			System.out.print("Please enter a choice: ");
			userShoppingChoice = Palladium.sc.nextInt();

			switch (userShoppingChoice) {
			case 1:
				// shopping cart
				shoppingCartUi();
				break;
			case 2:
				// wishlist
				wishlistUi();
				break;
			default:
				System.out.println("Invalid input.");
			}
		} while (userShoppingChoice != 0);
	}

	public static void shoppingCartUi() {

	}

	public static void wishlistUi() {

	}

	public static void membershipsAndSubscriptionsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Memberships and Subscriptions          |");
			System.out.println("|                                        |");
			System.out.println("| Memberships                       (1)  |");
			System.out.println("| Subscription                      (2)  |");
			System.out.println("|________________________________________|");

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

			switch (userChoice) {
			case 0:
				// do nothing
				break;
			case 1:
				membershipsUi();
				break;
			case 2:
				subscriptionsUi();
				break;
			default:
				System.out.println("Invalid input.");
			}

		} while (userChoice != 0);
	}

	public static void membershipsUi() {

	}

	public static void subscriptionsUi() {

	}

	public static void couponsAndGiftCardsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Coupons and Gift Cards                 |");
			System.out.println("|                                        |");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Coupons                           (1)  |");
			System.out.println("| Gift Cards                        (2)  |");
			System.out.println("|________________________________________|");

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

			switch (userChoice) {
				case 0:
				// does nothing
				break;
				case 1:
					couponsUi();
					break;
				case 2:
					giftCardUi();
					break;
				default:
			}

		} while (userChoice != 0);

	}

	public static void couponsUi() {
		System.out.println("coupons ui");
	}

	public static void giftCardUi() {
		System.out.println("gift card ui");
	}

}