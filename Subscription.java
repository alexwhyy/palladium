class Subscription extends RecurringAccount {
	public Subscription(String name, double cost, Date purchasedDate, Date expiryDate, int timesRenewed) {
		this.name = name;
		this.cost = cost;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.timesRenewed = timesRenewed;
	}

	public boolean renewSubscription() {
		return true;
	}

	public String toString() {
		return this.name;
	}
}