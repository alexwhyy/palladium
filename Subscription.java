/*
Name:         Subscription.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for representing the
              subscription in class form.
*/

class Subscription extends RecurringAccount {
	public Subscription(String retailer, double cost, DateTime purchasedDate, DateTime expiryDate, int timesRenewed) {
		this.retailer = retailer;
		this.cost = cost;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.timesRenewed = timesRenewed;
	}

	// ********** GETTERS AND SETTERS **********
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

	// renews the subscription by adding the times
	// renewed by 1
	public boolean renewSubscription() {
		this.timesRenewed++;
		return true;
	}

	// returns string form representation of object which
	// is useful for storing it in the text file
	public String toString() {
		return this.retailer + "\n" + this.cost + "\n" + this.purchasedDate.toString() + "\n"
				+ this.expiryDate.toString() + "\n" + this.timesRenewed;
	}
}