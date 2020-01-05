class Coupon {
	private String retailer;
	private String id;
	private double discount;
	private Date expiryDate;

	public String getRetailer() {
		return this.retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	
}