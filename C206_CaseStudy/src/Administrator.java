import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private String username;
    private String password;
    private String role;
    private List<Auction> auctions;


    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "Administrator";
        this.auctions = new ArrayList<>();
    }

    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    public String getRole() {
        return role;
    }
   
    public void createAuction(String itemName, String description, double startingPrice, String startDate, String endDate) {
        if (itemName.isEmpty() || description.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            System.out.println("Error: Please fill in all the mandatory fields before creating an auction.");
            return;
        }

        Auction newAuction = new Auction(itemName, description, startingPrice, startDate, endDate);
        auctions.add(newAuction);

        System.out.println("Auction has been created.");
    }
}

