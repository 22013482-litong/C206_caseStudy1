public class User {
	
	private String username;
    private String password;
    private String role;
      
    
    public User(String username, String password, String role) {
    	this.username = username;
        this.password = password;
        this.role = role;
    }
     
      
    public String getUsername() {
        return username;
    }
     
    public void setUsername(String newUsername) {
		this.username = newUsername;
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