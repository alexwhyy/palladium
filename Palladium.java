/*
File name:     Palladium.java
Description:   
*/

import java.io.*;
import java.lang.reflect.Member;
import java.util.Scanner;

public class Palladium {
	public static Scanner sc = new Scanner(System.in);
	final static int QUIT_KEY = 0;
	public static String currentUser;
	public static SubscriptionList subscriptionList;
	public static CouponList couponList;
	public static GiftCardList giftCardList;
	public static WishList wishList;
	public static NotificationList notificationList;
	public static ShoppingCart shoppingCart;
	public static MembershipList membershipList;
	public static CreditCardList creditCardList;
	public static String filePath;
	public static String accountListPath;
	public static String accountPath;
	public static Catalog catalog;

	public static void main(String[] args) {

		// starts the program, welcomeUi() will call all the other methods
		initconfig();
		welcomeUi();
	}

	static void initconfig() {
		filePath = System.getProperty("user.dir") + "\\palladium";
		catalog = new Catalog(filePath + "catalog.txt");
		System.out.println(filePath);
		File file = new File(filePath);
		file.mkdir();
		accountListPath = filePath + "\\accountList.txt";
		file = new File(accountListPath);
		if (!(file.exists())) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(accountListPath));
				out.write("0");
				out.close();
			} catch (IOException iox) {

			}
		}

	}

	static String getStringInput() {
		String userInput;

		System.out.print("> ");
		userInput = sc.nextLine();

		return userInput;
	}

	static int getIntInput() {
		String userInputString;
		int userInputInt = 0;
		boolean validInput = false;

		do {
			System.out.print("> ");
			userInputString = sc.nextLine();

			try {
				userInputInt = Integer.parseInt(userInputString);
				validInput = true;
			} catch (Exception e) {
				System.out.println("\nInvalid input, please try again.\n");
			}
		} while (!validInput);

		return userInputInt;
	}

	static double getDoubleInput() {
		String userInputString;
		double userInputDouble = 0;
		boolean validInput = false;

		do {
			System.out.print("> ");
			userInputString = sc.nextLine();

			try {
				userInputDouble = Double.parseDouble(userInputString);
				validInput = true;
			} catch (Exception e) {
				System.out.println("\nInvalid input, please try again.\n");
			}
		} while (!validInput);

		return userInputDouble;
	}

	static DateTime getDateInput() {
		String userInputString;
		DateTime userInputDate = null;

		boolean validInput = false;

		do {
			System.out.print("> ");
			userInputString = sc.nextLine();

			try {
				userInputDate = new DateTime(userInputString);
				validInput = DateTime.verifyDate(userInputDate);
			} catch (Exception e) {
				System.out.println("\nInvalid input, please try again.\n");
			}
		} while (!validInput);

		return userInputDate;
	}

	public static void welcomeUi() {
		System.out.println(" __________________________________________________");
		System.out.println("|                                                  |");
		System.out.println("| Welcome to Palladium                             |");
		System.out.println("| The financial toolkit                            |");
		System.out.println("|                                                  |");
		System.out.println("| Please select an option:                         |");
		System.out.println("| Login                                       (1)  |");
		System.out.println("| Signup                                      (2)  |");
		System.out.println("|__________________________________________________|");
		System.out.println("");

		int userWelcomeChoice = 0;
		while (userWelcomeChoice != 1 || userWelcomeChoice != 2) {

			userWelcomeChoice = Palladium.getIntInput();

			if (userWelcomeChoice == 1) {
				logInUi();
			} else if (userWelcomeChoice == 2) {
				signUpUi();
			}
		}
	}

	public static void logInUi() {
		Login login = new Login(filePath);
		String username, password, loginResult;

		do {
			System.out.println(" __________________________________________________");
			System.out.println("");
			System.out.println("Please enter your username: ");
			username = Palladium.getStringInput();
			System.out.println();
			System.out.println("Please enter your password: ");
			password = Palladium.getStringInput();
			System.out.println(" __________________________________________________");

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

		currentUser = username;

		System.out.println(" ________________________________________");
		System.out.println("|                                        |");
		System.out.println("| Login is successful                    |");
		System.out.println("|________________________________________|");
		// loadDataUi();
		accountConfig();
	}

	public static void signUpUi() {
		Login login = new Login(filePath);
		String username, password, email, signupResult;

		do {
			System.out.println(" __________________________________________________");
			System.out.println("");
			System.out.println("Please enter your username: ");
			username = Palladium.getStringInput();
			System.out.println();
			System.out.println("Please enter your email:");
			email = Palladium.getStringInput();
			System.out.println();
			System.out.println("Please enter your password: ");
			password = Palladium.getStringInput();
			System.out.println(" __________________________________________________");

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

		currentUser = username;
		System.out.println("You're now logged in as: " + username);
		filePath = filePath + "//" + username;
		File file = new File(filePath);
		file.mkdir();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath + "\\ShoppingCart.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\WishList.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\CouponList.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\CreditCardList.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\GiftCard.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\NotificationList.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\SubscriptionList.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\MembershipList.txt"));
			out.write("0");
			out.close();
			out = new BufferedWriter(new FileWriter(filePath + "\\shoppingCart.txt"));
			out.write("0");
			out.close();

		} catch (IOException iox) {
			System.out.println("Failed to load files.");
		}

		accountConfig();
	}

	static void accountConfig() {
		subscriptionList = new SubscriptionList(filePath + "\\SubsciptionList.txt");
		couponList = new CouponList(filePath + "\\CouponList.txt");
		membershipList = new MembershipList(filePath + "\\MembershipList.txt");
		creditCardList = new CreditCardList(filePath + "\\CreditCardList.txt");
		shoppingCart = new ShoppingCart(filePath + "\\ShoppingCart.txt");
		wishList = new WishList(filePath + "WishList.txt");
		giftCardList = new GiftCardList(filePath + "GiftCardList.txt");
		notificationList = new NotificationList(filePath + "NotificationList.txt");
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

			userMenuChoice = Palladium.getIntInput();

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
			System.out.println("| No                                 (0) |");
			System.out.println("| Yes                                (1) |");
			System.out.println("|________________________________________|");
			System.out.println();

			userChoice = Palladium.getIntInput();

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
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Credit Cards                      (1)  |");
			System.out.println("| Website Accounts                  (2)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				// do nothing
				break;
			case 1:
				// credit cards
				creditCardUi();
				break;
			case 2:
				// website accounts
				websiteAccountsUi();
				break;
			}

		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void creditCardUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("|  Credit Cards                          |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| List all Credit Cards             (1)  |");
			System.out.println("| Add a Credit Card                 (2)  |");
			System.out.println("| Remove a Credit Card              (3)  |");
			System.out.println("| Edit a Credit Card                (4)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				if (Palladium.creditCardList.length == 0) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No Credit Cards                        |");
					System.out.println("|________________________________________|");
				}

				for (int i = 0; i < Palladium.creditCardList.length; i++) {
					if (i == 0) {
						System.out.println("_________________________________________");
					}
					System.out.println("");
					System.out.println("  Credit Card (" + Palladium.creditCardList.getCreditCardIndex(i).getName()
							+ ") #" + (i + 1));
					System.out.println("");
					System.out.println(
							"  Name:              " + Palladium.creditCardList.getCreditCardIndex(i).getName());
					System.out.println(
							"  Number:              " + Palladium.creditCardList.getCreditCardIndex(i).getNumber());
					System.out.println("  Pin:    " + Palladium.creditCardList.getCreditCardIndex(i).getPin());
					System.out.println("  Expiry Date:       "
							+ Palladium.creditCardList.getCreditCardIndex(i).getExpiryDate().toString());

					System.out.println("_________________________________________");
				}
				break;
			case 2:
				String name;
				int number;
				int pin;
				DateTime expiryDate;

				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Add a new credit card                  |");
				System.out.println("|________________________________________|");
				System.out.println("\nPlease enter your details below\n");

				System.out.println("Please enter the name:");
				name = Palladium.getStringInput();

				System.out.println("Please enter the card number:");
				number = Palladium.getIntInput();

				System.out.println("Please enter the pin of the card:");
				pin = Palladium.getIntInput();

				System.out.println("Please enter the expiry date:");
				expiryDate = Palladium.getDateInput();

				CreditCard newCreditCard = new CreditCard(name, number, pin, expiryDate);

				if (Palladium.creditCardList.addCreditCard(newCreditCard)) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Credit card has been added             |");
					System.out.println("|________________________________________|");
					System.out.println();
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Error adding card, please              |");
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
				System.out.println("| Remove a credit card                   |");
				System.out.println("|________________________________________|");
				System.out.println("");

				System.out.println("Please enter an index to remove:");
				indexToRemove = Palladium.getIntInput();
				indexToRemove--;

				validRemove = Palladium.creditCardList.removeCreditCard(indexToRemove);

				if (validRemove) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Successful removal of credit card      |");
					System.out.println("|________________________________________|");
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Removal failed, please try again.      |");
					System.out.println("| Please check the index you entered.    |");
					System.out.println("|________________________________________|");
				}
				break;
			case 4:
				if (Palladium.creditCardList.length > 0) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Edit a credit card                     |");
					System.out.println("|________________________________________|");
					System.out.println("");

					int indexToEdit;
					do {
						System.out.println("Please enter the index to edit:");
						indexToEdit = Palladium.getIntInput();
						indexToEdit--;

						if (indexToEdit < 0 || indexToEdit > Palladium.creditCardList.length) {
							System.out.println("\nInvalid index, please select another one.\n");
						}
					} while (indexToEdit < 0 || indexToEdit > Palladium.creditCardList.length);

					CreditCard creditCardToEdit = Palladium.creditCardList.getCreditCardIndex(indexToEdit);

					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Please select an option                |");
					System.out.println("|________________________________________|");
					System.out.println("| Edit Name                         (1)  |");
					System.out.println("| Edit Number                       (2)  |");
					System.out.println("| Edit Pin                          (3)  |");
					System.out.println("| Edit Expiry Date                  (4)  |");
					System.out.println("|________________________________________|");
					System.out.println("");

					int optionToEdit;
					optionToEdit = Palladium.getIntInput();

					String newName;
					int newNumber;
					int newPin;
					DateTime newExpiryDate;

					switch (optionToEdit) {
					case 1:
						System.out.println("Please enter the new name: ");
						newName = Palladium.getStringInput();
						creditCardToEdit.setName(newName);
						break;
					case 2:
						System.out.println("Please enter the new number:");
						newNumber = Palladium.getIntInput();
						creditCardToEdit.setNumber(newNumber);
						break;
					case 3:
						System.out.println("Please enter the new pin:");
						newPin = Palladium.getIntInput();
						creditCardToEdit.setPin(newPin);
						break;
					case 4:
						System.out.println("Please enter the new expiry date:");
						newExpiryDate = Palladium.getDateInput();
						creditCardToEdit.setExpiryDate(newExpiryDate);
						break;
					default:
						System.out.println("\nInvalid option added.");
					}
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No credit cards to edit                |");
					System.out.println("|________________________________________|");
				}
				break;
			case 5:
				// view credit card statistics
				break;
			}

		} while (userChoice != 0);
	}

	public static void websiteAccountsUi() {
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

			userShoppingChoice = Palladium.getIntInput();

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

			userChoice = Palladium.getIntInput();

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

			userChoice = Palladium.getIntInput();

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
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Memberships                           |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| List all Memberships              (1)  |");
			System.out.println("| Add Membership                    (2)  |");
			System.out.println("| Remove a Membership               (3)  |");
			System.out.println("| Edit a Membership                 (4)  |");
			System.out.println("| View Membership Statistics        (5)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				// do nothing
				break;
			case 1:
				// view all memberships
				if (Palladium.membershipList.length == 0) {
					// empty membership list
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No Memberships Found                   |");
					System.out.println("|________________________________________|");
				}

				for (int i = 0; i < Palladium.membershipList.length; i++) {
					if (i == 0) {
						System.out.println("_________________________________________");
					}
					System.out.println("");
					System.out.println("  Subscription (" + Palladium.membershipList.getMembershipIndex(i).getName()
							+ ") #" + (i + 1));
					System.out.println("");
					System.out.println(
							"  Name:              " + Palladium.membershipList.getMembershipIndex(i).getName());
					System.out.println(
							"  Cost:              " + Palladium.membershipList.getMembershipIndex(i).getCost());
					System.out.println("  Purchased Date:    "
							+ Palladium.membershipList.getMembershipIndex(i).getPurchasedDate().toString());
					System.out.println("  Expiry Date:       "
							+ Palladium.membershipList.getMembershipIndex(i).getExpiryDate().toString());
					System.out.println(
							"  Times Renewed:     " + Palladium.membershipList.getMembershipIndex(i).getTimesRenewed());

					System.out.println(
							"  Discount:         " + Palladium.membershipList.getMembershipIndex(i).getDiscount());

					System.out.println("  Membership ID:    "
							+ Palladium.membershipList.getMembershipIndex(i).getMembershipNumber());

					System.out.println("_________________________________________");
				}
				break;
			case 2:
				String name;
				double cost;
				DateTime purchasedDate, expiryDate;
				int timesRenewed;
				double discount;
				String membershipNumber;

				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Add a new membership                   |");
				System.out.println("|________________________________________|");
				System.out.println("\nPlease enter your details below\n");

				System.out.println("Please enter the name:");
				name = Palladium.getStringInput();

				System.out.println("Please enter the cost of the subscription per month:");
				cost = Palladium.getDoubleInput();

				System.out.println("Please enter the date when you purchased the subscription:");
				purchasedDate = Palladium.getDateInput();

				System.out.println("Please enter when your subscription renews:");
				expiryDate = Palladium.getDateInput();

				System.out.println("Please enter how many times you renewed this subscription:");
				timesRenewed = Palladium.getIntInput();

				System.out.println("Please enter the discount you recieve with this membership:");
				discount = Palladium.getDoubleInput();

				System.out.println("Please enter the membership number (optional):");
				membershipNumber = Palladium.getStringInput();

				Membership newMembership = new Membership(name, cost, purchasedDate, expiryDate, timesRenewed, discount,
						membershipNumber);

				if (Palladium.membershipList.addMembership(newMembership)) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Membership has been added              |");
					System.out.println("|________________________________________|");
					System.out.println();
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Error adding membership, please        |");
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
				System.out.println("| Remove a membership                    |");
				System.out.println("|________________________________________|");
				System.out.println("");

				System.out.println("Please enter an index to remove:");
				indexToRemove = Palladium.getIntInput();
				indexToRemove--;

				validRemove = Palladium.membershipList.removeMembership(indexToRemove);

				if (validRemove) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Successful removal of membership       |");
					System.out.println("|________________________________________|");
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Removal failed, please try again.      |");
					System.out.println("| Please check the index you entered.    |");
					System.out.println("|________________________________________|");
				}
				break;
			case 4:
				if (Palladium.membershipList.length > 0) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Edit a membership                      |");
					System.out.println("|________________________________________|");
					System.out.println("");

					int indexToEdit;
					do {
						System.out.println("Please enter the index to edit:");
						indexToEdit = Palladium.getIntInput();
						indexToEdit--;

						if (indexToEdit < 0 || indexToEdit > Palladium.membershipList.length) {
							System.out.println("\nInvalid index, please select another one.\n");
						}
					} while (indexToEdit < 0 || indexToEdit > Palladium.membershipList.length);

					Membership membershipToEdit = Palladium.membershipList.getMembershipIndex(indexToEdit);

					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Please select an option                |");
					System.out.println("|________________________________________|");
					System.out.println("| Edit Name                         (1)  |");
					System.out.println("| Edit Cost                         (2)  |");
					System.out.println("| Edit Purchased Date               (3)  |");
					System.out.println("| Edit Renew Date                   (4)  |");
					System.out.println("| Edit Times Renewed                (5)  |");
					System.out.println("| Edit Discount                     (6)  |");
					System.out.println("| Edit Memebership Number           (7)  |");
					System.out.println("|________________________________________|");
					System.out.println("");

					int optionToEdit;
					optionToEdit = Palladium.getIntInput();

					String newName;
					double newCost;
					DateTime newExpiryDate, newRenewDate;
					int newTimesRenewed;
					double newDiscount;
					String newMembershipNumber;

					switch (optionToEdit) {
					case 1:
						System.out.println("Please enter the new name: ");
						newName = Palladium.getStringInput();
						membershipToEdit.setName(newName);
						break;
					case 2:
						System.out.println("Please enter the new cost:");
						newCost = Palladium.getDoubleInput();
						membershipToEdit.setCost(newCost);
						break;
					case 3:
						System.out.println("Please enter the new purchased date:");
						newExpiryDate = Palladium.getDateInput();
						membershipToEdit.setPurchasedDate(newExpiryDate);
						break;
					case 4:
						System.out.println("Please enter the new renew date:");
						newRenewDate = Palladium.getDateInput();
						membershipToEdit.setPurchasedDate(newRenewDate);
						break;
					case 5:
						System.out.println("Please enter how many times you have renewed:");
						newTimesRenewed = Palladium.getIntInput();
						membershipToEdit.setTimesRenewed(newTimesRenewed);
						break;
					case 6:
						System.out.println("Please enter the discount you recieve with this membership:");
						newDiscount = Palladium.getDoubleInput();
						membershipToEdit.setDiscount(newDiscount);
						break;
					case 7:
						System.out.println("Please enter your new subscription ID:");
						newMembershipNumber = Palladium.getStringInput();
						membershipToEdit.setMembershipNumber(newMembershipNumber);
						break;
					default:
						System.out.println("\nInvalid option added.");
					}
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No memberships to edit                 |");
					System.out.println("|________________________________________|");
				}
				break;
			case 5:
				break;
			}

		} while (userChoice != 0);

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
			System.out.println("| Edit a Subscription               (4)  |");
			System.out.println("| View Subscription Statistics      (5)  |");
			System.out.println("|________________________________________|");
			System.out.println();

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				if (Palladium.subscriptionList.length == 0) {
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
					System.out.println("  Subscription (" + Palladium.subscriptionList.getSubscriptionIndex(i).getName()
							+ ") #" + (i + 1));
					System.out.println("");
					System.out.println(
							"  Name:              " + Palladium.subscriptionList.getSubscriptionIndex(i).getName());

					System.out.println(
							"  Cost:              " + Palladium.subscriptionList.getSubscriptionIndex(i).getCost());

					System.out.println("  Purchased Date:    "
							+ Palladium.subscriptionList.getSubscriptionIndex(i).getPurchasedDate().toString());

					System.out.println("  Expiry Date:       "
							+ Palladium.subscriptionList.getSubscriptionIndex(i).getExpiryDate().toString());

					System.out.println("  Times Renewed:     "
							+ Palladium.subscriptionList.getSubscriptionIndex(i).getTimesRenewed());
					System.out.println("_________________________________________");
				}
				break;

			case 2:
				// add a subscription
				String name;
				double cost;
				DateTime purchasedDate, expiryDate;
				int timesRenewed;

				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Add a new subscription                 |");
				System.out.println("|________________________________________|");
				System.out.println("\nPlease enter your details below\n");

				System.out.println("Please enter the name:");
				name = Palladium.getStringInput();

				System.out.println("Please enter the cost of the subscription per month:");
				cost = Palladium.getDoubleInput();

				System.out.println("Please enter the date when you purchased the subscription:");
				purchasedDate = Palladium.getDateInput();

				System.out.println("Please enter when your subscription renews:");
				expiryDate = Palladium.getDateInput();

				System.out.println("Please enter how many times you renewed this subscription:");
				timesRenewed = Palladium.getIntInput();

				Subscription newSubscription = new Subscription(name, cost, purchasedDate, expiryDate, timesRenewed);

				if (Palladium.subscriptionList.addSubscription(newSubscription)) {
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
				indexToRemove = Palladium.getIntInput();
				indexToRemove--;

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

			case 4:
				if (Palladium.subscriptionList.length > 0) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Edit a subscription                    |");
					System.out.println("|________________________________________|");
					System.out.println("");

					int indexToEdit;
					do {
						System.out.println("Please enter the index to edit:");
						indexToEdit = Palladium.getIntInput();
						indexToEdit--;

						if (indexToEdit < 0 || indexToEdit > Palladium.subscriptionList.length) {
							System.out.println("\nInvalid index, please select another one.\n");
						}
					} while (indexToEdit < 0 || indexToEdit > Palladium.subscriptionList.length);

					Subscription subscriptionToEdit = Palladium.subscriptionList.getSubscriptionIndex(indexToEdit);

					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Please select an option                |");
					System.out.println("|________________________________________|");
					System.out.println("| Edit Name                         (1)  |");
					System.out.println("| Edit Cost                         (2)  |");
					System.out.println("| Edit Purchased Date               (3)  |");
					System.out.println("| Edit Renew Date                   (4)  |");
					System.out.println("| Edit Times Renewed                (5)  |");
					System.out.println("|________________________________________|");
					System.out.println("");

					int optionToEdit;
					optionToEdit = Palladium.getIntInput();

					String newName;
					double newCost;
					DateTime newExpiryDate, newRenewDate;

					switch (optionToEdit) {
					case 1:
						System.out.println("Please enter the new name: ");
						newName = Palladium.getStringInput();
						subscriptionToEdit.setName(newName);
						break;
					case 2:
						System.out.println("Please enter the new cost:");
						newCost = Palladium.getDoubleInput();
						subscriptionToEdit.setCost(newCost);
						break;
					case 3:
						System.out.println("Please enter the new purchased date:");
						newExpiryDate = Palladium.getDateInput();
						subscriptionToEdit.setPurchasedDate(newExpiryDate);
						break;
					case 4:
						System.out.println("Please enter the new renew date:");
						newRenewDate = Palladium.getDateInput();
						subscriptionToEdit.setPurchasedDate(newRenewDate);
						break;
					default:
						System.out.println("\nInvalid option added.");
					}
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No subscriptions to edit               |");
					System.out.println("|________________________________________|");
				}
			case 5:
				// calculate subscriptions
				Palladium.subscriptionList.updateCost();

				System.out.println("_________________________________________");
				System.out.println("");
				System.out.println("  All Subscription Statistics");
				System.out.println("  These costs are for all your");
				System.out.println("  subscriptions combined.");
				System.out.println("");
				System.out.println("  Montly Cost:		" + Palladium.subscriptionList.getMontlyCost());
				System.out.println("  Annual Cost:		" + Palladium.subscriptionList.getAnnualCost());
				System.out.println("  Total Spent:		" + Palladium.subscriptionList.getTotalSpent());
				System.out.println("_________________________________________");
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
			System.out.println("");

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				couponsUi();
				break;
			case 2:
				giftCardUi();
				break;
			default:
				System.out.println("\nInvalid input.\n");
			}

		} while (userChoice != Palladium.QUIT_KEY);

	}

	public static void couponsUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Coupons                                |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Display All Coupons               (1)  |");
			System.out.println("| Add Coupon                        (2)  |");
			System.out.println("| Remove a Coupon                   (3)  |");
			System.out.println("|________________________________________|");
			System.out.println("");

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				if (Palladium.couponList.length == 0) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No Coupons Found                       |");
					System.out.println("|________________________________________|");
				}

				for (int i = 0; i < Palladium.couponList.length; i++) {
					if (i == 0) {
						System.out.println("_________________________________________");
					}
					System.out.println("");
					System.out
							.println("  Coupon (" + Palladium.couponList.getCouponIndex(i).getName() + ") #" + (i + 1));
					System.out.println("");
					System.out.println("  Name:          " + Palladium.couponList.getCouponIndex(i).getName());
					System.out.println("  Retailer:      " + Palladium.couponList.getCouponIndex(i).getRetailer());
					System.out.println("  Discount:      " + Palladium.couponList.getCouponIndex(i).getDiscount());
					System.out.println(
							"  Expiry Date:   " + Palladium.couponList.getCouponIndex(i).getExpiryDate().toString());
					System.out.println("_________________________________________");
				}
				break;
			case 2:
				Coupon newCoupon;

				String name, retailer;
				double discount;
				DateTime expiryDate;

				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| Add a new coupon                       |");
				System.out.println("|________________________________________|");
				System.out.println("\nPlease enter your details below\n");

				System.out.println("Please enter a name for your coupon:");
				name = Palladium.getStringInput();

				System.out.println("Please enter the retailer of your coupon:");
				retailer = Palladium.getStringInput();

				System.out.println("Please enter the monetary discount of your coupon:");
				discount = Palladium.getDoubleInput();

				System.out.println("Please enter the date when the coupon expires:");
				expiryDate = Palladium.getDateInput();

				newCoupon = new Coupon(name, retailer, discount, expiryDate);

				if (Palladium.couponList.addCoupon(newCoupon)) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Coupon has been added                  |");
					System.out.println("|________________________________________|");
					System.out.println();
				} else {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| Error, coupon could not be added.      |");
					System.out.println("| Please try again.                      |");
					System.out.println("|________________________________________|");
					System.out.println();
				}

				break;
			}

		} while (userChoice != Palladium.QUIT_KEY);
	}

	public static void giftCardUi() {
		int userChoice;

		do {
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Gift Cards                             |");
			System.out.println("|                                        |");
			System.out.println("| Please select an option:               |");
			System.out.println("|________________________________________|");
			System.out.println("| Go Back                           (0)  |");
			System.out.println("| Display all Credit Cards          (1)  |");
			System.out.println("| Add a Credit Card                 (2)  |");
			System.out.println("| Remove a Credit Card              (3)  |");
			System.out.println("|________________________________________|");
			System.out.println("");

			userChoice = Palladium.getIntInput();
		} while (userChoice != Palladium.QUIT_KEY);

		switch (userChoice) {
		case 0:
			break;
		case 1:
			if (Palladium.couponList.length == 0) {
				System.out.println(" ________________________________________");
				System.out.println("|                                        |");
				System.out.println("| No Gift Cards Found                    |");
				System.out.println("|________________________________________|");
			}

			for (int i = 0; i < Palladium.couponList.length; i++) {
				if (i == 0) {
					System.out.println("_________________________________________");
				}
				System.out.println("");
				System.out
						.println("  Gift Card (" + Palladium.couponList.getCouponIndex(i).getName() + ") #" + (i + 1));
				System.out.println("");
				System.out.println("  Name:          " + Palladium.couponList.getCouponIndex(i).getName());
				System.out.println("  Retailer:      " + Palladium.couponList.getCouponIndex(i).getRetailer());
				System.out.println("  Discount:      " + Palladium.couponList.getCouponIndex(i).getDiscount());
				System.out.println(
						"  Expiry Date:   " + Palladium.couponList.getCouponIndex(i).getExpiryDate().toString());
				System.out.println("_________________________________________");
			}

			break;
		case 2:
			// add a credit card
			System.out.println(" ________________________________________");
			System.out.println("|                                        |");
			System.out.println("| Add a new gift card                    |");
			System.out.println("|________________________________________|");
			System.out.println("\nPlease enter your details below\n");

			break;
		case 3:
			// remove a credit card
		}

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

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				if (Palladium.notificationList.length == 0) {
					System.out.println(" ________________________________________");
					System.out.println("|                                        |");
					System.out.println("| No Notifications Found                 |");
					System.out.println("|________________________________________|");
				}

				for (int i = 0; i < Palladium.notificationList.length; i++) {
					if (i == 0) {
						System.out.println("_________________________________________");
					}
					System.out.println("");
					System.out.println("  Notification ("
							+ Palladium.notificationList.getNotificationIndex(i).getTitle() + ") #" + (i + 1));
					System.out.println("");
					System.out.println(
							"  Title:         " + Palladium.notificationList.getNotificationIndex(i).getTitle());
					System.out.println(
							"  Time Created:  " + Palladium.notificationList.getNotificationIndex(i).getTimeCreated());
					System.out.println(
							"  Content:      " + Palladium.notificationList.getNotificationIndex(i).getContent());
					System.out.println("_________________________________________");
				}

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

			userChoice = Palladium.getIntInput();

			switch (userChoice) {
			case 0:
				break;
			case 1:
				break;
			}
		} while (userChoice != Palladium.QUIT_KEY);

	}

}