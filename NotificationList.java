import java.util.ArrayList;

public class NotificationList {
	private ArrayList<Notification> notificationList;

	public NotificationList(ArrayList<Notification> notificationList) {
		this.notificationList = notificationList;
	}

	public boolean addNotification(Notification new_notification) {
		try {
			this.notificationList.add(new_notification);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeNotification(int index) {
		try {
			this.notificationList.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void removeAllNotifications() {
		for (int i = 0; i < this.notificationList.size(); i++) {
			this.notificationList.remove(i);
		}
	}

	public String toString() {
		return "There are " + notificationList.size() + " notifications in this list.";
	}

}