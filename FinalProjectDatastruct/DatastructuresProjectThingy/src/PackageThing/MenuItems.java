package PackageThing;

import java.util.Comparator;

public class MenuItems {
	public double price;
	public String name;
	private String description;
	private int type;

	public MenuItems() {

	}

	public MenuItems(double price, String name, String description, int type) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.type = type;
	}

	/**
	 * change price of an item
	 * 
	 * @param newPrice
	 */
	public void changePrice(double newPrice) {
		this.price = newPrice;
	}

	/**
	 * change Description
	 * 
	 * @param newDescription
	 */
	public void changeDescription(String newDescription) {
		this.description = newDescription;
	}

	/**
	 * changes type
	 * 
	 * @param newType
	 */
	public void changeType(int newType) {
		this.type = newType;
	}

	/**
	 * changes name
	 * 
	 * @param newName
	 */
	public void changeName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return this.name;
	}

	public int getType() {
		return this.type;
	}

	public boolean equals() {
		return false;
	}

	public double getPrice() {
		return this.price;
	}

	// to string method
	/**
	 * display all the items in the menu
	 * 
	 * @return
	 */
	public String displayMenuItems() {
		String items = "Price: " + price + "Name of item: " + name + "Description: " + "Type: " + type;
		return items;
	}
}

class PriceComparator implements Comparator<MenuItems> {
	@Override
	/*compares two items of type MenuItems and 
	 * returns a negative integer, zero, or a positive 
	 * integer as the first argument is less than, equal to, or greater than the second.
	 */
	public int compare(MenuItems a, MenuItems b) {
		return a.getPrice() < b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1;
	} //end compare
} //end PriceComparator

class NameComparator implements Comparator<MenuItems> {
	@Override
	/*compares two items of type MenuItems and 
	 * returns a negative integer, zero, or a positive 
	 * integer as the first argument is less than, equal to, or greater than the second.
	 */
	public int compare(MenuItems a, MenuItems b) {
		return a.name.compareToIgnoreCase(b.name);
	} //end compare
} //end NameComparator
