public abstract class RecurringAccount {
	protected double cost;
	protected DateTime purchasedDate;
	protected DateTime expiryDate;
	protected String name;
	protected int timesRenewed;

	abstract public String toString();

}

