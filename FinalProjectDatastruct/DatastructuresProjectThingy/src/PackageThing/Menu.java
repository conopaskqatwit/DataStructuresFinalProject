package PackageThing;

public class Menu {

	//Creates an ArrayList of the type MenuItems
	public static ArrayList<MenuItems> drinks = new ArrayList<MenuItems>();
	public static ArrayList<MenuItems> food = new ArrayList<MenuItems>();


	//Prints the ArrayList of drinks to the console
	public static void displayDrinks() {

		int numberOfEntries = drinks.getLength(); //assigns the amount of drinks in the ArrayList to numberOfEntries
		System.out.println("Drink Items: ");
		System.out.println();

		//Prints the name of the drink and its position in the list of entries to the console 
		for (int position = 1; position <= numberOfEntries; position++) {
			System.out.println(" (" + (position) + ") " + drinks.getEntry(position).displayMenuItems());

			//System.out.println();
		} // end for
	} // end displayDrinks

	//Prints the ArrayList of food to the console
	public static void displayFood() {
		int numberOfEntries = food.getLength(); //assigns the amount of food in the ArrayList to numberOfEntries
		System.out.println("Food Items: ");

		System.out.println();
		//Prints the name of the food item and its position in the list of entries to the console
		for (int position = 1; position <= numberOfEntries; position++) {
			System.out.println(" (" + (position) + ") " + food.getEntry(position).displayMenuItems());

			//System.out.println();
		} // end for
	} // end displayFood
	
	// Sorts the ArrayList of MenuItems in ascending numerical order
	public static <T extends Comparable<? super T>> void sortPrice(ArrayList<MenuItems> list) {
		for(int index = 1; index < list.getLength(); index++) {
			int indexOfNextSmallest = getIndexOfSmallestPrice(list, index, list.getLength());
			swap(list, index, indexOfNextSmallest);
		} //end for
	} //end sortPrice
	
	//Finds the index of the smallest value in a portion of an ArrayList and returns the index of the smallest value
	public static <T extends Comparable<? super T>> int getIndexOfSmallestPrice(ArrayList<MenuItems> list, int first, int last){
		MenuItems min = list.getEntry(first);
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if((list.getEntry(index).comparePrice(min)) < 0) {
				min = list.getEntry(index);
				indexOfMin = index;
			} //end if
		} //end for 
		return indexOfMin;
	} //end getIndexOfSmallestPrice

	// Sorts the ArrayList of MenuItems in alphabetical order
	public static <T extends Comparable<? super T>> void sortName(ArrayList<MenuItems> list) {
		for(int index = 1; index < list.getLength(); index++) {
			int indexOfNextSmallest = getIndexOfSmallestName(list, index, list.getLength());
			swap(list, index, indexOfNextSmallest);
		} // end for	
	} // end sortName
	
	//Finds the index of the smallest value in a portion of an ArrayList and returns the index of the smallest value
	public static <T extends Comparable<? super T>> int getIndexOfSmallestName(ArrayList<MenuItems> list, int first, int last){
		MenuItems min = list.getEntry(first);
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if((list.getEntry(index).compareName(min)) < 0) {
				min = list.getEntry(index);
				indexOfMin = index;
			} //end if 
		} //end for
		return indexOfMin;
	} //end getIndexOfSmallestName 

	//swaps the ArrayList entries 
	public static void swap(ArrayList<MenuItems> list, int i, int j) {
		MenuItems tmp = list.getEntry(i);
		list.set(i, list.getEntry(j));
		list.set(j, tmp);
	} //end swap

	

} //end Menu
