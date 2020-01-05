public abstract class RecurringAccount {
	private String retailer;
	private double rate;
	private Date purchasedDate;
	private Date expiryDate;
	private String name;
	private int timesRenewed;

	abstract public String toString();

}

class Subscription extends RecurringAccount {
	public Subscription(String retailer, double rate, Date purchasedDate, Date expiryDate, String name, int timesRenewed) {
		this.retailer = retailer;
		this.rate = rate;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.name = name;
		this.timesRenewed = timesRenewed;
	}

	public String toString() {
		return this.retailer;
	}
}