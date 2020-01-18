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
		return this.name + "\n" + this.cost + "\n" + this.purchasedDate + "\n" + this.expiryDate.toString() + "\n" + this.timesRenewed + "\n" + this.discount + "\n" + this.membershipNumber;
	}
}