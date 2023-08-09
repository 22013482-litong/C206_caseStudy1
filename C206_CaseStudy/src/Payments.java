
public class Payments extends Payment{
	private double paymentAmount;

	public Payments(double paymentAmount, String paymentMethod, String username) {
		super(username, paymentMethod);
		this.paymentAmount = paymentAmount;
	}

	public double getpaymentAmount() {
		return paymentAmount;
	}
	
	public String toString(){
		
		String output = super.toString();
		output = String.format("%-63s %-20d", output,paymentAmount);
		return output;
	}
}

