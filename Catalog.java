/*
Class Name: Catalog
Author: Eric Fang
Date: Dec 18, 2019
School: A.Y.Jackson Secondary School
Purpose: Contains all Products the user can browse
*/
import java.util.ArrayList;

public class Catalog extends SavedProducts {
	private ArrayList<Product> catalog = new ArrayList<Product>();
   
	public Catalog(ArrayList<Product> catalog) {
		this.catalog = catalog;
	}
   
	public Catalog() {
		this.catalog = new ArrayList<Product>();
	}
   
   public ArrayList<Product> getCatalog(){
      return catalog;
   }
}
