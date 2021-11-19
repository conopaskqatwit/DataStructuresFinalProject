package PackageThing;

import java.util.Collections;
import java.util.List;

public class Menu {
	
	private ArrayList<String> drinks;
	private ArrayList<String> food;
	
	/**
	 * prints drink bag to console
	 */
	public void displayDrinks(ListInterface<String> list) {
		
		int  numberOfEntries = list.getLength();
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");
		
		for(int position = 1; position <= numberOfEntries; position++) {
			System.out.println(list.getEntry(position) + " is entry " + position);
			
			System.out.println();
		} //end for
	} //end displayDrinks 
	/**
	 * prints food bag to console
	 */
	public void displayFood(ListInterface<String> list) {
		int  numberOfEntries = list.getLength();
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");
		
		for(int position = 1; position <= numberOfEntries; position++) {
			System.out.println(list.getEntry(position) + " is entry " + position);
			
			System.out.println();
		} //end for
	} //end displayFood
	/**
	 * sorts arrayList items by price
	 */
	
	public <T extends Comparable<T>> void sortPrice(ArrayList<T> list) {
		Collections.sort((List<T>) list);
	}
	/**
	 * sorts bag items by name alphabetically
	 */
	public <T extends Comparable<T>> void sortName(ArrayList<T> list) {
		Collections.sort((List<T>) list);
	}

}
