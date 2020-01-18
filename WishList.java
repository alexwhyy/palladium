/*
Class Name: WishList
Author: Eric Fang
Date: Dec 18, 2019
School: A.Y.Jackson Secondary School
Purpose: Holds item that user is interested in but does not intend to buy at the moment
*/
import java.io.*;
import java.util.ArrayList;
public class WishList extends SavedProducts{
   protected ArrayList<Product> wishList = new ArrayList<Product>();      
   private String filePath;
   private int length;
   
   /*
   Name: WishList
   Purpose: Initiates WishList
   Description: Passes in filePath in order to read in the contents and saves 
   it for future use 
   */
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
   
   /*
   Name: addToShoppingCart
   Purpose: moves a product from WishList to ShoppingCart
   Description: passes in ArrayList(from ShoppingCart) and the position of product
   in Wishlist
   */
   public void addToShoppingCart(int position, ArrayList<Product> shoppingCart){
      shoppingCart.add(wishList.get(position));
      wishList.remove(position);
      updateFile();
   }
   
   /*
   Name: updateFile
   Purpose: Updates file whenever a change is made
   Description: Uses filePath which was previously saved during intialization 
   */
   void updateFile(){
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
         out.write(length);
         out.newLine();
         for (int i = 0 ; i < length; i ++){
            out.write(wishList.get(i).toString(false));
            out.newLine();
         }
         out.close();
      }
      catch (IOException iox){
      }
   }
}
