/*
File name:     Palladium.java
Description:   
*/

import java.io.*;
import java.util.Scanner;

public class Palladium {
	public static Scanner sc = new Scanner(System.in);

	final static int QUIT_KEY = 0;
	public static SubscriptionList subscriptionList = new SubscriptionList();

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
		System.out.println("| Please select an option:       |");
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
		Login login = new Login();
		String username, password, loginResult;

		do {
			System.out.println("________________________________________");
			System.out.println("");
			System.out.println("Please enter your username: ");
			System.out.print("> ");
			username = Palladium.sc.nextLine();
			System.out.println();
			System.out.println("Please enter your password: ");
			System.out.print("> ");
			password = Palladium.sc.nextLine();
			System.out.println("________________________________________");

			loginResult = login.compareLogin(username, password);

			if (loginResult == "USER_NOT_FOUND") {
				System.out.println("");
				System.out.println(" __________________________________________________");
				System.out.println("|                                                  |");
				System.out.println("| Sorry but we cannot find your account.           |");
				System.out.println("|                                                  |");
				System.out.println("| Please double check your username and your       |");
				System.out.println("| password.                                        |");
				System.out.println("|__________________________________________________|");
				System.out.println("");
			}

		} while (loginResult == "USER_NOT_FOUND");

		System.out.println(" ________________________________________");
		System.out.println("|                                        |");
		System.out.println("| Login is successful                    |");
		System.out.println("|________________________________________|");
		mainMenuUi();
	}

	public static void signUpUi() {
		Login login = new Login();
		String username, password, email, signupResult;

		do {
			System.out.println("________________________________________");
			System.out.println("");
			System.out.println("Please enter your username: ");
			System.out.print("> ");
			username = Palladium.sc.nextLine();
			System.out.println();
			System.out.println("Please enter your email:");
			System.out.print("> ");
			email = Palladium.sc.nextLine();
			System.out.println();
			System.out.println("Please enter your password: ");
			System.out.print("> ");
			password = Palladium.sc.nextLine();
			System.out.println("________________________________________");

			signupResult = login.register(username, password, email);

			if (signupResult.equals("WEAK_PASSWORD")) {
				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Weak Password!                         |");
				System.out.println("|                                        |");
				System.out.println("| Please ensure that your password has:  |");
				System.out.println("| - More than 8 characters               |");
				System.out.println("| - Uppercase and lowercase letter       |");
				System.out.println("| - At least 1 number                    |");
				System.out.println("| - At least 1 special character         |");
				System.out.println("|________________________________________|");
				System.out.println();
			}

			if (signupResult.equals("USERNAME_TAKEN")) {
				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Sorry, but this username has been      |");
				System.out.println("| taken, please select another one.      |");
				System.out.println("|________________________________________|");
				System.out.println();
			}

		} while (signupResult.equals("WEAK_PASSWORD") || signupResult.equals("USERNAME_TAKEN"));

		System.out.println("You're now logged in as: " + signupResult);

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
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Quit Palladium                    (0)  |");
			System.out.println("| Accounts and Payments             (1)  |");
			System.out.println("| Shopping                          (2)  |");
			System.out.println("| Memberships and Subscriptions     (3)  |");
			System.out.println("| Coupons and Giftcards             (4)  |");
			System.out.println("| Notifications                     (5)  |");
			System.out.println("| Search                            (6)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
			userMenuChoice = Palladium.sc.nextInt();
			Palladium.sc.nextLine();

			switch (userMenuChoice) {
			case 0:
				reaffirmQuit();
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
				couponsAndGiftCardsUi();
				break;
			case 5:
				// notifications
				notificationsUi();
				break;
			case 6:
				// search
				searchUi();
				break;
			}
		} while (userMenuChoice != 0);
	}

	public static void reaffirmQuit() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Are you sure you want to quit?         |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("|                                        |");
			System.out.println("| Yes                                (1) |");
			System.out.println("| No                                 (0) |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				System.exit(0);
				break;
			default:
				System.out.println("\nInvalid input.\n");
			}
		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void accountsAndPaymentsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Accounts and Payments                  |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("|                                        |");
			System.out.println("|                                        |");
			System.out.println("|                                        |");
			System.out.println("|                                        |");
			System.out.println("|________________________________________|");

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void shoppingUi() {
		int userShoppingChoice;
		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Shopping                               |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Shopping Cart                     (1)  |");
			System.out.println("| Wishlist                          (2)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
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
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Shopping Cart                          |");
			System.out.println("|                                        |");
			System.out.println("|                                        |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void wishlistUi() {
		int userChoice;

	}

	public static void membershipsAndSubscriptionsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Memberships and Subscriptions          |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Memberships                       (1)  |");
			System.out.println("| Subscription                      (2)  |");
			System.out.println("|________________________________________|");
			System.out.println();

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

		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void membershipsUi() {

	}

	public static void subscriptionsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Subscriptions                          |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| List all Subscriptions            (1)  |");
			System.out.println("| Add Subscription                  (2)  |");
			System.out.println("| Remove a Subscription             (3)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

			switch (userChoice) {
			case 0:
				// do nothing
				break;
			case 1:
				// view all subscriptions
				if (Palladium.subscriptionList.length == 0) {
					// empty subscription list
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No Subscriptions Found                 |");
					System.out.println("|________________________________________|");
				}

				for (int i = 0; i < Palladium.subscriptionList.length; i++) {
					if (i == 0) {
						System.out.println("_________________________________________");
					}
					System.out.println("");
					System.out.println("  Subscription (" + Palladium.subscriptionList.getSubscriptionIndex(i).name
							+ ") #" + (i + 1));
					System.out.println("");
					System.out
							.println("  Name:              " + Palladium.subscriptionList.getSubscriptionIndex(i).name);
					System.out
							.println("  Cost:              " + Palladium.subscriptionList.getSubscriptionIndex(i).cost);
					System.out.println("  Purchased Date:    "
							+ Palladium.subscriptionList.getSubscriptionIndex(i).purchasedDate.toString());
					System.out.println("  Expiry Date:       "
							+ Palladium.subscriptionList.getSubscriptionIndex(i).expiryDate.toString());
					System.out.println(
							"  Times Renewed:     " + Palladium.subscriptionList.getSubscriptionIndex(i).timesRenewed);
					System.out.println("_________________________________________");
				}
				break;
			case 2:
				// add a subscription
				String name;
				double cost;
				Date purchasedDate, expiryDate;
				int timesRenewed;

				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Add a new subscription                 |");
				System.out.println("|________________________________________|");
				System.out.println("\nPlease enter your details below\n");

				System.out.println("Please enter the name:");
				System.out.print("> ");
				Palladium.sc.nextLine();
				name = Palladium.sc.nextLine();

				System.out.println("Please enter the cost of the subscription per month:");
				System.out.print("> ");
				cost = Palladium.sc.nextDouble();
				Palladium.sc.nextLine();

				System.out.println("Please enter the date when you purchased the subscription:");
				System.out.print("> ");
				purchasedDate = new Date(Palladium.sc.nextLine());

				System.out.println("Please enter when your subscription renews:");
				System.out.print("> ");
				expiryDate = new Date(Palladium.sc.nextLine());

				System.out.println("Please enter how many times you renewed this subscription:");
				System.out.print("> ");
				timesRenewed = Palladium.sc.nextInt();
				Palladium.sc.nextLine();

				Subscription newSubscription = new Subscription(name, cost, purchasedDate, expiryDate, timesRenewed);

				boolean validAdd = Palladium.subscriptionList.addSubscription(newSubscription);

				if (validAdd) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Subscription has been added            |");
					System.out.println("|________________________________________|");
					System.out.println();
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Error adding subscription, please      |");
					System.out.println("| try again.                             |");
					System.out.println("|________________________________________|");
					System.out.println();
				}
				break;

			case 3:
				int indexToRemove;
				boolean validRemove;
			
				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Remove a subscription                  |");
				System.out.println("|________________________________________|");
				System.out.println("");

				System.out.println("Please enter an index to remove:");
				System.out.print("> ");
				indexToRemove = Palladium.sc.nextInt();
				Palladium.sc.nextLine();

				validRemove = Palladium.subscriptionList.removeSubscription(indexToRemove);

				if (validRemove) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Successful removal of subscription     |");
					System.out.println("|________________________________________|");
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Removal failed, please try again.      |");
					System.out.println("| Please check the index you entered.    |");
					System.out.println("|________________________________________|");
				}

				break;
			}

		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void couponsAndGiftCardsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Coupons and Gift Cards                 |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
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

		} while (userChoice != Palladium.QUIT_KEY);

	}

	public static void couponsUi() {
		System.out.println("coupons ui");
	}

	public static void giftCardUi() {
		System.out.println("gift card ui");
	}

	public static void notificationsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Notifications                          |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Display All                       (1)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				// display all notifications
				break;
			}
		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void searchUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Search                                 |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| I don't know                      (1)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			System.out.print("> ");
			userChoice = Palladium.sc.nextInt();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				break;
			}
		} while (userChoice != Palladium.QUIT_KEY);

	}

}