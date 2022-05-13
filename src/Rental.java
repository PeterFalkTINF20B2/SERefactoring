class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getCharge() {
		double amount = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			amount += 2;
			if (getDaysRented() > 2)
				amount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			amount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if (getDaysRented() > 3)
				amount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return amount;
	}
}