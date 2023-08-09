
public class Administrator {
    private String username;
    private String password;
    private String role;


    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "Administrator";
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    public String getRole() {
        return role;
    }


	
}

