import java.util.ArrayList;



public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3;
	private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
	private static ArrayList<Bidder> bidderList = new ArrayList<Bidder>();
	private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();

	public C206_CaseStudy(String paymentAmount, String paymentMethod) {
	
	}

	public static void main(String[] args) {

	    auctionList.add(new Auction("Ball Point Pen", "A good pen", 1.50, "4/8/2023", "10/8/2023"));
	    bidderList.add(new Bidder("bidder1", "password1"));
	    adminList.add(new Administrator("admin1", "password0"));

	    int option = 0;

	    while (option != OPTION_QUIT) {

	        C206_CaseStudy.menu();
	        option = Helper.readInt("Enter an option > ");

	        if (option == 1) {
	            // Implement create account logic
	        } else if (option == 2) {
	            login();
	        }
	    }
	}

	public static void menu() {
		C206_CaseStudy.setHeader("ONLINE AUCTION APP");
		System.out.println("1. Create Account");
		System.out.println("2. Log In");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static void login() {
	    String username = Helper.readString("Enter your username > ");
	    String password = Helper.readString("Enter your password > ");

	    for (Bidder bidder : bidderList) {
	        if (bidder.getUsername().equals(username) && bidder.getPassword().equals(password)) {
	            System.out.println("Login successful");
	            // Display Bidder menu here
	            return;
	        }
	    }

	    for (Administrator admin : adminList) {
	        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
	            System.out.println("Login successful");
	            // Display Administrator menu here
	            return;
	        }
	    }

	    System.out.println("Invalid username or password");
	}
	public static void createaccount() {

		//fill in here

	}
}
