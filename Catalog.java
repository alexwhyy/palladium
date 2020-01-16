/*
Class Name: Catalog
Author: Eric Fang
Date: Dec 18, 2019
School: A.Y.Jackson Secondary School
Purpose: Contains all Products the user can browse
*/
import java.util.ArrayList;

public class Catalog extends SavedProducts {
   public ArrayList<Product> catalog = new ArrayList<Product>();
   
   /*
   Name: Catalog
   Purpose: Catalog constructor
   Description: passes in ArrayList to initialize
   */
	public Catalog(ArrayList<Product> catalog) {
		this.catalog = catalog;
	}
}
