package PackageThing;


import java.util.Collections;
import java.util.ArrayList;

public class Menu {
	
	public static ArrayList<MenuItems> drinks = new ArrayList<MenuItems>();
	public static ArrayList<MenuItems> food = new ArrayList<MenuItems>();
	
	/**
	 * prints drink bag to console
	 */
	public static void displayDrinks() {
		
		int  numberOfEntries = drinks.size();
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");
		
		for(int position = 0; position < numberOfEntries; position++) {
			System.out.println(drinks.get(position).name + " is entry " + (position + 1));
			
			System.out.println();
		} //end for
	} //end displayDrinks 
	/**
	 * prints food bag to console
	 */
	public static void displayFood() {
		int  numberOfEntries = food.size();
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");
		
		for(int position = 0; position < numberOfEntries; position++) {
			System.out.println(food.get(position).name + " is entry " + (position + 1));
			
			System.out.println();
		} //end for
	} //end displayFood
	/**
	 * sorts arrayList items by price
	 */
	
	
	public static void sortPrice(ArrayList<MenuItems> list) {
		Collections.sort(list, MenuItems.sortByPrice);
	} 
	/**
	 * sorts bag items by name alphabetically
	 */
	public static void sortName(ArrayList<MenuItems> list) {
		Collections.sort(list, MenuItems.sortByName);
	} 

}
