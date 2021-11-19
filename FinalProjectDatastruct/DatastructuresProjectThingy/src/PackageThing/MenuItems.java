package PackageThing;

public class MenuItems {
	private double price;
	private String name;
	private String description;
	private int type;
	public MenuItems() {
		
	}
	public MenuItems(double price, String name, String description, int type) {
		
	}
/**
 * change price of an item
 * @param newPrice
 */
	public void changePrice(double newPrice) {
	this.price = newPrice;
	}
/**
 * change Description
 * @param newDescription
 */
	public void changeDescription(String newDescription) {
	this.description = newDescription;
	}
/**
 * changes type
 * @param newType
 */
	public void changeType(int newType) {
	this.type = newType;
	}
/**
 * changes name
 * @param newName
 */
	public void changeName(String newName) {
		this.name = newName;
	}
	
	public int getType() {
		return this.type;
	}
	
	public boolean equals() {
		return false;
	}
	public double getPrice(){
		return this.price;
	}
	// to string method
	/**
	 * display all the items in the menu
	 * @return
	 */
	public String displayMenuItems() {
		String items = "Price: " + price +"Name of item: " + name +"Description: " + "Type: " + type;
		return items;
	}
	
}
