import java.util.ArrayList;
public class ShoppingCart extends SavedProducts{
   public ArrayList<Product> shoppingCart = new ArrayList<Product>();
   
   public void addProduct(int position, Catalog cat){
      shoppingCart.add(cat.catalog.get(position));
   }
   
   public void removeProduct(int input){
      shoppingCart.remove(input);
   }
   
   public void removeAllProducts(){
      shoppingCart.clear();
   }
   
   public static ArrayList<Product> searchProduct(String query, Catalog cat){
   
      ArrayList<Product> returnList = new ArrayList<Product>();   //list that will be returned
      char queryArray[] = new char[query.length()];               //char array made using query
      query = query.toLowerCase();                                //query list initalization
      for(int i = 0; i < query.length(); i++){
         queryArray[i] = query.charAt(i);
      }
      
      for(int i = 0; i < cat.catalog.size(); i++){                //loops through all catalog entries
      
         char catalogArray[] = new char[cat.catalog.get(i).name.length()]; 
         String currentEntry = cat.catalog.get(i).name.toLowerCase();
         for(int j = 0; j < currentEntry.length(); j++){
            catalogArray[j] = currentEntry.charAt(j);
         }
         //char array made with current catalog entry being compared to + intialization^^^
         for(int j = 0; j < cat.catalog.get(i).name.length(); j++){  //loops through characters within current entry
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
               returnList.add(cat.catalog.get(i));
            }
         }
      }
      return returnList;
   }
   
   public void sortProduct(String input){
      if(input.equals("Name")){
         sortName();
      }
      else if(input.equals("Retailer")){
         sortRetailer();
      }
      else if(input.equals("Price")){
         sortPrice();
      }
      else if(input.equals("Id")){
         sortId();
      }
      else if(input.equals("SalesPercent")){
         sortSalePercent();
      }     
      else{
         System.out.println("bad input");
      } 
   }  
   
   //Sorting Methods:
   public void sortName(){
      Product holder;
      for(int i = 0; i < shoppingCart.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(shoppingCart.get(j).name.compareTo(shoppingCart.get(j + 1).name) > 0){
               holder = (shoppingCart.get(j));
               shoppingCart.set(j, shoppingCart.get(j + 1));
               shoppingCart.set(j + 1, holder);
            }
         }
      }
   }
   
   public void sortRetailer(){
      Product holder;
      for(int i = 0; i < shoppingCart.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(shoppingCart.get(j).retailer.compareTo(shoppingCart.get(j + 1).retailer) > 0){
               holder = (shoppingCart.get(j));
               shoppingCart.set(j, shoppingCart.get(j + 1));
               shoppingCart.set(j + 1, holder);
            }
         }
      }
   }   
   
   public void sortId(){
      Product holder;
      for(int i = 0; i < shoppingCart.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(shoppingCart.get(j).id.compareTo(shoppingCart.get(j + 1).id) > 0){
               holder = (shoppingCart.get(j));
               shoppingCart.set(j, shoppingCart.get(j + 1));
               shoppingCart.set(j + 1, holder);
            }
         }
      }
   }
   
   public void sortPrice(){
      Product holder;
      for(int i = 0; i < shoppingCart.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(shoppingCart.get(j).price > shoppingCart.get(j + 1).price){
               holder = (shoppingCart.get(j));
               shoppingCart.set(j, shoppingCart.get(j + 1));
               shoppingCart.set(j + 1, holder);
            }
         }
      }
   }
   
   public void sortSalePercent(){
      Product holder;
      for(int i = 0; i < shoppingCart.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(shoppingCart.get(j).salePercent < shoppingCart.get(j + 1).salePercent){
               holder = (shoppingCart.get(j));
               shoppingCart.set(j, shoppingCart.get(j + 1));
               shoppingCart.set(j + 1, holder);
            }
         }
      }
   }   
}
