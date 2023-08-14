public class Bidder {
	
	private String username;
    private String password;
    private String role;
      

      
    public Bidder(String username, String password) {
    	this.username = username;
        this.password = password;
        this.role = "Bidder";
    }
     
      
    public String getUsername() {
        return username;
    }
     
    public void setUsername(String username) {
		this.username = username;
	}
    
    public String getRole() {
        return role;
    }

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }


}