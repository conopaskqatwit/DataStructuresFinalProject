package PackageThing;

import java.util.Collections;
import java.util.ArrayList;

public class Menu {

	//Creates an ArrayList of the type MenuItems
	public static ArrayList<MenuItems> drinks = new ArrayList<MenuItems>();
	public static ArrayList<MenuItems> food = new ArrayList<MenuItems>();


	//Prints the ArrayList of drinks to the console
	public static void displayDrinks() {

		int numberOfEntries = drinks.size(); //assigns the amount of drinks in the ArrayList to numberOfEntries
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");

		//Prints the name of the drink and its position in the list of entries to the console 
		for (int position = 0; position < numberOfEntries; position++) {
			System.out.println(drinks.get(position).name + " is entry " + (position + 1));

			System.out.println();
		} // end for
	} // end displayDrinks

	//Prints the ArrayList of food to the console
	public static void displayFood() {
		int numberOfEntries = food.size(); //assigns the amount of food in the ArrayList to numberOfEntries
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");

		//Prints the name of the food item and its position in the list of entries to the console
		for (int position = 0; position < numberOfEntries; position++) {
			System.out.println(food.get(position).name + " is entry " + (position + 1));

			System.out.println();
		} // end for
	} // end displayFood

	

	//Sorts the ArrayList of MenuItems in ascending numerical order
	public static void sortPrice(ArrayList<MenuItems> list) {
		//invokes the sort method of the Java Class Collections, taking an ArrayList and a user defined comparator as parameters
		Collections.sort(list, new PriceComparator()); //PriceComparator is located in the MenuItems class
	} //end sortPrice

	//Sorts the ArrayList of MenuItems in alphabetical order
	public static void sortName(ArrayList<MenuItems> list) {
		//invokes the sort method of the Java Class Collections, taking an ArrayList and a user defined comparator as parameters
		Collections.sort(list, new NameComparator()); //NameComparator is located in the MenuItems class
	} //end sortName

} //end Menu
