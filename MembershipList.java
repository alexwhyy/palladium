import java.io.*;
import java.util.ArrayList;

public class MembershipList {
    private ArrayList<Membership> memberships;
    public int length = 0;
    private String filePath;
    private double totalSpent;
    private double annualCost;
    private double montlyCost;

    public MembershipList(ArrayList<Membership> memberships) {
        this.length = memberships.size();
        this.memberships = memberships;
    }

    public MembershipList() {
        this.length = 0;
        this.memberships = new ArrayList<Membership>();
    }

    public ArrayList<Membership> getMemberships() {
        return this.memberships;
    }

    public void setMemberships(ArrayList<Membership> memberships) {
        this.memberships = memberships;
    }

    public double getTotalSpent() {
        return this.totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public double getAnnualCost() {
        return this.annualCost;
    }

    public void setAnnualCost(double annualCost) {
        this.annualCost = annualCost;
    }

    public double getMontlyCost() {
        return this.montlyCost;
    }

    public void setMontlyCost(double montlyCost) {
        this.montlyCost = montlyCost;
    }

    public boolean addMembership(Membership newMembership) {
        try {
            memberships.add(newMembership);
            length++;
            updateFile();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean removeMembership(int index) {
        try {
            memberships.remove(index);
            length--;
            updateFile();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Membership getMembershipIndex(int index) {
        if (index > this.memberships.size() - 1) {
            return null;
        } else {
            return this.memberships.get(index);
        }
    }

    public void updateFile() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(""+length);
            out.newLine();
            for (int i = 0; i < length; i++) {
                out.write(memberships.get(i).toString());
                out.newLine();
            }
            out.close();
        } catch (IOException iox) {

        }
    }

    public MembershipList(String directory) {
        Membership parsedMembership;
        filePath = directory;
    memberships = new ArrayList<Membership>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(directory));

            length = Integer.parseInt(in.readLine())-1;
            for (int i = 0; i < length; i++) {

                parsedMembership = new Membership(in.readLine(), Double.parseDouble(in.readLine()),
                        new DateTime(in.readLine()), new DateTime(in.readLine()), Integer.parseInt(in.readLine()),
                        Double.parseDouble(in.readLine()), in.readLine());
                this.memberships.add(parsedMembership);
                length++;
            }
            in.close();
        } catch (IOException iox) {

        }

    }

}
