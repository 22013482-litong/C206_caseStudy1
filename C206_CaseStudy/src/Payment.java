



public class Payment extends C206_CaseStudy{

	private String BidderName;

	public Payment(String paymentAmount, String paymentMethod, String username) {
		super(paymentAmount, paymentMethod);
		this.BidderName = username;
	}

	public String getBidderName() {
		return BidderName;
	}
	
	public String toString(){

		// Write your codes here
		String output = super.toString();
		output = String.format("%-63s %-20s", output, BidderName);
		return output;
	}
}