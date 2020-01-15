/*
Class Name: WishList
Author: Eric Fang
Date: Dec 18, 2019
School: A.Y.Jackson Secondary School
Purpose: Contains wishlist of products user is interested in
but cannot buy at the moment
*/
import java.util.ArrayList;
public class WishList extends SavedProducts{
   public ArrayList<Product> wishList = new ArrayList<Product>();      
   
   /*
   Name: addToShoppingCart
   Purpose: moves a product from WishList to ShoppingCart 
   Description: passes in ArrayList(from ShoppingCart) and the position of product
   in WishList
   */
   public void addToShoppingCart(int position, ArrayList<Product> shoppingCart){
      shoppingCart.add(wishList.get(position));
      wishList.remove(position);
   }  
}
