/*
Name:         SubscriptionList.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for storing the subscriptions
              used by the program and applying the sorting, searching,
              loading, and saving of the database.
*/

import java.util.ArrayList;
import java.io.*;

public class SubscriptionList {
	private ArrayList<Subscription> subscriptions;
	public int length = 0;
	private String filePath;
	private double totalSpent;
	private double annualCost;
	private double montlyCost;

	public SubscriptionList (ArrayList<Subscription> subscriptions) {
		this.length = subscriptions.size();
		this.subscriptions = subscriptions;
	}

	public SubscriptionList() {
		this.length = 0;
		this.subscriptions = new ArrayList<Subscription>();
	}

	public ArrayList<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public double getTotalSpent() {
		return this.totalSpent;
	}

	public void setTotalSpent(double totalSpent) {
		this.totalSpent = totalSpent;
	}

	public double getAnnualCost() {
		return this.annualCost;
	}

	public void setAnnualCost(double annualCost) {
		this.annualCost = annualCost;
	}

	public double getMontlyCost() {
		return this.montlyCost;
	}

	public void setMontlyCost(double montlyCost) {
		this.montlyCost = montlyCost;
	}

	public void updateCost() {
		Subscription subscription;

		for (int i = 0; i < subscriptions.size(); i++) {
			subscription = subscriptions.get(i);
			
			this.totalSpent += subscription.getCost() * subscription.getTimesRenewed();
			this.montlyCost += subscription.getCost();
		}

		this.annualCost = this.montlyCost * 12;
	}

	public boolean addSubscription(Subscription newSubscription) {
		try {
			subscriptions.add(newSubscription);
			length++;
			updateFile();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean removeSubscription(int index) {
		try {
			subscriptions.remove(index);
			length--;
			updateFile();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Subscription getSubscriptionIndex(int index) {
		if (index > this.subscriptions.size() - 1) {
			return null;
		} else {
			return this.subscriptions.get(index);
		}
	}

	public void updateFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(""+length);
			out.newLine();
			for (int i = 0; i < length; i++) {
				out.write(subscriptions.get(i).toString());
				out.newLine();
			}
			out.close();
		} catch (IOException iox) {

		}
	}

	public SubscriptionList(String directory) {
		Subscription parsedSubscription;
		filePath = directory;
		String parsedName;
		double parsedCost;
		DateTime parsedPurchasedDate;
		DateTime parsedExpiryDate;
		int parsedTimesRenewed;
		subscriptions = new ArrayList<Subscription>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(directory));
			
			length = Integer.parseInt(in.readLine())-1;
			for (int i = 0; i < length; i++) {
				
				parsedName = in.readLine();
				parsedCost = Double.parseDouble(in.readLine());
				parsedPurchasedDate = new DateTime(in.readLine());
				parsedExpiryDate = new DateTime(in.readLine());
				parsedTimesRenewed = Integer.parseInt(in.readLine());

				parsedSubscription = new Subscription(parsedName, parsedCost, parsedExpiryDate, parsedPurchasedDate, parsedTimesRenewed);
				this.subscriptions.add(parsedSubscription);
				length++;
			}
			in.close();
		} catch (IOException iox) {

		}
	}

	public String toString() {
		return "List";
	}
}