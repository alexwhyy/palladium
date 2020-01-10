import java.io.*;
public class login {
    loginAccount [] list;
    int numAccount;
    final String WEAKPASSWORD = "Weak password \n Please make sure your password has: \n -More than 8 characters \n -Upper and lower letter \n -Numbers \n -Special characters";

    public login() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/accountList.txt"));
            String input;
            numAccount = Integer.parseInt(in.readLine());
            list = new loginAccount[numAccount];
            for (int i = 0; i < numAccount; i++) {
                list[i] = new loginAccount(in.readLine(),in.readLine(),in.readLine());
            }

            in.close();
        } catch (IOException iox) {
            System.out.println("error");
        }

    }

    public String compareLogin(String username, String password){
        for(int i = 0 ; i < numAccount; i++){
            if(username.compareTo(list[i].getUsername()) + password.compareTo(list[i].getPassword()) == 0){
                return username;
            }
        }
        return "not found";
    }
    public String forgetPassword (String username , String email){
        for(int i = 0 ; i < numAccount ; i++){
            if(username.compareTo(list[i].getUsername()) + email.compareTo(list[i].getEmail()) == 0 )
                return list[i].getPassword();
        }
        return "Username does not exist or wrong email";
    }

    public String register(String username, String password, String email){

            boolean usernameTaken = false;
            for (int i = 0 ; i < numAccount ; i ++ ){
                if(username.compareTo(list[i].getUsername()) == 0){
                    usernameTaken = true;
                }
            }

            if (checkPasswordStrength(password) && usernameTaken == false){
                addUser(username,password,email);
                return "registration successful";
            }else if(usernameTaken) return "Username Taken";
            else return WEAKPASSWORD;

        }

    private boolean checkPasswordStrength(String password){
        boolean uppercase = false;
        boolean lowercase = false;
        boolean number = false;
        boolean symbol = false;
        for(int i =0 ; i < password.length(); i ++){
            if(password.charAt(i) <= 'z' && password.charAt(i) >= 'a' ) lowercase = true;
            else if(password.charAt(i) <= 'Z' && password.charAt(i) >= 'A' ) uppercase = true;
            else if (password.charAt(i) <= '9' && password.charAt(i) >= '0' ) number = true;
            else symbol = true;

            }
         return password.length() >= 8 &&uppercase  && lowercase  && number && symbol ;
        }

    public void addUser(String username, String password, String email) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/main/test.txt", true));

            RandomAccessFile randomAccess = new RandomAccessFile("src/main/test.txt","rw");
            randomAccess.seek(0);
            randomAccess.write((""+(numAccount+1)).getBytes());
            out.write(username);
            out.newLine();
            out.write(password);
            out.newLine();
            out.write(email);
            out.newLine();
            out.close();
            randomAccess.close();
        }catch (IOException iox){
            System.out.println("Error");
        }catch (Exception e){

        }


    }

}