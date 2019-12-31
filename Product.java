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
}