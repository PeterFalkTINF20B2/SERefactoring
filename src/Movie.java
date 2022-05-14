public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String title;
	private int priceCode;

	public Movie(String newtitle, int newpriceCode) {
		title = newtitle;
		priceCode = newpriceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		priceCode = arg;
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {
		double charge = 0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			charge += 2;
			if (daysRented > 2)
				charge += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			charge += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			charge += 1.5;
			if (daysRented > 3)
				charge += (daysRented - 3) * 1.5;
			break;
		}
		return charge;
	}
}