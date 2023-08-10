import java.util.ArrayList;
import java.util.Scanner;


public class C206_CaseStudy {
    private static final int OPTION_QUIT = 3;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private static ArrayList<Bidder> bidderList = new ArrayList<Bidder>();
    private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
    private static Administrator loggedInAdmin = null;

    

    public static void main(String[] args) {
        auctionList.add(new Auction("Ball Point Pen", "A good pen", 1.50, "4/8/2023", "10/8/2023"));
        bidderList.add(new Bidder("bidder1", "password1"));
        adminList.add(new Administrator("admin1", "password0"));

        int option = 0;

        while (option != OPTION_QUIT) {
            C206_CaseStudy.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                //create account
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
                //bidder menu here
               
                      
                //adding payment here
            }
            else {
            	System.out.println("Login failed");
            }
        }
    }
        
        public static void createPayment(Bidder currentBidder) {
            double paymentAmount = Helper.readDouble("Enter payment amount: ");
            String paymentMethod = Helper.readString("Enter payment method: ");
            Payment payment = new Payment(paymentAmount, paymentMethod, currentBidder.getUsername());
            System.out.println("Payment created: " + payment);
        
        

        for (Administrator admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                loggedInAdmin = admin;
                System.out.println("Login successful");
                adminMenu();
                return;
            }
        }
        
        System.out.println("Invalid username or password");
    }

    public static void adminMenu() {
        C206_CaseStudy.setHeader("ADMINISTRATOR MENU");
        System.out.println("1. Create Auction");
        System.out.println("2. View Auctions");
        System.out.println("3. Edit Auction");
        System.out.println("4. Delete Auction");
        System.out.println("5. Log Out");
        Helper.line(80, "-");

        int option = Helper.readInt("Enter an option > ");

        if (option == 1) {
            //create auction
        } else if (option == 2) {
            //view auction
        } else if (option == 3) {
            //edit auction
        } else if (option == 4) {
            //delete auction
        } else if (option == 5) {
            loggedInAdmin = null; 
            System.out.println("Logged out");
        } else {
            System.out.println("Invalid option");
        }
    }
    
}
