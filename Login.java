public class Login extends Access{

	UserList ul = new UserList();
	
	public boolean checkUsername(){
		if(ul.findUsername(inputUsername) >= 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkPassword(){
		if(ul.findPassword(ul.findUsername(inputUsername)).compareTo(inputPassword) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
