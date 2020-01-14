import java.util.ArrayList;
public class ShoppingCart extends SavedProducts{
   public ArrayList<Product> shoppingCart = new ArrayList<Product>();
   
   public void addToWishList(int position, ArrayList<Product> wishList){
      wishList.add(shoppingCart.get(position));
      shoppingCart.remove(position);
   }
}
