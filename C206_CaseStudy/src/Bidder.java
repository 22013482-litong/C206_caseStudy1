public class Bidder {
	
	private String username;
    private String password;
    private String role;
      
      
    public Bidder(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

 

public String toString() {
		
		// Write your codes here
		String userInfo = String.format("%-10s %-30s %-20s",
				username,
				password,
				role);
		
		return userInfo;
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