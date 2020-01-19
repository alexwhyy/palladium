public class test {
    public static void main(String[] args) {
        DateTime d = new DateTime("12/31/2020");
        CreditCard c = new CreditCard("master", 333609931,1210,d);
        System.out.println(c.toString());
        c.toString();
    }
}
