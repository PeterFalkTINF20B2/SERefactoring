
import java.util.*;

class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String newname) {
		name = newname;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}
	
	public Vector getRentals() {
		return rentals;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration enum_rentals = rentals.elements();

		String result = getHeaderLine();

		while (enum_rentals.hasMoreElements()) {
			Rental aRental = (Rental) enum_rentals.nextElement();
			
			// add frequent renter points
			frequentRenterPoints += aRental.getFrequentRenterPoints();
			
			// show figures for this rental
			result += "\t" + aRental.getMovie().getTitle() + "\t" + "\t" + aRental.getDaysRented() + "\t"
					+ String.valueOf(aRental.getCharge()) + "\n";
		}

		// add footer lines
		result += getFooterLines(getTotalCharge(), frequentRenterPoints);
		return result;
	}
	
	private double getTotalCharge() {
		Enumeration rentals = this.rentals.elements();
		double total = 0;
		while(rentals.hasMoreElements()) {
			Rental aRental = (Rental) rentals.nextElement();
			total += aRental.getCharge();
		}
		return total;
	}

	private String getFooterLines(double totalAmount, double frequentRenterPoints) {
		String footerLines = "Amount owed is " + String.valueOf(totalAmount) + "\n";
		footerLines += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return footerLines;
	}

	private String getHeaderLine() {
		String headerLine = "Rental Record for " + this.getName() + "\n";
		headerLine += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
		return headerLine;
	}
}