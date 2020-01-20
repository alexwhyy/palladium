import java.io.*;
import java.util.ArrayList;

public class WebsiteAccountList {


    private ArrayList<WebsiteAccount> websiteAccounts;
    public int length;
    String filePath;

    public WebsiteAccountList(String filePath) {
        this.filePath = filePath;
        WebsiteAccount parsedWebsiteAccount;
         websiteAccounts = new ArrayList<WebsiteAccount>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.filePath));
            String input;
            while ((input = in.readLine()) != null) {
                length = Integer.parseInt(input);
                for (int i = 0; i < length; i++) {
                    parsedWebsiteAccount = new WebsiteAccount(in.readLine(),in.readLine(),in.readLine());
                    websiteAccounts.add(parsedWebsiteAccount);
                }
            }
            in.close();
        } catch (IOException iox) {
            System.out.println(" ____________________________________");
            System.out.println("|                                    |");
            System.out.println("| File Reading Error!                |");
            System.out.println("|                                    |");
            System.out.println("|____________________________________|");
            System.out.println("Error: " + iox + "\n");
        }
    }


    public WebsiteAccount getIndex(int index) {
        if (index > this.length - 1) {
            return null;
        } else {
            return this.websiteAccounts.get(index);
        }
    }

    public boolean addWebsiteAccount(WebsiteAccount new_websiteAccount) {
        try {
            websiteAccounts.add(new_websiteAccount);
            this.length++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeWebsiteAccount(int index) {
        try {
            this.websiteAccounts.remove(index);
            length--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void updateFile() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(length);
            out.newLine();
            for (int i = 0; i < length; i++) {
                out.write(this.websiteAccounts.get(i).toString());
                out.newLine();
            }
            out.close();
        } catch (IOException iox) {

        }
    }

}

