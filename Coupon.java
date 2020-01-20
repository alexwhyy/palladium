/*
Name:         Coupon.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for representing
              the coupon in class form. This includes storing
              all the varibles and applying various methods.
*/

class Coupon {
	private String name;
	private String retailer;
	private double discount;
	private DateTime expiryDate;

	public Coupon(String name, String retailer, double discount, DateTime expiryDate) {
		this.name = name;
		this.retailer = retailer;
		// converts the discount to decimal form
		this.discount = 1 - (discount / 100);
		this.expiryDate = expiryDate;
	}

	// ********** GETTERS AND SETTERS **********
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRetailer() {
		return this.retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public DateTime getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(DateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	// string form representation of object
	public String toString() {
		return this.name + "\n" + this.retailer + "\n" + this.discount + "\n" + this.expiryDate.toString();
	}

}