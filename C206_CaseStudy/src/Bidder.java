public class Bidder {
  
      private String username;
      private String password;

      
      public Bidder(String username, String password) {
          this.username = username;
          this.password = password;
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
  }