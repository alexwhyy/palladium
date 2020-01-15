/*
Class Name: 
Author: Eric Fang
Date: Dec 18, 2019
School: A.Y.Jackson Secondary School
Purpose: Abstract class for ShoppingCart and WishList
*/
import java.util.ArrayList;
public abstract class SavedProducts{

   /*
   Name: removeProduct
   Purpose: Removes select product from a list
   Description: passes in ArrayList and the index of the array to be removed
   */
   public void removeProduct(int input, ArrayList<Product> list){
      list.remove(input);
   }
   
   /*
   Name: removeAllProduct
   Purpose: Removes all products from a list
   Description: passes in ArrayList to be cleared
   */
   public void removeAllProducts(ArrayList<Product> list){
      list.clear();
   }
     
   /*
   Name: sortProduct
   Purpose: sorts a list depending on user specifications
   Description: passes in String to determine sorting method and the ArrayList to be sorted
   */
   public void sortProduct(String input, ArrayList<Product> list){
      int listSize = list.size();
      if(input.equals("Name")){
         recursiveSortName(list, listSize);
      }
      else if(input.equals("Retailer")){
         recursiveSortRetailer(list, listSize);
      }
      else if(input.equals("Price")){
         recursiveSortPrice(list, listSize);
      }
      else if(input.equals("Id")){
         recursiveSortId(list, listSize);
      }
      else if(input.equals("SalesPercent")){
         recursiveSortSalePercent(list, listSize);
      }
   }
      
   //Sorting Methods:
   
   /*
   Name: recursiveSortName
   Purpose: Recursively sorts a list by name
   Description: passes in ArrayList to be sorted and count to recursively sort
   */
   public void recursiveSortName(ArrayList<Product> list, int count){
      if(count == 0){
         return;
      }
      for(int i = 0; i < count - 1; i++){
         if(list.get(i).name.compareTo(list.get(i).name) > 0){
            Product holder = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, holder);
         }
      }
   }
   
   /*
   Name: recursiveSortRetailer
   Purpose: Recursively sorts a list by retailer
   Description: passes in ArrayList to be sorted and count to recursively sort
   */
   public void recursiveSortRetailer(ArrayList<Product> list, int count){
      if(count == 0){
         return;
      }
      for(int i = 0; i < count - 1; i++){
         if(list.get(i).retailer.compareTo(list.get(i).retailer) > 0){
            Product holder = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, holder);
         }
      }
   }
   
   /*
   Name: recursiveSortId
   Purpose: Recursively sorts a list by product id
   Description: passes in ArrayList to be sorted and count to recursively sort
   */
   public void recursiveSortId(ArrayList<Product> list, int count){
      if(count == 0){
         return;
      }
      for(int i = 0; i < count - 1; i++){
         if(list.get(i).id.compareTo(list.get(i).id) > 0){
            Product holder = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, holder);
         }
      }
   }
   
   /*
   Name: recursiveSortPrice
   Purpose: Recursively sorts a list by price
   Description: passes in ArrayList to be sorted and count to recursively sort
   */
   public void recursiveSortPrice(ArrayList<Product> list, int count){
      if(count == 0){
         return;
      }
      for(int i = 0; i < count - 1; i++){
         if(list.get(i).price > list.get(i).price){
            Product holder = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, holder);
         }
      }
   }
   
   /*
   Name: recursiveSortSalePercent
   Purpose: Recursively sorts a list by products on sale
   Description: passes in ArrayList to be sorted and count to recursively sort
   */
   public void recursiveSortSalePercent(ArrayList<Product> list, int count){
      if(count == 0){
         return;
      }
      for(int i = 0; i < count - 1; i++){
         if(list.get(i).salePercent < list.get(i).salePercent){
            Product holder = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, holder);
         }
      }
   }   
}
