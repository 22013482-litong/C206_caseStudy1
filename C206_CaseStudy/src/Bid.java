
public class Bid {
	private Auction auction;
    private Bidder bidder;
    private double bidAmount;

    public Bid(Auction auction, Bidder bidder, double bidAmount) {
        this.auction = auction;
        this.bidder = bidder;
        this.bidAmount = bidAmount;
    }

    public Auction getAuction() {
        return auction;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public double getBidAmount() {
        return bidAmount;
    }
    
}
