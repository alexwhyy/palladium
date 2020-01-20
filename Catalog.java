import java.io.*;
import java.util.ArrayList;

public class Catalog extends SavedProducts {
    public ArrayList<Product> catalog = new ArrayList<Product>();
    int length;
    String filePath;

    public Catalog(String filePath) {
        this.filePath = filePath;
        Product parsedProduct;
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.filePath));
            String input = in.readLine();

            length = Integer.parseInt(input)-1;

            for (int i = 0; i < length ; i++) {

                parsedProduct = new Product(in.readLine(), Double.parseDouble(in.readLine()), in.readLine(), in.readLine(), Double.parseDouble(in.readLine()), Integer.parseInt(in.readLine()));
                catalog.add(parsedProduct);

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

    public Product getProductId(int id) {
        for (int i = 0; i < length; i++) {
            if (catalog.get(i).getId() == id) return catalog.get(i);
        }
        return null;
    }

    public Product getProductIndex(int index) {
        if (index > this.catalog.size() - 1) {
            return null;
        } else {
            return this.catalog.get(index);
        }
    }

    public ArrayList<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Product> catalog) {
        this.catalog = catalog;
    }

    void updateFile() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(""+length);
            out.newLine();
            for (int i = 0; i < length; i++) {
                out.write(catalog.get(i).toString(false));
                out.newLine();
            }
            out.close();
        } catch (IOException iox) {
        }
    }
}