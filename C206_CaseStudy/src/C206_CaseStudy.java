import java.util.ArrayList;





public class C206_CaseStudy {
    private static final int OPTION_ADMINLOGIN = 2;
	private static final int OPTION_CREATE = 1;
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_BIDDERLOGIN = 3;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private static ArrayList<Bidder> bidderList = new ArrayList<Bidder>();
    private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
    private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
    
    public static void main(String[] args) {
    	
    	auctionList.add(new Auction("Lenovo Laptop", "A laptop",1200.10,"12/3/2023","12/4/2023"));
        bidderList.add(new Bidder("bidder2", "password2"));
        adminList.add(new Administrator("admin1", "password0"));
        paymentList.add(new Payment(1600, "Credit Card", "Snorlax"));

        int option = 0;

        while (option != OPTION_QUIT) {
            C206_CaseStudy.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_CREATE) {
                //create account
            	 int accountType = Helper.readInt("Enter account type (1 for Bidder, 2 for Administrator) > ");
            	    String username = Helper.readString("Enter username > ");
            	    String password = Helper.readString("Enter password > ");

            	    if (accountType == 1) {
            	        Bidder newBidder = new Bidder(username, password);
            	        bidderList.add(newBidder);
            	        System.out.println("Bidder account created successfully.");
            	    } else if (accountType == 2) {
            	        Administrator newAdmin = new Administrator(username, password);
            	        adminList.add(newAdmin);
            	        System.out.println("Administrator account created successfully.");
            	    } else {
            	        System.out.println("Invalid account type.");
            	    }
            	
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
    	Bidder loginAccount = null;
    	String username = Helper.readString("Enter your username > ");
        String password = Helper.readString("Enter your password > ");

        for (Bidder bidder : bidderList) {
            if (bidder.getUsername().equals(username) && bidder.getPassword().equals(password)) {
                System.out.println("Login successful");
                //bidder menu here
               BidderMenu();
                      
               
               loginAccount = bidder;
               
            }
        }
            else  {
            	System.out.println("Login failed");
            }
            return loginAccount;
        }
    
    private static Payment inputPayment() {
		// TODO Auto-generated method stub
		double paymentAmount = Helper.readDouble("Enter payment amount > $");
    	String paymentMethod = Helper.readString("Enter payment method > ");
  		String name = Helper.readString("Enter username > ");
  		
  		Payment p = new Payment(paymentAmount, paymentMethod, name);
  		return p;
	}
    
    public static String retrieveAllPayment(ArrayList<Payment> paymentList) {
		String output = "";
		
		for (int i = 0; i < paymentList.size(); i++) {
			output += String.format("%-10s %-30s  %-10s \n", paymentList.get(i).getUsername(),
					paymentList.get(i).getPaymentAmount(), 
					paymentList.get(i).getPaymentMethod());
		}
		return output;
	}

    public static  void addPayment(ArrayList<Payment> paymentList, Payment P) {
		// TODO Auto-generated method stub
    	Payment payment;
  		for(int i = 0; i < paymentList.size(); i++) {
  			payment = paymentList.get(i);
  			if (payment.getUsername().equalsIgnoreCase(payment.getUsername()));	
  			System.out.println("Payment submitted");
  			return;
  		}
  		paymentList.add(P);
    	

        for (Administrator admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                loggedInAdmin = admin;
                System.out.println("Login successful");
                adminMenu();
                return;
            }
        }
        
        System.out.println("Invalid username or password");

	    for (Bidder bidder : bidderList) {
	        if (bidder.getUsername().equals(username) && bidder.getPassword().equals(password)) {
	        	loginAccount = bidder;
	        	Helper.line(80,"-");
	        	System.out.println("Login successful");
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
	
	public static void BidderMenu() {
	       
    	C206_CaseStudy.setHeader("BIDDER MENU");
        BidderMenu();
        Helper.line(80, "-");

        int option = Helper.readInt("Enter an option > ");
        if (option == 1) {
            //add bidder
        	Bidder Bidder1 = inputBidder();
			C206_CaseStudy.addBidder(bidderList, Bidder1);
			System.out.println();
			System.out.println("new bidder added successfully");

        } else if (option == 2) {
            //view bidder
        	
        	viewBidder(bidderList);
        } else if (option == 3) {
            //edit bidder
        	editBidder(bidderList);
        } else if (option == 4) {
            //delete bidder
        	deleteBidder(bidderList);
        } else if (option == 5) {
            
            System.out.println("Logged out");
            return;
        } else {
            System.out.println("Invalid option");
        }
        BidderMenu();

    }

	private static Bidder inputBidder() {
		// TODO Auto-generated method stub
		String username = Helper.readString("Enter username > ");
  		String password = Helper.readString("Enter password > ");
  		
  		Bidder b= new Bidder(username, password);
  		return b;
	}
    public static  void addBidder(ArrayList<Bidder> bidderList, Bidder b) {
		// TODO Auto-generated method stub
    	Bidder bidder;
  		for(int i = 0; i < bidderList.size(); i++) {
  			bidder = bidderList.get(i);
  			if (bidder.getUsername().equalsIgnoreCase(bidder.getUsername()));	
  			return;
  		}
  		bidderList.add(b);
	}
    public static String retrieveAllBidder(ArrayList<Bidder> BidderList) {
		String output = "";
		
		for (int i = 0; i < BidderList.size(); i++) {
			output += String.format("%-10s %-30s  %-10s \n", BidderList.get(i).getUsername(),
					BidderList.get(i).getPassword(), 
					BidderList.get(i).getRole());
		}
		return output;
	}
    
    private static void viewBidder(ArrayList<Bidder> BidderList) {
    	// TODO Auto-generated method stub
    	C206_CaseStudy.setHeader("BIDDER LIST");
		String output = String.format("%-10s %-30s %-10s \n", "USERNAME", "PASSWORD",
				"ROLE");
		output += retrieveAllBidder(BidderList);	
		System.out.println(output);
	}
    	
    private static void editBidder(ArrayList<Bidder> bidderList) {
    	// TODO Auto-generated method stub
    	viewBidder(bidderList);
		
		int id = Helper.readInt("Enter the ID of a bidder to edit > ");
		
		String newUserName = Helper.readString("Enter the new  Username > ");
		String newPassword = Helper.readString("Enter the new password > ");
		String newRole = Helper.readString("Enter the new role > ");
	
		
		for (int i = 0; i < bidderList.size(); i++) {
			if (id == auctionList.get(i).getId()){			
				bidderList.get(i).setUsername(newUserName);
				bidderList.get(i).setPassword(newPassword);
				bidderList.get(i).setRole(newRole);
				
				
				System.out.println("bidder successfully updated");
			}
		}
    } 
    
    public static boolean doDeleteBidder(ArrayList<Bidder> BidderList,String username) {
		boolean isDeleted = false;

		if (username.isEmpty())
			return false;
		
		for (int i = 0; i < BidderList.size(); i++) {
			if (username.equalsIgnoreCase(BidderList.get(i).getUsername())) {
				isDeleted = true;
				
			}
		}
		return isDeleted;
		
	}

	private static void deleteBidder(ArrayList<Bidder> bidderList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.viewBidder(bidderList);
		String username = Helper.readString("Enter username > ");
		Boolean isDeleted = doDeleteBidder(bidderList, username);
		
		if (isDeleted == false) {
			System.out.println("Incorrect username");
		} else {
			System.out.println("bidder " + username + " is deleted ");
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
    private static void bidderMenu() {
    
    	System.out.println("1. add bidder");
        System.out.println("2. View bidder");
        System.out.println("3. Edit bidder");
        System.out.println("4. Delete Auction");
        System.out.println("5. Add payment");
        System.out.println("6. Log Out");
    	
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
