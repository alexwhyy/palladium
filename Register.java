public class Register extends Access{
   
	UserList ul = new UserList();

	final int PASSWORD_MIN_LENGTH = 8;
	final int PASSWORD_MAX_LENGTH = 32;

	public boolean checkUsername(){
		if(ul.findUsername(inputUsername) < 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkPassword(){
		boolean lowerCaseCheck = false;
		boolean upperCaseCheck = fasle;
		boolean numberCheck = false;
		boolean symbolCheck = false;
		
		if(inputPassword.length() >= PASSWORD_MIN_LENGTH && inputPassword.length() <= PASSWORD_MAX_LENGTH){
			
			for(int i = 0; i < inputPassword.length(); i++){
				char input = inputPassword.charAt(i);
				if(input >= 'a' && input <= 'z'){
					lowerCaseCheck = true;
				}
				else if(input >= 'A' && input <= 'Z'){
					upperCaseCheck = true;
				}
				else if(input >= '0' && input <= '9'){
					numberCheck = true;
				}
				else{
					symbolCheck = true;
				}
			}
			
			if(lowerCaseCheck == true && upperCaseCheck == true && numberCheck == true && symbolCheck == true){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
}
