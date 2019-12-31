public class Login extends Access{
   
   public boolean checkUsername(String input){
      if(userList.findUsername(input) >= 0){
         return true;
      }
      else{
         return false;
      }
   }
   
   public boolean checkPassword(String input){
      if(userList.findUsername(input).password == inputPassword){
         return true;
      }
      else{
         return false;
      }
   }
   
}
