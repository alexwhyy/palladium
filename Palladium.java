/*
File name:     Palladium.java
Description:   
*/

import java.io.*;
import java.util.Scanner;

public class Palladium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// starts the program, welcomeUi() will call all the other methods
		welcomeUi();
	}

	public static void welcomeUi() {
		System.out.println(" ________________________________");
		System.out.println("|                                |");
		System.out.println("| Welcome to Palladium           |");
		System.out.println("| The financial toolkit          |");
		System.out.println("|________________________________|")
		System.out.println("");

		int userWelcomeChoice = 0;
		while (userWelcomeChoice != 1 || userWelcomeChoice != 2) {
			System.out.println("Enter (1) for login, (2) for signup.");
			System.out.print("> ");
			int userWelcomeChoice = sc.nextInt();

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
		username = sc.nextLine();
		System.out.println("Please enter your password: ");
		System.out.print("> ");
		password = sc.nextLine();
	}

	public static void signUpUi() {

	}

	public static void mainMenuUi() {
		System.out.println(" ________________________________________");
		System.out.println("|                                        |");
		System.out.println("| Palladium Menu                         |");
		System.out.println("|                                        |");
		System.out.println("| Shopping Menu (1)                      |");
		System.out.println("|            |");
	}

	public static void 


}