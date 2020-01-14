class Subscription extends RecurringAccount {
	public Subscription(String name, double cost, DateTime purchasedDate, DateTime expiryDate, int timesRenewed) {
		this.name = name;
		this.cost = cost;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.timesRenewed = timesRenewed;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public DateTime getPurchasedDate() {
		return this.purchasedDate;
	}

	public void setPurchasedDate(DateTime purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public DateTime getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(DateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimesRenewed() {
		return this.timesRenewed;
	}

	public void setTimesRenewed(int timesRenewed) {
		this.timesRenewed = timesRenewed;
	}

	public boolean renewSubscription() {
		this.timesRenewed++;
		return true;
	}

	public String toString() {
		return this.name;
	}
}