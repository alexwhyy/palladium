import javax.naming.NoInitialContextException;
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
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.filePath));
			String input;
			while ((input = in.readLine()) != null) {
				length = Integer.parseInt(input);
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

	public boolean addNotification(Notification new_notification) {
		try {
			this.notifications.add(new_notification);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Notification getNotificationIndex(int index) {
		if (index > this.notifications.size() - 1) {
			return null;
		} else {
			return this.notifications.get(index);
		}
	}

	public boolean removeNotification(int index) {
		try {
			this.notifications.remove(index);
			length--;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void removeAllNotifications() {
		for (int i = 0; i < this.notifications.size(); i++) {
			this.notifications.remove(i);
		}
	}

	private void updateFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(length);
			out.newLine();
			for (int i = 0; i < length; i++) {
				out.write(notifications.get(i).toString());
				out.newLine();
			}
			out.close();
		} catch (IOException iox) {

		}
	}

	public String toString() {
		return "There are " + notifications.size() + " notifications in this list.";
	}

}