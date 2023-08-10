import java.util.ArrayList;

public class Auction {
    private String itemName;
    private String description;
    private double startingPrice;
    private String startDate;
    private String endDate;
    private ArrayList<Bid> bids;

    public Auction(String itemName, String description, double startingPrice, String startDate, String endDate) {
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bids = new ArrayList<>();
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

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public ArrayList<Bid> getBidsByBidder(Bidder bidder) {
        ArrayList<Bid> bidderBids = new ArrayList<>();
        for (Bid bid : bids) {
            if (bid.getBidder().equals(bidder)) {
                bidderBids.add(bid);
            }
        }
        return bidderBids;
    }
}
