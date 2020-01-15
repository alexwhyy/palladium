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
