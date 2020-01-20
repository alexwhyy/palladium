/*
Name:         NotificationList.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for storing the
              the notifications in class form and allowing the
              user to manipulate the list by adding, removing,
              and searching. Additionally, it manages the parsing,
              reading, and writing of the notification to the text file.
*/

import java.io.*;
import java.util.ArrayList;

public class NotificationList {
	private ArrayList<Notification> notifications;
	private String filePath;
	public int length;

	public NotificationList(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}

	public NotificationList(String filePath) {
		this.filePath = filePath;
		Notification parsedNotification;
		notifications = new ArrayList<Notification>();

		/*
		 * We should first try and parse the user's subscriptions from the file.
		 */
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.filePath));
			String input;
			while ((input = in.readLine()) != null) {
				length = Integer.parseInt(input) - 1;
				for (int i = 0; i < length; i++) {
					parsedNotification = new Notification(in.readLine(), Boolean.parseBoolean(in.readLine()),
							new DateTime(in.readLine()), in.readLine());
					notifications.add(parsedNotification);
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

	/*
	 * Allows the user to add a new notification object into the ArrayList
	 */
	public boolean addNotification(Notification newNotification) {
		try {
			this.notifications.add(newNotification);
			length++;
			updateFile();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Allows the user to obtain an refrence to the notification object through the
	 * index in ArrayList.
	 */
	public Notification getNotificationIndex(int index) {
		if (index > this.notifications.size() - 1) {
			return null;
		} else {
			return this.notifications.get(index);
		}
	}

	/*
	 * Allows the user to specify an index to remove a notification
	 */
	public boolean removeNotification(int index) {
		try {
			this.notifications.remove(index);
			length--;
			updateFile();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Removes all the user's notifications at once.
	 */
	public void removeAllNotifications() {
		for (int i = 0; i < this.notifications.size(); i++) {
			this.notifications.remove(i);
		}
		updateFile();
	}

	/*
	 * Allows the user to write to the text file which saves the notification. This
	 * method should be used after every update to ensure that the user is always
	 * updated.
	 */
	private void updateFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write("" + length);
			out.newLine();
			for (int i = 0; i < length; i++) {
				// Writes the string for representation of the notification
				out.write(notifications.get(i).toString());
				out.newLine();
			}
			out.close();
		} catch (IOException iox) {

		}
	}

	public String toString() {
		return "There are " + length + " notifications in this list.";
	}

}