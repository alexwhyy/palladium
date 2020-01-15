class Membership extends RecurringAccount {
	private double discount;
	private String membershipNumber;

	public Membership(String name, double cost, DateTime purchasedDate, DateTime expiryDate, int timesRenewed, double discount, String membershipNumber) {
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