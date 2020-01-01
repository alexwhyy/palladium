import java.util.ArrayList;

public class NotificationList {
	private ArrayList<Notification> notification_list;

	public NotificationList(ArrayList<Notification> notification_list) {
		this.notification_list = notification_list;
	}

	public boolean addNotification(Notification new_notification) {
		try {
			this.notification_list.add(new_notification);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "There are " + notification_list.size() + " notifications in this list.";
	}

}