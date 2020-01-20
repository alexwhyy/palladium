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
   public static ArrayList<Product> searchProductK(String query,  ArrayList<Product> catalog){
      ArrayList<Product> returnList = new ArrayList<Product>();
      int queryLength = query.length();
      int productLength;
      query = query.toLowerCase();
      String productName;
      for(int i = 0 ; i < catalog.size(); i++ ){
         productName = catalog.get(i).name.toLowerCase();
         productLength = productName.length();
         for(int j = 0 ; j <= productLength-queryLength; j ++){
            int k;
            for(k = 0 ; k < queryLength ; k ++){
               if (productName.charAt(j + k) != query.charAt(k))
                  break;
            }
            if (k == queryLength){
               returnList.add(catalog.get(i));
            }
         }
      }
      return returnList;
   }
   public static ArrayList<Product> searchProduct(String query, ArrayList<Product> catalog){
      ArrayList<Product> returnList = new ArrayList<Product>();   //list that will be returned
      query = query.toLowerCase();                                //query list initalization
      
      for(int i = 0; i < catalog.size(); i++){                    //loops through all catalog entries      
         
         String currentEntry = catalog.get(i).name.toLowerCase();
         for(int j = 0; j < catalog.get(i).name.length(); j++){  //loops through characters within current entry
            int holder = 0;
            try{                                                     
            //compares characters within querey char array with catalog product char array
               if(currentEntry.charAt(j) == query.charAt(holder)){
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
}
