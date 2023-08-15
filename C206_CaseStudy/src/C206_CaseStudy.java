
import java.util.ArrayList;
import java.util.List;




public class C206_CaseStudy {
    private static final int OPTION_ADMINLOGIN = 2;
	private static final int OPTION_CREATE = 1;
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_BIDDERLOGIN = 3;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private static ArrayList<Bidder> bidderList = new ArrayList<Bidder>();
    private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();

    public C206_CaseStudy(String paymentAmount, String paymentMethod) {
    
    }

    public static void main(String[] args) {
    	
    	auctionList.add(new Auction("Lenovo Laptop", "A laptop",1200.10,"12/3/2023","12/4/2023"));
        bidderList.add(new Bidder("bidder2", "password2","bidder"));
        adminList.add(new Administrator("admin1", "password0"));

        int option = 0;

        while (option != OPTION_QUIT) {
            C206_CaseStudy.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_CREATE) {
                //create account
            } else if (option == OPTION_ADMINLOGIN) {
                loginAsAdministrator();
            } else if (option == OPTION_BIDDERLOGIN)  {
            	loginAsBidder();
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
        System.out.println("2. Log In admin");
        System.out.println("3. Log In Bidder");
        System.out.println("4. Quit");
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
        String role = Helper.readString("Enter your role > ");
        
	    for (Bidder bidder : bidderList) {
	        if (bidder.getUsername().equals(username) && bidder.getPassword().equals(password)&&  bidder.getRole().equals(role)) {
	        	loginAcc = bidder;
	        	Helper.line(80,"-");
	        	System.out.println("Login successful");
	        	Helper.line(80,"-");
	        	bidderMenu();
	            //bidder menu here
	        }
	        else {
           	 System.out.println("Invalid username or password");
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
	
	public static void bidderMenu() {
	       
		C206_CaseStudy.setHeader("BIDDER MENU");
		bidderMenu1();
        Helper.line(80, "-");

        int option = Helper.readInt("Enter an option > ");
        if (option == 1) {
            //create bidder
        	Bidder b = inputBidder();
			C206_CaseStudy.addBidder(bidderList, b);
			System.out.println();
			System.out.println("new bidder created and added successfully");

        } else if (option == 2) {
            //view Bidder
        	viewBidder(bidderList);
        } else if (option == 3) {
            //edit Bidder
        	editBidder(bidderList);
        } else if (option == 4) {
            //delete auction
        	deletebidder(bidderList);
        } else if (option == 5) {
            
            System.out.println("Logged out");
            return;
        } else {
            System.out.println("Invalid option");
        }
        bidderMenu();

    }
	private static Bidder inputBidder() {
		// TODO Auto-generated method stub
		String username = Helper.readString("Enter username > ");
  		String password = Helper.readString("Enter password > ");
  		String role = Helper.readString("Enter your role > ");
  		
  		Bidder b= new Bidder(username, password,role);
  		return b;
	}
    public static  void addBidder(ArrayList<Bidder> bidderList, Bidder b) {
		// TODO Auto-generated method stub
    	Bidder bidder ;
  		for(int i = 0; i < bidderList.size(); i++) {
  			bidder = bidderList.get(i);
			if (bidder.getUsername()==(b.getUsername()))
				return;
  		}
  		bidderList.add(b);
	}
    public static String retrieveAllBidder(ArrayList<Bidder> bidderList) {
		String output = "";
		
		for (int i = 0; i < bidderList.size(); i++) {
			output += String.format("%-62s\n", bidderList.get(i).toString());
		}
		return output;
	}
    
    public static void viewBidder(ArrayList<Bidder> BidderList) {
    	// TODO Auto-generated method stub
    	C206_CaseStudy.setHeader("BIDDER LIST");
		String output = String.format("%-10s %-30s %-10s \n", "USERNAME", "PASSWORD",
				"ROLE");
		output += retrieveAllBidder(BidderList);	
		System.out.println(output);
	}
    	
    public static void editBidder(ArrayList<Bidder> bidderList) {
    	// TODO Auto-generated method stub
    	viewBidder(bidderList);

    	String username = Helper.readString("Enter the username of a bidder to edit > ");
    	String newUserName = Helper.readString("Enter the new  Username > ");
    	String newPassword = Helper.readString("Enter the new password > ");
    	String newRole = Helper.readString("Enter the new role > ");

    	boolean updated = false; // To track if any bidder was updated

    	for (int i = 0; i < bidderList.size(); i++) {
    	    if (username.equals(bidderList.get(i).getUsername())) {
    	        bidderList.get(i).setUsername(newUserName);
    	        bidderList.get(i).setPassword(newPassword);
    	        bidderList.get(i).setRole(newRole);
    	        updated = true;
    	     
    	    }
    	}

    	if (updated) {
    	    System.out.println("Bidder successfully updated");
    	} else {
    	    System.out.println("Bidder not found");
    	}
    }
    

    public static boolean dodeletebidder(ArrayList<Bidder> bidderList,String username) {
		boolean isdeleted = false;

		if (username.isEmpty())
			return false;
		
		for (int i = 0; i < bidderList.size(); i++) {
			if (username.equalsIgnoreCase(bidderList.get(i).getUsername())) {
				isdeleted = true;
				
			}
		}
		return isdeleted;
		
		
	}
	public static void deletebidder(ArrayList<Bidder> bidderList) {
		C206_CaseStudy.viewBidder(bidderList);
	    String username = Helper.readString("Enter username > ");

	    Bidder bidderToRemove = null;
	    for (Bidder bidder : bidderList) {
	        if (username.equals(bidder.getUsername())) {
	            bidderToRemove = bidder;
	            break;  // Exit the loop since we found the bidder to remove
	        }
	    }

	    if (bidderToRemove != null) {
	        bidderList.remove(bidderToRemove);
	        System.out.println("Bidder successfully deleted");
	    } else {
	        System.out.println("Bidder not found. Deletion failed.");
	    }
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
    public static void bidderMenu1() {
    	// TODO Auto-generated method stub
    	System.out.println("1. add bidder");
        System.out.println("2. View bidder");
        System.out.println("3. Edit bidder");
        System.out.println("4. Delete Bidder");
        System.out.println("5. Log Out");
    	
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
