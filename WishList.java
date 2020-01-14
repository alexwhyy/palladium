import java.util.ArrayList;
public class WishList extends SavedProducts{
   public ArrayList<Product> wishList = new ArrayList<Product>();      
   
   public void addToShoppingCart(int position, ArrayList<Product> shoppingCart){
      shoppingCart.add(wishList.get(position));
      wishList.remove(position);
   }  
}