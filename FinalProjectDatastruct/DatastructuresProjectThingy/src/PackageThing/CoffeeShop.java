package PackageThing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		login(input);
		
	}

	// asssuming this is possible and doesnt delete the queue
	public static void login(Scanner input) {
		System.out.println("Welcome to Our CoffeeShip NAME");
		System.out.println("Enter 1 for Customer,2 for Kitchen, or 3 for Manager");
		int login = getInt(input);

		if (login == 1) {
			System.out.println("Please enter your name");
			//input.nextLine();
			String name = input.nextLine();
			System.out.println("hello " + name);
			Customer.setName(name);
			displayMenu(input);
			customerOption(input);

			// customer side
		} else if (login == 2) {
			// Kitchen
		} else if (login == 3) {
			System.out.println("Please enter the pin: ");
			int enteredPin = getInt(input);
			if(Manager.pin != enteredPin) {
				System.out.println("Pin is incorrect");
				login(input);
			} else {
				
			}
			// ask for pin
			// mangerside
		} else {
			System.out.println("Not a valid User number, please try again");
			login(input);

		}
	}
	
	/**
	 * get integer from user
	 * @param Scanner: input
	 * @return integer
	 */
	public static int getInt(Scanner input) {
		String allnums = "0123456789";
		String choice;
		choice = input.nextLine();
		int number = 0;
		for(int i = 0; i < choice.length(); i++) {
			if(!(allnums.indexOf(choice.charAt(i)) >= 0)) {
				System.out.println("not a valid selection, please try again");
				number = 0;
				return getInt(input);
			} else {
				number = number + allnums.indexOf(choice.charAt(i)) * (int) Math.pow(10, choice.length() - (i + 1));
			}
		}
		return number;
	}
	
//Manager methods
	
	public static void managerOption(Scanner input) {
		System.out.println("Would you like to add an item(1), remove and item(2), or change the pin(3)");
		int choice = getInt(input);
		if (choice == 1) {
			Manager.addItem(input);
		} else if (choice == 2) {
			if (Customer.getCart().isEmpty()) {
				System.out.println("Cannot checkout empty cart, please make another selection");
				customerOption(input);
			} else {
				Customer.checkOut();
				login(input);
			}
		} else if (choice == 3) {
			displayMenu(input);
		} else {
			System.out.println("Not a valid input, please try again: ");
			customerOption(input);
		}
		return;

	}
	
//Customer methods

	/**
	 * displays the menu for the customer
	 * @param Scanner: input
	 */
	public static void displayMenu(Scanner input) {

		System.out.println("Would you like to look at Drinks(1) or Food(2)?");
		int menuchoice = getInt(input);
		if (menuchoice == 1) {
			Menu.displayDrinks();
		} else if (menuchoice == 2) {
			Menu.displayFood();
		} else {
			System.out.println("not a valid selction please try again");
			displayMenu(input);

		}
		return;
	}

	public static void customerOption(Scanner input) {
		System.out.println("Would you like select an item(1), Checkout(2), or Display another menu(3)?");
		int choice = getInt(input);
		if (choice == 1) {
			// selects item needs menuitme and menu finishd first
			// going to grab menu item but number, users number will be decrimednt by 1 to
			// account for index, copy into cart
		} else if (choice == 2) {
			if (Customer.getCart().isEmpty()) {
				System.out.println("Cannot checkout empty cart, please make another selection");
				customerOption(input);
			} else {
				Customer.checkOut();
				login(input);
			}
		} else if (choice == 3) {
			displayMenu(input);
		} else {
			System.out.println("Not a valid input, please try again: ");
			customerOption(input);
		}
		return;

	}
}
