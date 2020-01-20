/*
Class Name: 
Author: Eric Fang
Date: Jan 6, 2019
School: A.Y.Jackson Secondary School
Purpose: Searches catalog for matches and adds them to WishList/ShoppingCart
*/
import java.util.ArrayList;
public class Search{
   
   /*
   Name: searchProduct
   Purpose: searches an ArrayList for all matches and returns an ArrayList containing them 
   Description: passes in String to search with and ArrayList to search through
   */
   public static ArrayList<Product> searchProduct(String query, ArrayList<Product> catalog){
      ArrayList<Product> returnList = new ArrayList<Product>();   //list that will be returned
      query = query.toLowerCase();                                //query list initalization
      for(int i = 0; i < catalog.size(); i++){                    //loops through all catalog entries      
         
         String currentEntry = catalog.get(i).name.toLowerCase();         
         int holder = 0;
         for(int j = 0; j < catalog.get(i).name.length(); j++){  //loops through characters within current entry
            //compares characters within querey char array with catalog product char array
            if(currentEntry.charAt(j) == query.charAt(holder)){
               holder++;
            }
            else{
               holder = 0;
            }
            if(holder == query.length()){
               returnList.add(catalog.get(i));
               holder = 0;
            }
            
            //if query array index out of bounds, all characters within the array have been compared and matched
            //meaning it is a match and is added to the return list
            
         }
      }
      return returnList;
   }
   public void addToShoppingCart(ArrayList<Product> searchList, int index, ShoppingCart shoppingCart){
      shoppingCart.addProduct(searchList.get(index));
   }
   public void addToWishList(ArrayList<Product> searchList, int index, WishList wishList){
      wishList.addProduct(searchList.get(index));
   }
}
