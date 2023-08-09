public class Auction {
	private static int nextId = 1; // Static variable to keep track of the next ID
    private int id;
	private String itemName;
    private String description;
    private double startingPrice;
    private String startDate;
    private String endDate;

    
    public Auction(String itemName, String description, double startingPrice, String startDate, String endDate) {
    	this.id = nextId; // Assign the current nextId value to urId
        nextId++; // Increment nextId for the next user
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String toString() {
		
		// Write your codes here
		String userInfo = String.format("%-10d %-20s %-20s %-20s %-13s %-10s",
				id,
				itemName,
				description, 
				startingPrice,
				startDate,
				endDate);
		
		return userInfo;
	}
   
    public int getId() {
		return id;
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
    
    public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}

