import java.util.ArrayList;

public class UserUX {
    private static final int OPTION_LOGIN = 2;
	private static final int OPTION_CREATE = 1;
	private static final int OPTION_QUIT = 3;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private static ArrayList<User> userList = new ArrayList<User>();
    private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
    
    //User version (Admin and Bidder are considered as "User"
    
    public static void main(String[] args) {
	    userList.add(new User("userA", "userAPass", "Admininstrator"));
	    userList.add(new User("userB", "userBPass", "Bidder"));
    	int option = 0;
    	
        while (option != OPTION_QUIT) {
            UserUX.menu();

            if (option == OPTION_CREATE) {
                UserUX.addAcc();
            } 
            else if (option == OPTION_LOGIN) {
                UserUX.login();
            }
        }
    	
    }
    
    public static void menu() {
        Helper.line(80, "-");
        System.out.println("ONLINE AUCTION APP");
        Helper.line(80, "-");
		System.out.println("1. Create Account");
        System.out.println("2. Log In");
        System.out.println("3. Quit");
        Helper.line(80, "-");
        option = Helper.readInt("Enter your option > ");
    }
    
    public static void login() {
        String username = Helper.readString("Username > ");
        String password = Helper.readString("Password > ");
        
        boolean isFound = false;
        for (int i=0; i<userList.size(); i++){
        	if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password))
        	{
        		System.out.println("Welcome, " + userList.get(i).getUsername());
        		isFound = true;
        	}
        }	
        if (isFound == false) {
            System.out.println("Wrong username or password, please try again.");
        }
        
    }
    
    public static void addAcc() {
        String addUser = Helper.readString("Enter your username > ");
        String addPassword = Helper.readString("Enter your password > ");
        
        for (int i=0; i<userList.size(); i++){
        	if (userList.get(i).getUsername().equals(addUser))
        	{
        		System.out.println("Username taken, choose another username");
        	}
        	else {
        		userList.add(new User(addUser, addPassword, "Bidder"));
        		System.out.println("User added, returning to menu");
        		UserUX.menu();
        	}
        }	
    }

}