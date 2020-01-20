public class WebsiteAccount {
    private String account;
    private String password;
    private String website;

    public WebsiteAccount(String account, String password, String website) {
        this.account = account;
        this.password = password;
        this.website = website;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
