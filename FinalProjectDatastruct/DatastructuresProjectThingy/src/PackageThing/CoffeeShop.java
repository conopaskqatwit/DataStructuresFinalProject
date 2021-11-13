package PackageThing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		login(input);

	}
	//asssuming this is possible and doesnt delete the queue
public static void login(Scanner input) {
	System.out.println("Welcome to Our CoffeeShip NAME");
	System.out.println("Enter 1 for Customer,2 for Kitchen, or 3 for Manager");
	int login = getInt(input);

	if (login == 1) {
		System.out.println("Please enter your name");
		input.nextLine();
		String name = input.nextLine();
		System.out.println("hello"+name);
		Customer.setName(name);
		displayMenu(input);
		getOption(input);
		 
		// customer side
	} else if (login == 2) {
		// Kitchen
	} else if (login == 3) {
		// ask for in
		// mangerside
	} else {
		System.out.println("Not a valid User number, please try again");
		login(input);
		
	}
}
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

	public static int getInt(Scanner input) {
		String allnums="0123456789";
		String choice;
		choice = input.nextLine();
		if (choice.length()>1) {
			System.out.println("not a valid selction please try again");
			getInt(input);
		}
		else if(allnums.indexOf(choice.charAt(0))>=0) {
			return allnums.indexOf(choice.charAt(0));
		}
		else {
			System.out.println("not a valid selction please try again");
			getInt(input);
		}
		return 0;
	}
	public static void getOption(Scanner input) {
		System.out.println("Would you like select an item(1), Checkout(2), or Display another menu(3)?");
		int choice = getInt(input);
		if (choice==1) {
			//selects item needs menuitme and menu finishd first
			//going to grab menu item but number, users number will be decrimednt by 1 to account for index, copy into cart
		}
		else if (choice==2) {
			if (Customer.getCart().isEmpty()) {
				System.out.println("Cannot checkout empty cart, please make another selection");
				getOption(input);
			}
			else {
				Customer.checkOut();
				login(input);
			}
		}
		else if(choice==3) {
			displayMenu(input);
		}
		else {
			System.out.println("Not a valid input, please try again: ");
			getOption(input);
		}
		return;
		
	}
} 
