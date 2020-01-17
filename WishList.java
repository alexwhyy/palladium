import java.io.*;
import java.util.ArrayList;
public class WishList extends SavedProducts{
   public ArrayList<Product> wishList = new ArrayList<Product>();      
   private String filePath;
   private int length;
   public WishList(String filePath){
      this.filePath = filePath;
      Product parsedProduct;
      try {
         BufferedReader in = new BufferedReader(new FileReader(this.filePath));
         String input;
         while ((input = in.readLine()) != null) {
            length = Integer.parseInt(input);
            for (int i = 0; i < length; i++) {
               parsedProduct = new Product(in.readLine(), Double.parseDouble(in.readLine()), in.readLine(), in.readLine(), Boolean.parseBoolean(in.readLine()), Double.parseDouble(in.readLine()));
               wishList.add(parsedProduct);
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
   public void addToShoppingCart(int position, ArrayList<Product> shoppingCart){
      shoppingCart.add(wishList.get(position));
      wishList.remove(position);
   }
   private void updateFile(){
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
         out.write(length);
         out.newLine();
         for (int i = 0 ; i < length; i ++){
            out.write(wishList.get(i).toString());
            out.newLine();
         }
         out.close();
      }catch (IOException iox){

      }
   }

}