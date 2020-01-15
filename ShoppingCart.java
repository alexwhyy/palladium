/*
Class Name: ShoppingCart
Author: Eric Fang
Date: Dec 18, 2019
School: A.Y.Jackson Secondary School
Purpose: Holds item that user has added and itends to purchase
*/
import java.util.ArrayList;
public class ShoppingCart extends SavedProducts{
   public ArrayList<Product> shoppingCart = new ArrayList<Product>();
   
   /*
   Name: addToWishList
   Purpose: moves a product from ShoppingCart to WishList
   Description: passes in ArrayList(from WishList) and the position of product
   in ShoppingCart
   */
   public void addToWishList(int position, ArrayList<Product> wishList){
      wishList.add(shoppingCart.get(position));
      shoppingCart.remove(position);
   }
}
