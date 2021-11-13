package PackageThing;

import java.util.Scanner;

public class Manager {
	private int DEFAULT_PIN = 0000;
	public int pin;

	/**
	 * changes manager Pin
	 */
	public void changePin(Scanner input) {
		System.out.println("Enter Pin:");
		int oldPin = input.nextInt();
		if(oldPin == this.pin) {
			System.out.println("Enter new Pin:");
			this.pin = input.nextInt();
		} else {
			System.out.println("Pin is incorrect");
			return;
		}
	}
	/**
	 * adds item to menu
	 * @param newitem
	 */
	 public void addItem(Scanner input, Menu m) {
		 System.out.println("Name of Item: ");
		 String name = input.nextLine();
		 
		 System.out.println("Item Description: ");
		 String description = input.nextLine();
		 
		 System.out.println("Price: ");
		 double price = input.nextInt();
		 
		 System.out.println("Type (1 if drink, 2 if food):");
		 int type = input.nextInt();
		 
		 if(type == 1) {
			 m.drinks.add(new MenuItems(price, name, description, type));
		 } else if(type == 2) {
			 m.food.add(new MenuItems(price, name, description, type));
		 }
		 
		 return;
		 
	 }
	 
	
	 /**
	 * removes item from menu
	 * @param olditem
	 */
	public void removeItem(MenuItems oldItem, Menu m) {
		
		if(oldItem.getType() == 1) {
			m.drinks.remove(m.drinks.getIndex(oldItem));
		} else if(oldItem.getType() == 2) {
			m.food.remove(m.food.getIndex(oldItem));
		}
		
		return;
	
	}
}
