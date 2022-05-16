import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCustomer {
	@Test
	public void testAddRental() {
		Customer c1 = new Customer("Spongebob");
		Movie m1 = new Movie("Bikini Bottom Chaos", 1);
		Rental r1 = new Rental(m1, 1);
		c1.addRental(r1);
		assertEquals(1, c1.getRentals().size());
	}

	@Test
	public void testStatement() {
		Customer c1 = new Customer("Spongebob");
		Movie m1 = new Movie("Bikini Bottom Chaos", 1);
		Rental r1 = new Rental(m1, 1);
		c1.addRental(r1);

		assertEquals("Rental Record for Spongebob\n" + "	Title		Days	Amount\n"
				+ "	Bikini Bottom Chaos		1	3.0\n" + "Amount owed is 3.0\n"
				+ "You earned 1.0 frequent renter points", c1.statement());
	}
}
