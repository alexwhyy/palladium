import java.util.ArrayList;

public class CouponList {
	private ArrayList<Coupon> coupons;

	public CouponList(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}

	public boolean addCoupon(Coupon new_coupon) {
		try {
			coupons.add(new_coupon);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}