import java.util.ArrayList;
public class UserList{
   public ArrayList<User> userList = new ArrayList<User>();
   
   public int findUsername(String username){
      for(int i = 0; i < userList.size(); i++){
         if(userList.get(i).username == username){
            return i;
         }
      }
      return -1;
   }
   
}
