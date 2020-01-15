import java.util.ArrayList;
import java.io.*;

public class MembershipList {
	private ArrayList<Membership> memberships;
	public int length = 0;

	private double totalSpent;
	private double annualCost;
	private double montlyCost;

	public MembershipList (ArrayList<Membership> memberships) {
		this.length = memberships.size();
		this.memberships = memberships;
	}

	public MembershipList() {
		this.length = 0;
		this.memberships = new ArrayList<Membership>();
	}

	public ArrayList<Membership> getMemberships() {
		return this.memberships;
	}

	public void setMemberships(ArrayList<Membership> memberships) {
		this.memberships = memberships;
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

	public boolean addMembership(Membership newMembership) {
		try {
			memberships.add(newMembership);
			length++;
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean removeMembership(int index) {
		try {
			memberships.remove(index);
			length--;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Membership getMembershipIndex(int index) {
		if (index > this.memberships.size() - 1) {
			return null;
		} else {
			return this.memberships.get(index);
		}
	}

	public boolean saveToFile() {
		return true;
	}

	public boolean loadFromFile(String directory) {
		int numMemberships;
		Membership parsedMembership;

		String parsedName;
		double parsedCost;
		DateTime parsedPurchasedDate;
		DateTime parsedExpiryDate;
		int parsedTimesRenewed;
		int parsedDiscount;
		String parsedMembershipNumber;

		try {
			BufferedReader in = new BufferedReader(new FileReader(directory));
			
			numMemberships = Integer.parseInt(in.readLine());

			for (int i = 0; i < numMemberships; i++) {
				
				parsedName = in.readLine();
				parsedCost = Double.parseDouble(in.readLine());
				parsedPurchasedDate = new DateTime(in.readLine());
				parsedExpiryDate = new DateTime(in.readLine());
				parsedTimesRenewed = Integer.parseInt(in.readLine());
				parsedDiscount = Integer.parseInt(in.readLine());
				parsedMembershipNumber = in.readLine();

				parsedMembership = new Membership(parsedName, parsedCost, parsedPurchasedDate, parsedExpiryDate, parsedTimesRenewed, parsedDiscount, parsedMembershipNumber);
				this.memberships.add(parsedMembership);
				length++;
			}
			in.close();
		} catch (IOException iox) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "lmao";
	}
}