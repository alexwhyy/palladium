import java.io.*;

public class Login {

    LoginAccount[] list;
    int numAccount;
    final String WEAKPASSWORD = "Weak password \n Please make sure your password has: \n -More than 8 characters \n -Upper and lower letter \n -Numbers \n -Special characters";

    public Login() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("temp.txt"));
            String input;
            numAccount = Integer.parseInt(in.readLine());
            list = new LoginAccount[numAccount];
            for (int i = 0; i < numAccount; i++) {
                list[i] = new LoginAccount(in.readLine(),in.readLine(),in.readLine());
            }

            in.close();
        } catch (IOException iox) {
            System.out.println(iox);
            System.out.println("error");
        }
    }

    public String compareLogin(String username, String password) {
        for (int i = 0; i < numAccount; i++) {
            if (username.compareTo(list[i].getUsername()) + password.compareTo(list[i].getPassword()) == 0) {
                return username;
            }
        }
        return "not found";
    }

    public String forgetPassword(String username, String email) {
        for (int i = 0; i < numAccount; i++) {
            if (username.compareTo(list[i].getUsername()) + email.compareTo(list[i].getEmail()) == 0)
                return list[i].getPassword();
        }
        return "Username does not exist or wrong email";
    }

    public String register(String username, String password) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("temp.txt", true));
            for (int i = 0; i < numAccount; i++) {
                if (username.compareTo(list[i].getUsername()) == 0) {
                    if (checkPasswordStrength(password)) {
                        out.newLine();
                        out.write(username);
                        out.newLine();
                        out.write(password);
                        return "registration successful";
                    } else
                        return WEAKPASSWORD;
                }
            }
            return "Username taken";
        } catch (IOException iox) {
            return "error";
        }
    }

    private boolean checkPasswordStrength(String password) {
        boolean uppercase = false;
        boolean lowercase = false;
        boolean number = false;
        boolean symbol = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) <= 'z' && password.charAt(i) >= 'a')
                lowercase = true;
            else if (password.charAt(i) <= 'Z' && password.charAt(i) >= 'A')
                uppercase = true;
            else if (password.charAt(i) <= '9' && password.charAt(i) >= '0')
                number = true;
            else
                symbol = true;

        }
        return password.length() >= 8 && uppercase && lowercase && number && symbol;
    }

}
