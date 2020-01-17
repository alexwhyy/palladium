import java.util.ArrayList;

public class NotificationList {
	private ArrayList<Notification> notifications;
	int length;

	public NotificationList(ArrayList<Notification> notifications) {
		this.notifications = notifications;
		this.length = notifications.size();
	}

	public NotificationList() {
		this.notifications = new ArrayList<Notification>();
		this.length = 0;
	}

	public boolean addNotification(Notification newNotification) {
		try {
			this.notifications.add(newNotification);
			length++;
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

	public String toString() {
		return "There are " + notifications.size() + " notifications in this list.";
	}

}