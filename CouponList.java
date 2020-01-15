import java.util.ArrayList;

public class CouponList {
	private ArrayList<Coupon> coupons;
	public int length;

	public CouponList(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
		this.length = coupons.size();
	}

	public CouponList() {
		this.coupons = new ArrayList<Coupon>();
		this.length = 0;
	}

	public Coupon getCouponIndex(int index) {
		if (index > this.length - 1) {
			return null;
		} else {
			return this.coupons.get(index);
		}
	}

	public boolean addCoupon(Coupon new_coupon) {
		try {
			coupons.add(new_coupon);
			this.length++;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeCoupon(int index) {
		try {
			this.coupons.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}