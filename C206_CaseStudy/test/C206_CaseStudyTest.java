import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Auction a1; 
	private Auction a2;
	private Bidder b1;
	private Bidder b2;
	private Payment pay1;
	private Payment pay2;
	private ArrayList<Auction> auctionList;
	private ArrayList<Bidder> bidderList;
	private ArrayList <Payment> paymentList;
	
	
	public C206_CaseStudyTest() {
		super();
	}
	
	
	@Before
	public void setUp() throws Exception {
		a1 = new Auction("Lenovo Laptop", "A laptop", 1200.10,"12/3/2023","12/4/2023"); 
		a2 = new Auction("Logitech Mouse","A mouse",12.90,"12/4/2023","12/5/2023");
		b1 = new Bidder("bidder1","password1");
		b2 = new Bidder("bidder2","password2");
		pay1 = new Payment (1500.10, "Credit Card", "Snorlax");
		pay2 = new Payment (30.10, "Bank Transfer", "Spacey");
		
		bidderList= new ArrayList<Bidder>();
		auctionList = new ArrayList<Auction>();
		paymentList = new ArrayList <Payment>();
	}
		
	@Test
	public void addBidder() {
	    // Item list is not null and it is empty
	    assertNotNull("Test if there is valid bidder arraylist to add to", bidderList);

	    // Given an empty list, after adding 1 item, the size of the list is 1
	    C206_CaseStudy.addBidder(bidderList, b1);
	    assertEquals("Test that the Bidder arraylist size is 1.", 1, bidderList.size());
	    assertSame("Test that Bidder is added", b1, bidderList.get(0));

	    // Given an empty list, after adding 2 items, the size of the list is 2 (corrected)
	    C206_CaseStudy.addBidder(bidderList, b2);
	    assertEquals("Test that the Bidder arraylist size is 2.", 2, bidderList.size());
	    assertSame("Test that Bidder is added", b2, bidderList.get(1));
	}

	
	@Test
	public void testAddPayment() {
	    // Ensure the initial paymentList is empty
	    assertEquals("Test that paymentList is initially empty", 0, paymentList.size());

	    // Given an empty list, after adding 1 item, the size of the list is 1 - normal
	    C206_CaseStudy.addPayment(paymentList, pay1);
	    assertEquals("Test that the Payment arraylist size is 1.", 1, paymentList.size());
	    assertEquals("Test that Payment is added", pay1, paymentList.get(0));

	    // Add another payment to the list
	    C206_CaseStudy.addPayment(paymentList, pay2);
	    assertEquals("Test that the Payment arraylist size is 2.", 2, paymentList.size());
	    assertEquals("Test that Payment is added", pay2, paymentList.get(1));
	}
	
	@Test
	public void testRetrieveAllPayment() {
	    // Ensure there is a valid Payment ArrayList to retrieve items
	    assertNotNull("Test if there is a valid Payment ArrayList to retrieve items", paymentList);

	    // Add payments to the list
	    paymentList.add(pay1);
	    paymentList.add(pay2);

	    // Check that the Payment ArrayList size is 2 after adding the payments
	    assertEquals("Test that Payment ArrayList size is 2", 2, paymentList.size());

	    // Create the expected output based on the payments added to the list
	    String expectedOutput = String.format("%-15s %-15s %-15s\n", "Amount", "Payment Method", "Username");
	    expectedOutput += String.format("%-15.2f %-15s %-15s\n", 1500.10, "Credit Card", "Snorlax");
	    expectedOutput += String.format("%-15.2f %-15s %-15s\n", 30.10, "Bank Transfer", "Spacey");

	    // Retrieve all payments from the list
	    String allPayments = C206_CaseStudy.retrieveAllPayment(paymentList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allPayments);

	    // Check that the retrieved payments match the expected output
	    assertEquals("Test that ViewAllPayments", expectedOutput, allPayments);
	}



	
	@Test
	public void testviewPayment() {
	    // Ensure there is a valid payment ArrayList to retrieve items
	    assertNotNull("Test if there is a valid Payment ArrayList to retrieve items", paymentList);

	    // Add two payment to the list
	    C206_CaseStudy.addPayment(paymentList, pay1);
	    C206_CaseStudy.addPayment(paymentList, pay2);

	    // Check that the Payment ArrayList size is 2 after adding the payment
	    assertEquals("Test that Payment ArrayList size is 2", 2, paymentList.size());

	    // Get the expected output based on the payment added to the list
	    String expectedOutput = String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "1", "Lenovo Laptop", "A laptop", 1200.10, "12/3/2023", "12/4/2023");
	    expectedOutput += String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "2", "Logitech Mouse", "A mouse", 12.90, "12/4/2023", "12/5/2023");

	    // Retrieve all payment from the list
	    String allPayment = C206_CaseStudy.retrieveAllPayment(paymentList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allPayment);

	    // Check that the retrieved auctions match the expected output
	    assertEquals("Test that viewPayment", expectedOutput, allPayment);
	}


	@Test
	public void testDeletePayment() {
	    // Ensure there is a valid Payment ArrayList to delete from
	    assertNotNull("Test if there is a valid Payment ArrayList to delete from", paymentList);

	    // Add payments to the list
	    paymentList.add(p1);
	    paymentList.add(p2);

	    // Check that the Payment ArrayList size is 2 after adding the payments
	    assertEquals("Test that Payment ArrayList size is 2", 2, paymentList.size());

	    // Delete one of the payments
	    C206_CaseStudy.deletePayment(paymentList); // Deleting the first payment (index 0)

	    // Check that the Payment ArrayList size is now 1 after deleting a payment
	    assertEquals("Test that Payment ArrayList size is 1 after delete", 1, paymentList.size());

	    // Get the expected output after deleting the payment
	    String expectedOutput = String.format("%-15s %-15s %-15s\n", "Amount", "Payment Method", "Username");
	    expectedOutput += String.format("%-15.2f %-15s %-15s\n", 30.10, "Bank Transfer", "Spacey");

	    // Retrieve all payments from the list
	    String allPayments = C206_CaseStudy.retrieveAllPayment(paymentList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allPayments);

	    // Check that the retrieved payments match the expected output after deleting a payment
	    assertEquals("Test that ViewAllPayments after delete", expectedOutput, allPayments);
	}


	
	
	@Test
	public void testRetrieveAllBidder() {
	    // Ensure there is a valid Bidder ArrayList to retrieve items
	    assertNotNull("Test if there is a valid Bidder ArrayList to retrieve items", bidderList);

	    // Add bidders to the list
	    C206_CaseStudy.addBidder(bidderList, b1);
	    C206_CaseStudy.addBidder(bidderList, b2);

	    // Check that the Bidder ArrayList size is 2 after adding the bidders
	    assertEquals("Test that Bidder ArrayList size is 2", 2, bidderList.size());

	    // Get the expected output based on the bidders added to the list
	    String expectedOutput = String.format("%-15s %-15s\n", "Username", "Password");
	    expectedOutput += String.format("%-15s %-15s\n", "bidder1", "password1");
	    expectedOutput += String.format("%-15s %-15s\n", "bidder2", "password2");

	    // Retrieve all bidders from the list
	    String allBidders = C206_CaseStudy.retrieveAllBidder(bidderList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allBidders);

	    // Check that the retrieved bidders match the expected output
	    assertEquals("Test that ViewAllBidders", expectedOutput, allBidders);
	}
	
	@Test
	public void addAuction() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Auction arraylist to add to", auctionList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addAuction(auctionList, a1);		
		assertEquals("Test that Auction arraylist size is 1", 1, auctionList.size());
		assertSame("Test that Auction is added", a1, auctionList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addAuction(auctionList, a2);
		assertEquals("Test that Auction arraylist size is 2", 2, auctionList.size());
		assertSame("Test that Auction is added", a2, auctionList.get(1));
	}
	@Test
	public void viewAuction() {
	    // Ensure there is a valid Auction ArrayList to retrieve items
	    assertNotNull("Test if there is a valid Auction ArrayList to retrieve items", auctionList);

	    // Add two auctions to the list
	    C206_CaseStudy.addAuction(auctionList, a1);
	    C206_CaseStudy.addAuction(auctionList, a2);

	    // Check that the Auction ArrayList size is 2 after adding the auctions
	    assertEquals("Test that Auction ArrayList size is 2", 2, auctionList.size());

	    // Get the expected output based on the auctions added to the list
	    String expectedOutput = String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "1", "Lenovo Laptop", "A laptop", 1200.10, "12/3/2023", "12/4/2023");
	    expectedOutput += String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "2", "Logitech Mouse", "A mouse", 12.90, "12/4/2023", "12/5/2023");

	    // Retrieve all auctions from the list
	    String allAuction = C206_CaseStudy.retrieveAllAuctions(auctionList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allAuction);

	    // Check that the retrieved auctions match the expected output
	    assertEquals("Test that ViewAllAuction", expectedOutput, allAuction);
	}

	@Test
	public void editAuction() {
	    // Ensure there is a valid Auction ArrayList to edit
	    assertNotNull("Test if there is a valid Auction ArrayList to edit", auctionList);

	    // Add an auction to the list
	    C206_CaseStudy.addAuction(auctionList, a1);

	    // Modify the auction data using the editAuction method
	    String updatedDescription = "Updated description";
	    double updatedPrice = 999.99;
	    String updatedStartDate = "31/12/2023";
	    String updatedEndDate = "2/1/2024";

	    C206_CaseStudy.editAuctions(auctionList);

	    // Get the expected output after the edit
	    String expectedOutput = String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "1", "Updated description", "A laptop", 999.99, "31/12/2023", "2/1/2024");
	    expectedOutput += String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "2", "Logitech Mouse", "A mouse", 12.90, "12/4/2023", "12/5/2023");

	    // Retrieve all auctions from the list
	    String allAuction = C206_CaseStudy.retrieveAllAuctions(auctionList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allAuction);

	    // Verify that the edited auction's data matches the expected data
	    Auction editedAuction = auctionList.get(0);
	    assertEquals("Test that edited description matches", updatedDescription, editedAuction.getDescription());
	    assertEquals("Test that edited price matches", updatedPrice, editedAuction.getStartingPrice(), 0.001);
	    assertEquals("Test that edited start date matches", updatedStartDate, editedAuction.getStartDate());
	    assertEquals("Test that edited end date matches", updatedEndDate, editedAuction.getEndDate());
	}
	@Test
	public void deleteAuction() {
	    // Ensure there is a valid Auction ArrayList to delete from
	    assertNotNull("Test if there is a valid Auction ArrayList to delete from", auctionList);

	    // Add auctions to the list
	    C206_CaseStudy.addAuction(auctionList, a1);
	    C206_CaseStudy.addAuction(auctionList, a2);

	    // Check that the Auction ArrayList size is 2 after adding the auctions
	    assertEquals("Test that Auction ArrayList size is 2", 2, auctionList.size());

	    // Delete one of the auctions
	    C206_CaseStudy.deleteAuctions(auctionList); // Deleting the first auction (index 0)

	    // Check that the Auction ArrayList size is now 1 after deleting an auction
	    assertEquals("Test that Auction ArrayList size is 1 after delete", 1, auctionList.size());

	    // Get the expected output after deleting the auction
	    String expectedOutput = String.format("%-10s %-20s %-20s %-20s %-13s %-11s\n",
	            "2", "Logitech Mouse", "A mouse", 12.90, "12/4/2023", "12/5/2023");

	    // Retrieve all auctions from the list
	    String allAuction = C206_CaseStudy.retrieveAllAuctions(auctionList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allAuction);

	    // Check that the retrieved auctions match the expected output after deleting an auction
	    assertEquals("Test that ViewAllAuction after delete", expectedOutput, allAuction);
	}

	
	
	
	@After
	public void tearDown() throws Exception {
	a1 = null;
	a2 = null;
	auctionList = null;
	 pay1 = null;
     pay2 = null;
     paymentList = null;
	
	}

	
	
}
