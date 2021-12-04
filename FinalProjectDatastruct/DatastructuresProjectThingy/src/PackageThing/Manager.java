package PackageThing;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Manager {
	private static int DEFAULT_PIN = 0000;
	private static int pin;

	public static int getPin() {
		return pin;
	}
	
	/**
	 * changes manager Pin
	 * @param Scanner to read new pin
	 * @return true if successful, false otherwise
	 */
	public static boolean changePin(Scanner input) {
		System.out.println("Enter Pin:");
		int oldPin = CoffeeShop.getInt(input);
		if(oldPin == pin) {
			System.out.println("Enter new Pin:");
			pin = CoffeeShop.getInt(input);
			return true;
		} else {
			System.out.println("Pin is incorrect");
			return false;
		}
	}
	/**
	 * adds item to menu
	 * @param newitem
	 */
	 public static void addItem(Scanner input) {
		 input.nextLine();
		 System.out.println("Name of Item: ");
		 String name = input.nextLine();
		 
		 System.out.println("Item Description: ");
		 String description = input.nextLine();
		 
		 System.out.println("Price: ");
		 double price = input.nextDouble();
		 
		 System.out.println("Type (1 if drink, 2 if food):");
		 int type;
		 try {
			 type = input.nextInt();
		 } catch (InputMismatchException ex) {
			 System.out.println("Please input 1 or 2");
			 type = CoffeeShop.getInt(input);
		 }
		 
		 while(type != 1 && type != 2) {
			 System.out.println("Please input 1 or 2");
			 type = CoffeeShop.getInt(input);
		 }
		 if(type == 1) {
			 Menu.drinks.add(new MenuItems(price, name, description, type));
			 System.out.println("Current Drink Menu: ");
			 Menu.displayDrinks();
		 } else if(type == 2) {
			 Menu.food.add(new MenuItems(price, name, description, type));
			 System.out.println("Current Food Menu: ");
			 Menu.displayFood();
		 }
		 
		 return;
		 
	 }
	 
	
	 /**
	 * removes item from menu
	 * @param item to remove from menu
	 */
	public static void removeItem(Scanner input) {
		input.nextLine();
		System.out.println("Would you like to remove a drink(1) or food(2) item?");
		int type = CoffeeShop.getInt(input);
		if(type == 1) {
			if(Menu.drinks.isEmpty()) {
				System.out.println("There are no drinks currently in the Menu");
				return;
			}
			Menu.displayDrinks();
			System.out.println("Which item number would you like to remove?");
			type = CoffeeShop.getInt(input);
			while(type <= 0 || type > Menu.drinks.length()) {
				System.out.println("There is no item with that number");
				type = CoffeeShop.getInt(input);
			}
			Menu.drinks.remove(Menu.drinks.remove(type - 1));
			Menu.displayDrinks();
		} else if(type == 2) {
			if(Menu.food.isEmpty()) {
				System.out.println("There are no food items currently in the Menu");
				return;
			}
			Menu.displayFood();
			System.out.println("Which item number would you like to remove?");
			type = CoffeeShop.getInt(input);
			while(type <= 0 || type > Menu.drinks.length()) {
				System.out.println("There is no item with that number");
				type = CoffeeShop.getInt(input);
			}
			Menu.drinks.remove(Menu.food.remove(type));
			Menu.displayFood();
		} else {
			System.out.println("Please input 1 or 2");
			removeItem(input);
		}
		
		
		return;
	
	}
}
