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
		
		String items = name + "; Price: " + price +  "; Description: " + description;
		return items;
	}
	
	//Compares the price of MenuItems a and MenuItems b
	public double comparePrice(MenuItems other) {
		return this.getPrice() - other.getPrice();
	} //end comparePrice
	
	//Compares the name of MenuItems a and MenuItems b
	public int compareName(MenuItems other) {
		return this.getName().compareTo(other.getName()); 
	} //end compareName
	
}


