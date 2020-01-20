/*
Name:         Membership.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for representing
              the membership in class form. This includes storing
              all the varibles and applying various methods.
*/

class Membership extends RecurringAccount {
	private double discount;
	private String membershipNumber;

	public Membership(String retailer, double cost, DateTime purchasedDate, DateTime expiryDate, int timesRenewed,
			double discount, String membershipNumber) {
		this.retailer = retailer;
		this.cost = cost;
		this.purchasedDate = purchasedDate;
		this.expiryDate = expiryDate;
		this.timesRenewed = timesRenewed;
		this.discount = discount;
		this.membershipNumber = membershipNumber;
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

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getMembershipNumber() {
		return this.membershipNumber;
	}

	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public String toString() {
		return this.retailer + "\n" + this.cost + "\n" + this.purchasedDate + "\n" + this.expiryDate.toString() + "\n"
				+ this.timesRenewed + "\n" + this.discount + "\n" + this.membershipNumber;
	}
}