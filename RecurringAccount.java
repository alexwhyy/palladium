public abstract class RecurringAccount {
	private double cost;
	private Date purchasedDate;
	private Date expiryDate;
	private String name;
	private int timesRenewed;

	abstract public String toString();

}

class Membership extends RecurringAccount {
	private double discount;
	private String membershipNumber;

	public Membership(String name, double cost, Date purchasedDate, Date expiryDate, int timesRenewed, double discount, String membershipNumber) {
		this.name = name;
		this.cost = cost;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.timesRenewed = timesRenewed;
		this.discount = discount;
		this.membershipNumber = membershipNumber;
	}

	public String toString() {
		return this.name;
	}

}

class Subscription extends RecurringAccount {
	public Subscription(String name, double cost, Date purchasedDate, Date expiryDate, int timesRenewed) {
		this.name = name;
		this.cost = cost;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.timesRenewed = timesRenewed;
	}

	public String toString() {
		return this.name;
	}
}
