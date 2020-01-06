import java.util.ArrayList;

public class SubscriptionList {
	private ArrayList<Subscription> subscriptions;
	private double totalSpent;
	private double annualCost;
	private double montlyCost;

	public SubscriptionList (ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public boolean addSubscription(Subscription new_subscription) {
		try {
			this.subscriptions.add(new_subscription);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String toString() {
		return "lmao";
	}
}