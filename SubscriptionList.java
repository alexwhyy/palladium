import java.util.ArrayList;
import java.io.*;

public class SubscriptionList {
	final private String SUBSCRIPTION_LIST_FILE = "Database/SubscriptionList.txt";

	private ArrayList<Subscription> subscriptions;
	private double totalSpent;
	private double annualCost;
	private double montlyCost;

	public SubscriptionList (ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public SubscriptionList() {
	}

	public boolean addSubscription(Subscription new_subscription) {
		try {
			this.subscriptions.add(new_subscription);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean saveToFile() {
		return true;
	}

	public boolean loadFromFile() {
		int numberSubscriptions;
		Subscription parsedSubscription;

		String parsedName;
		double parsedCost;
		Date parsedPurchasedDate;
		Date parsedExpiryDate;
		int parsedTimesRenewed;

		try {
			BufferedReader in = new BufferedReader(new FileReader(this.SUBSCRIPTION_LIST_FILE));
			
			numberSubscriptions = Integer.parseInt(in.readLine());
			for (int i = 0; i < numberSubscriptions; i++) {
				
				parsedName = in.readLine();
				parsedCost = Double.parseDouble(in.readLine());
				parsedPurchasedDate = new Date(in.readLine());
				parsedExpiryDate = new Date(in.readLine());
				parsedTimesRenewed = Integer.parseInt(in.readLine());

				parsedSubscription = new Subscription(parsedName, parsedCost, parsedExpiryDate, parsedPurchasedDate, parsedTimesRenewed);
				this.subscriptions.addSubscription(parsedSubscription);
			}
			in.close();
		} catch (IOException iox) {
			System.out.println(iox);
			return false;
		}
		return true;
	}

	public String toString() {
		return "lmao";
	}
}