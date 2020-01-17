import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Catalog extends SavedProducts {
   public ArrayList<Product> catalog = new ArrayList<Product>();
   int length;
   String filePath;
   public Catalog(String filePath){
      this.filePath = filePath;
      Product parsedProduct;
      try {
         BufferedReader in = new BufferedReader(new FileReader(this.filePath));
         String input;
         while ((input = in.readLine()) != null) {
            length = Integer.parseInt(input);
            for (int i = 0; i < length; i++) {
               parsedProduct = new Product(in.readLine(), Double.parseDouble(in.readLine()), in.readLine(), in.readLine(), Boolean.parseBoolean(in.readLine()), Double.parseDouble(in.readLine()));
               catalog.add(parsedProduct);
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
}