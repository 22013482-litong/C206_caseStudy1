import java.util.ArrayList;
import java.util.List;

public class Profile {
    private Bidder bidder;
    private Administrator admin;
    private List<Auction> auctions;

    
    public Profile(Bidder bidder, Administrator admin) {
        this.bidder = bidder;
        this.admin = admin;
        this.auctions = new ArrayList<>();
    }
    public List<Auction> getAuctions() {
        return auctions;
    }
    
    public boolean login(String username, String password) {
        if (bidder != null && bidder.getUsername().equals(username) && bidder.getPassword().equals(password)) {
            return true; 
        } else if (admin != null && admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            return true; 
        }
        return false; 
    }

   
    public void logout() {
        
    }

  
    public void createAuction(String itemName, String description, double startingPrice, String startDate, String endDate) {
        if (admin == null) {
            System.out.println("You are not authorized to create an auction");
            return;
        }

        if (itemName.isEmpty() || description.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            System.out.println("Fill in all parameters");
            return;
        }

        Auction newAuction = new Auction(itemName, description, startingPrice, startDate, endDate);
        auctions.add(newAuction);

        System.out.println("Auction has been created");
    }


    public boolean changePassword(String oldPassword, String newPassword, String confirmPassword) {
        if (bidder != null && bidder.getPassword().equals(oldPassword)) {
            if (!oldPassword.equals(newPassword) && newPassword.equals(confirmPassword)) {
                bidder.setPassword(newPassword);
                return true;
            }
        } else if (admin != null && admin.getPassword().equals(oldPassword)) {
            if (!oldPassword.equals(newPassword) && newPassword.equals(confirmPassword)) {
                admin.setPassword(newPassword);
                return true;
            }
        }
        return false; 
    }
   
   
    
    public Bidder getBidder() {
        return bidder;
    }

    public Administrator getAdmin() {
        return admin;
    }
}
    
