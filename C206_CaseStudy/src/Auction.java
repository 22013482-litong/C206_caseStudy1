public class Auction {
    private String itemName;
    private String description;
    private double startingPrice;
    private String startDate;
    private String endDate;

    
    public Auction(String itemName, String description, double startingPrice, String startDate, String endDate) {
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

   
    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
