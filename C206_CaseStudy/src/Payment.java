public class Payment{
    private double paymentAmount;
    private String paymentMethod;
    private String username;

    // Constructor
    public Payment(double paymentAmount, String paymentMethod, String username) {
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.username = username;
    }

    // Getter methods
    public double getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        // Format the payment information for display
        String paymentInfo = String.format("%-10s %-30s %-10s",
                paymentAmount,
                paymentMethod,
                username);
        return paymentInfo;
    }
}