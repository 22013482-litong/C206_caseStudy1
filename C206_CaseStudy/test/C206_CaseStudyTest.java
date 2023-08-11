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
	private ArrayList<Auction> auctionList;
	private ArrayList<Bidder> bidderList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	
	@Before
	public void setUp() throws Exception {
		a1 = new Auction("Lenovo Laptop", "A laptop", 1200.10,"12/3/2023","12/4/2023"); 
		a2 = new Auction("Logitech Mouse","A mouse",12.90,"12/4/2023","12/5/2023");
		b1 = new Bidder("bidder1","password1");
		b2 = new Bidder("bidder2","password2");
		
		bidderList= new ArrayList<Bidder>();
		auctionList = new ArrayList<Auction>();
	}
		
	@Test
	public void addbidder() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid bidder arraylist to add to", bidderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBidder(bidderList, b1);		
		assertEquals("Test that the Bidder arraylist size is 1.", 1, bidderList.size());
		assertSame("Test that Bidder is added", b1, bidderList.get(0));
		
		//Given an empty list, after adding 2 item, the size of the list is 2
		C206_CaseStudy.addBidder(bidderList, b2);		
		assertEquals("Test that the Bidder arraylist size is 2.", 1, bidderList.size());
		assertSame("Test that Bidder is added", b2, bidderList.get(1));
	}
	
	@Test
	public void testRetrieveAllBidder() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Bidder arraylist to retrieve item", bidderList);
		
		//test if the list of Auction retrieved from the SourceCentre is empty - boundary
		String allBidder= (C206_CaseStudy.retrieveAllBidder(bidderList));
		String testOutput = "";
		assertEquals("Check that ViewAllBidderlist", testOutput, allBidder);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addBidder(bidderList, b1);
		C206_CaseStudy.addBidder(bidderList, b2);
		assertEquals("Test that Bidder arraylist size is 2", 2, bidderList.size());
		
		//test if the expected output string same as the list of Auction retrieved from the SourceCentre	
		allBidder= C206_CaseStudy.retrieveAllBidder(bidderList);
		testOutput = String.format("%-10s %-30s\n", "Bidder1", "password1");
		testOutput += String.format("%-10s %-30s\n", "Bidder2", "password2");
	
		assertEquals("Test that ViewAllBidderlist", testOutput, allBidder);
		
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
	
	}

	
	
}
