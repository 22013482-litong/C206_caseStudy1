
public class Payment extends C206_CaseStudy{
	private double paymentAmount;
    private String paymentMethod;
    private String username;

	

	public Payment(double paymentAmount, String paymentMethod, String username) {
		
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.username = username;
	}

    public String toString() {
		
		
		String paymentInfo = String.format("%-10s %-30s %-10s %-10s",
				paymentAmount,
				paymentMethod, 
				username);
		return paymentInfo;
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	
	
}