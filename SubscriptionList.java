import java.util.ArrayList;
import java.io.*;

public class SubscriptionList {
	private ArrayList<Subscription> subscriptions;
	public int length = 0;

	private double totalSpent;
	private double annualCost;
	private double montlyCost;

	public SubscriptionList (ArrayList<Subscription> subscriptions) {
		this.length = subscriptions.size();
		this.subscriptions = subscriptions;
	}

	public SubscriptionList() {
		this.length = 0;
		this.subscriptions = new ArrayList<Subscription>();
	}

	public ArrayList<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}	

	public void updateCost() {
		Subscription subscription;

		for (int i = 0; i < subscriptions.size(); i++) {
			subscription = subscriptions.get(i);
			this.totalSpent += subscription.getCost() * subscription.getTimesRenewed();
		}
	}

	public boolean addSubscription(Subscription newSubscription) {
		try {
			subscriptions.add(newSubscription);
			length++;
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean removeSubscription(int index) {
		try {
			subscriptions.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Subscription getSubscriptionIndex(int index) {
		if (index > this.subscriptions.size() - 1) {
			return null;
		} else {
			return this.subscriptions.get(index);
		}
	}
	

	public boolean saveToFile() {
		return true;
	}

	public boolean loadFromFile(String directory) {
		int numberSubscriptions;
		Subscription parsedSubscription;

		String parsedName;
		double parsedCost;
		Date parsedPurchasedDate;
		Date parsedExpiryDate;
		int parsedTimesRenewed;

		try {
			BufferedReader in = new BufferedReader(new FileReader(directory));
			
			numberSubscriptions = Integer.parseInt(in.readLine());
			for (int i = 0; i < numberSubscriptions; i++) {
				
				parsedName = in.readLine();
				parsedCost = Double.parseDouble(in.readLine());
				parsedPurchasedDate = new Date(in.readLine());
				parsedExpiryDate = new Date(in.readLine());
				parsedTimesRenewed = Integer.parseInt(in.readLine());

				parsedSubscription = new Subscription(parsedName, parsedCost, parsedExpiryDate, parsedPurchasedDate, parsedTimesRenewed);
				this.subscriptions.add(parsedSubscription);
				length++;
			}
			in.close();
		} catch (IOException iox) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "lmao";
	}
}