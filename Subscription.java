class Subscription extends RecurringAccount {
	public Subscription(String retailer, double cost, DateTime purchasedDate, DateTime expiryDate, int timesRenewed) {
		this.retailer = retailer;
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

	public String getRetailer() {
		return this.retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
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
		return this.retailer + "\n" + this.cost + "\n" + this.purchasedDate.toString() + "\n" + this.expiryDate.toString() + "\n" + this.timesRenewed;
	}
}