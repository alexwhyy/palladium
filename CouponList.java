import java.io.*;
import java.util.ArrayList;

public class CouponList {
	private ArrayList<Coupon> coupons;
	public int length;
	String filePath;

	public CouponList(String filePath) {
		this.filePath = filePath;
		Coupon parsedCoupon;
		coupons = new ArrayList<Coupon>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.filePath));
			String input;
			while ((input = in.readLine()) != null) {
				length = Integer.parseInt(input);
				for (int i = 0; i < length; i++) {
					parsedCoupon = new Coupon(in.readLine(), in.readLine(), Double.parseDouble(in.readLine()),
							new DateTime(in.readLine()));
					coupons.add(parsedCoupon);
				}
			}
			in.close();
		} catch (IOException iox) {
			System.out.println(" ____________________________________");
			System.out.println("|                                    |");
			System.out.println("| File Reading Error!                |");
			System.out.println("|                                    |");
			System.out.println("|____________________________________|");
			System.out.println("Error: " + iox + "\n");
		}
	}

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
			length--;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void updateFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(length);
			out.newLine();
			for (int i = 0; i < length; i++) {
				out.write(this.coupons.get(i).toString());
				out.newLine();
			}
			out.close();
		} catch (IOException iox) {

		}
	}

}