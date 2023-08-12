
public class BidderTest {

	public class Bidder {
		private String assetTag;
		private String description;
		private String dueDate;
		private boolean isAvailable;

		
		public String toString() {
			
			// Write your codes here
			String itemInfo = String.format("%-10s %-30s %-10s %-10s",
					assetTag,
					description, 
					showAvailability(isAvailable),
					dueDate);
			return itemInfo;
		}
		
		public  String showAvailability(boolean isAvailable) {
			String avail;

			if (isAvailable == true) {
				avail = "Yes";
			} else {
				avail = "No";
			}
			return avail;
		}
		public String getAssetTag() {
			return assetTag;
		}

		public String getDescription() {
			return description;
		}

		public String getDueDate() {
			return dueDate;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

		public boolean getIsAvailable() {
			return isAvailable;
		}

		public void setIsAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
	}



}
