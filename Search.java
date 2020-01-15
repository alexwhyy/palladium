/*
Class Name: 
Author: Eric Fang
Date: Dec 18, 2019
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
      char queryArray[] = new char[query.length()];               //char array made using query
      query = query.toLowerCase();                                //query list initalization
      for(int i = 0; i < query.length(); i++){
         queryArray[i] = query.charAt(i);
      }
      
      for(int i = 0; i < catalog.size(); i++){                    //loops through all catalog entries
      
         char catalogArray[] = new char[catalog.get(i).name.length()]; 
         String currentEntry = catalog.get(i).name.toLowerCase();
         for(int j = 0; j < currentEntry.length(); j++){
            catalogArray[j] = currentEntry.charAt(j);
         }
         //char array made with current catalog entry + intialization^^^
         for(int j = 0; j < catalog.get(i).name.length(); j++){  //loops through characters within current entry
            int holder = 0;
            try{                                                     
            //compares characters within querey char array with catalog product char array
               if(catalogArray[j] == queryArray[0 + holder]){
                  holder++;
               }
               else{
                  holder = 0;
               }
            }
            //if query array index out of bounds, all characters within the array have been compared and matched
            //meaning it is a match and is added to the return list
            catch(ArrayIndexOutOfBoundsException e){
               returnList.add(catalog.get(i));
            }
         }
      }
      return returnList;
   }
   
   /*
   Name: addProductToCart
   Purpose: adds a Product to ShoppingCart
   Description: passes in ArrayList of searched items and ShoppingCart and index of product to be added
   from the searched list
   */
   public void addProductToCart(int position, ArrayList<Product> searchList, ArrayList<Product> shoppingCart){
      shoppingCart.add(searchList.get(position));
   }
   
   /*
   Name: addProductToCart
   Purpose: adds a Product to WishList
   Description: passes in ArrayList of searched items and WishList and index of product to be added
   from the searched list
   */
   public void addProductToWishList(int position, ArrayList<Product> searchList, ArrayList<Product> wishList){
      wishList.add(searchList.get(position));
   }
}
