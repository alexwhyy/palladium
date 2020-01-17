import java.io.*;
import java.util.ArrayList;
public class ShoppingCart extends SavedProducts{
   public ArrayList<Product> shoppingCart = new ArrayList<Product>();
   String filePath;
   int length;
   public ShoppingCart(String filePath){
      this.filePath = filePath;
      Product parsedProduct;
      try {
         BufferedReader in = new BufferedReader(new FileReader(this.filePath));
         String input;
         while ((input = in.readLine()) != null) {
            length = Integer.parseInt(input);
            for (int i = 0; i < length; i++) {
               parsedProduct = new Product(in.readLine(), Double.parseDouble(in.readLine()), in.readLine(), in.readLine(), Boolean.parseBoolean(in.readLine()), Double.parseDouble(in.readLine()));
               shoppingCart.add(parsedProduct);
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
   /*
   Name: addToWishList
   Purpose: moves a product from ShoppingCart to WishList
   Description: passes in ArrayList(from WishList) and the position of product
   in ShoppingCart
   */
   public void addToWishList(int position, ArrayList<Product> wishList){
      wishList.add(shoppingCart.get(position));
      shoppingCart.remove(position);
      updateFile();
   }
   private void updateFile(){
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
         out.write(length);
         out.newLine();
         for (int i = 0 ; i < length; i ++){
            out.write(shoppingCart.get(i).toString(true));
            out.newLine();
         }
         out.close();
      }catch (IOException iox){

      }
   }
}
