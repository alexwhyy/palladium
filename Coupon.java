class Coupon {
	private String name;
	private String retailer;
	private double discount;
	private DateTime expiryDate;

	public Coupon(String name, String retailer, double discount, DateTime expiryDate) {
		this.name = name;
		this.retailer = retailer;
		this.discount = discount;
		this.expiryDate = expiryDate;
	}

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

	public String toString() {
		return this.name + "\n" + this.retailer + "\n" + this.discount + "\n" + this.expiryDate.toString();
	}
	
}