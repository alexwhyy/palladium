import java.util.ArrayList;
public abstract class SavedProducts{
   public void removeProduct(int input, ArrayList<Product> list){
      list.remove(input);
   }
   
   public void removeAllProducts(ArrayList<Product> list){
      list.clear();
   }
     
   public void sortProduct(String input, ArrayList<Product> list){
      if(input.equals("Name")){
         sortName(list);
      }
      else if(input.equals("Retailer")){
         sortRetailer(list);
      }
      else if(input.equals("Price")){
         sortPrice(list);
      }
      else if(input.equals("Id")){
         sortId(list);
      }
      else if(input.equals("SalesPercent")){
         sortSalePercent(list);
      }
   }
      
   //Sorting Methods:
   public void sortName(ArrayList<Product> list){
      Product holder;
      for(int i = 0; i < list.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(list.get(j).name.compareTo(list.get(j + 1).name) > 0){
               holder = (list.get(j));
               list.set(j, list.get(j + 1));
               list.set(j + 1, holder);
            }
         }
      }
   }
   
   public void sortRetailer(ArrayList<Product> list){
      Product holder;
      for(int i = 0; i < list.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(list.get(j).retailer.compareTo(list.get(j + 1).retailer) > 0){
               holder = (list.get(j));
               list.set(j, list.get(j + 1));
               list.set(j + 1, holder);
            }
         }
      }
   }   
   
   public void sortId(ArrayList<Product> list){
      Product holder;
      for(int i = 0; i < list.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(list.get(j).id.compareTo(list.get(j + 1).id) > 0){
               holder = (list.get(j));
               list.set(j, list.get(j + 1));
               list.set(j + 1, holder);
            }
         }
      }
   }
   
   public void sortPrice(ArrayList<Product> list){
      Product holder;
      for(int i = 0; i < list.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(list.get(j).price > list.get(j + 1).price){
               holder = (list.get(j));
               list.set(j, list.get(j + 1));
               list.set(j + 1, holder);
            }
         }
      }
   }
   
   public void sortSalePercent(ArrayList<Product> list){
      Product holder;
      for(int i = 0; i < list.size() - 1; i++){
         for(int j = 0; j < i; j++){
            if(list.get(j).salePercent < list.get(j + 1).salePercent){
               holder = (list.get(j));
               list.set(j, list.get(j + 1));
               list.set(j + 1, holder);
            }
         }
      }
   } 
   
}