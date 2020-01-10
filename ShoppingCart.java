import java.util.ArrayList;
public class ShoppingCart extends SavedProducts{
   public ArrayList<Product> shoppingCart = new ArrayList<Product>();
   
   public void addProduct(Product input){
      shoppingCart.add(input);
   }
   
   public void removeProduct(int input){
      shoppingCart.remove(input);
   }
   
   public void removeAllProducts(){
      shoppingCart.clear();
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
   }
   
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