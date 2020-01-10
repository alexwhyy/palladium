import java.util.ArrayList;
public abstract class SavedProducts{

   public Catalog cat = new Catalog();
   
   public ArrayList<Product> saved = new ArrayList<Product>();
   
   public abstract void addProduct(Product input);
}