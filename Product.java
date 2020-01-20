/*
Name:         Product.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for representing
              the product in class form. This includes storing
              all the varibles and applying various methods.
*/

public class Product {
	String name;
	double price;
	String retailer;
	int id;
	DateTime saleDate;
	double salePercent;
	GiftCard[] applicableCards;
	Membership[] applicableMemberships;

	public Product(String name, double price, String retailer, String saleDate, double salePercent, int id) {
		this.name = name;
		this.price = price;
		this.retailer = retailer;
		this.id = id;
		this.saleDate = new DateTime(saleDate);
		this.salePercent = 1 - (salePercent / 100);
	}

	public boolean onSale(DateTime curDate) {
		if (curDate.compareTo(saleDate) == 0) {
			return true;
		}
		return false;
	}

	// ********** GETTERS AND SETTERS **********
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRetailer() {
		return this.retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalePercent() {
		return this.salePercent;
	}

	public void setSalePercent(double salePercent) {
		this.salePercent = salePercent;
	}

	public GiftCard[] getApplicableCards() {
		return this.applicableCards;
	}

	public void setApplicableCards(GiftCard[] applicableCards) {
		this.applicableCards = applicableCards;
	}

	public Membership[] getApplicableMemberships() {
		return this.applicableMemberships;
	}

	public void setApplicableMemberships(Membership[] applicableMemberships) {
		this.applicableMemberships = applicableMemberships;
	}

	public String toString(boolean option) {
		if (!option) {
			return name + "\n" + price + "\n" + retailer + "\n" + id + "\n" + saleDate.toString() + "\n" + salePercent
					+ "\n" + id;
		}
		return "";
	}

}