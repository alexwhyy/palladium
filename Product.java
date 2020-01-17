public class Product {
	String name;
	double price;
	String retailer;
	String id;
	boolean onSale;
	double salePercent;
	Date saleEnd;
	GiftCard[] applicableCards;
	Membership[] applicableMemberships;

	public Product(String name, double price, String retailer, String id, boolean onSale, double salePercent) {
		this.name = name;
		this.price = price;
		this.retailer = retailer;
		this.id = id;
		this.onSale = onSale;
		this.salePercent = salePercent;
	}

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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isOnSale() {
		return this.onSale;
	}

	public boolean getOnSale() {
		return this.onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public double getSalePercent() {
		return this.salePercent;
	}

	public void setSalePercent(double salePercent) {
		this.salePercent = salePercent;
	}

	public Date getSaleEnd() {
		return this.saleEnd;
	}

	public void setSaleEnd(Date saleEnd) {
		this.saleEnd = saleEnd;
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
			return name + "\n" + price + "\n" + retailer + "\n" + id + "\n" + onSale + "\n" + salePercent;
		}else {
			return "";
		}
	}

}