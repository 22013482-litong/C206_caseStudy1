import java.util.ArrayList;


public class C206_CaseStudy {
    private static final int OPTION_ADMINLOGIN = 2;
	private static final int OPTION_CREATE = 1;
	private static final int OPTION_QUIT = 3;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private static ArrayList<Bidder> bidderList = new ArrayList<Bidder>();
    private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();

    public C206_CaseStudy(String paymentAmount, String paymentMethod) {
    
    }

    public static void main(String[] args) {
    	
    	auctionList.add(new Auction("Lenovo Laptop", "A laptop",1200.10,"12/3/2023","12/4/2023"));
        bidderList.add(new Bidder("bidder1", "password1"));
        adminList.add(new Administrator("admin1", "password0"));

        int option = 0;

        while (option != OPTION_QUIT) {
            C206_CaseStudy.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_CREATE) {
                //create account
            } else if (option == OPTION_ADMINLOGIN) {
                loginAsAdministrator();
            }    
        }
    }

    public static void menu() {
        C206_CaseStudy.setHeader("ONLINE AUCTION APP");
        loginMeu();
        Helper.line(80, "-");
    }

	public static void loginMeu() {
		System.out.println("1. Create Account");
        System.out.println("2. Log In");
        System.out.println("3. Quit");
	}

    public static void setHeader(String header) {
        Helper.line(80, "-");
        System.out.println(header);
        Helper.line(80, "-");
    }
    
    public static Bidder loginAsBidder() {
    	Bidder loginAcc = null;
    	String username = Helper.readString("Enter your username > ");
        String password = Helper.readString("Enter your password > ");
        
	    for (Bidder bidder : bidderList) {
	        if (bidder.getUsername().equals(username) && bidder.getPassword().equals(password)) {
	        	loginAcc = bidder;
	        	Helper.line(80,"-");
	        	System.out.println("Login successful");
	            //bidder menu here
	        }
	    }
	    return loginAcc;
    }

    public static Administrator loginAsAdministrator() {
    	Administrator loginAcc = null;
        String username = Helper.readString("Enter your username > ");
        String password = Helper.readString("Enter your password > ");
        
        for (Administrator admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            	loginAcc = admin;
                Helper.line(80,"-");
                System.out.println("Login successful");
                adminMenu();
                
            }
            else {
            	 System.out.println("Invalid username or password");
            }

        }
        return loginAcc;
    }

    public static void adminMenu() {
       
    	C206_CaseStudy.setHeader("ADMINISTRATOR MENU");
        adminMeu();
        Helper.line(80, "-");

        int option = Helper.readInt("Enter an option > ");
        if (option == 1) {
            //create auction
        	Auction ac = inputAuction();
			C206_CaseStudy.addAuction(auctionList, ac);
			System.out.println();
			System.out.println("Auction created and added successfully");

        } else if (option == 2) {
            //view auction
        	viewAuctions(auctionList);
        } else if (option == 3) {
            //edit auction
        	editAuctions(auctionList);
        } else if (option == 4) {
            //delete auction
        	deleteAuctions(auctionList);
        } else if (option == 5) {
            
            System.out.println("Logged out");
            return;
        } else {
            System.out.println("Invalid option");
        }
        adminMenu();

    }

	public static void adminMeu() {
		System.out.println("1. Create Auction");
        System.out.println("2. View Auctions");
        System.out.println("3. Edit Auction");
        System.out.println("4. Delete Auction");
        System.out.println("5. Log Out");
	}
   
    public static Auction inputAuction() {
	    String itemName = Helper.readString("Enter the item name > ");
	    String description = Helper.readString("Enter the item description > ");
	    double startingPrice = Helper.readDouble("Enter the starting price > ");
	    String startDate = Helper.readString("Enter the start date > ");
	    String endDate = Helper.readString("Enter the end date > ");
	    
	    Auction ac = new Auction(itemName, description, startingPrice, startDate, endDate);
	    return ac;
    }

    public static void addAuction(ArrayList<Auction> auctionList, Auction ac) {
    	Auction auction;
		for (int i = 0; i < auctionList.size(); i++) {
			auction = auctionList.get(i);
			if (auction.getId()==(ac.getId()))
				return;
		}
		auctionList.add(ac);
	}
    
    public static String retrieveAllAuctions(ArrayList<Auction> auctionList) {
		String output = "";

		for (int i = 0; i < auctionList.size(); i++) {

			output += String.format("%-84s\n", auctionList.get(i).toString());
		}
		return output;
    }
    
    public static void viewAuctions(ArrayList<Auction> auctionList) {
        C206_CaseStudy.setHeader("AUCTION LIST");
        if (auctionList.isEmpty()) {
            System.out.println("No auctions created");
        } else {
        	String output = String.format("%-10s %-20s %-20s %-20s %-13s %-10s\n", 
        			"ID ", "ITEM NAME", "ITEM DESCRIPTION", "STARTING PRICE",
    				"START DATE", "END DATE");
    		output += retrieveAllAuctions(auctionList);
    		System.out.println(output);
        }
        
    }
    public static void editAuctions(ArrayList<Auction> auctionList) {
    	viewAuctions(auctionList);
		
		int id = Helper.readInt("Enter the ID of a auction to edit > ");
		
		String newName = Helper.readString("Enter the new Item Name > ");
		String newDes = Helper.readString("Enter the new description > ");
		double newPrice = Helper.readDouble("Enter the new Starting Price > ");
		String newStartdate = Helper.readString("Enter the new Starting Date > ");
		String newEnddate = Helper.readString("Enter the new Ending Date > ");
		
		for (int i = 0; i < auctionList.size(); i++) {
			if (id == auctionList.get(i).getId()){			
				auctionList.get(i).setItemName(newName);
				auctionList.get(i).setDescription(newDes);
				auctionList.get(i).setStartingPrice(newPrice);
				auctionList.get(i).setStartDate(newStartdate);
				auctionList.get(i).setEndDate(newEnddate);
				
				System.out.println("Auction successfully updated");
			}
		}
    } 



    public static void deleteAuctions(ArrayList<Auction> auctionList) {
        viewAuctions(auctionList);

        int id = Helper.readInt("Enter the ID of an auction to delete > ");

        Auction auctionToRemove = null;
        for (Auction auction : auctionList) {
            if (id == auction.getId()) {
                auctionToRemove = auction;
                break;
            }
        }

        if (auctionToRemove != null) {
            auctionList.remove(auctionToRemove);
            System.out.println("Auction successfully deleted");
        } else {
            System.out.println("Auction not found. Deletion not successful.");
        }
    }


}
