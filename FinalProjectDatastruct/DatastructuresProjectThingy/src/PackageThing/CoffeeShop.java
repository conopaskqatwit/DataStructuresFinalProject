package PackageThing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Our CoffeeShip NAME");
		login(input);
		
	}

	// asssuming this is possible and doesnt delete the queue
	public static void login(Scanner input) {
		
		System.out.println("Enter 1 for Customer,2 for Kitchen, 3 for Manager, or 4 to quit");
		int login = getInt(input);

		if (login == 1) {
			System.out.println("Please enter your name");
			//input.nextLine();
			String name = input.nextLine();
			System.out.println("hello " + name);
			Customer.setName(name);
			displayMenu(input);
			
		} else if (login == 2) {
			
			kitchen(input);
			
		} else if (login == 3) {
			System.out.println("Please enter the pin: ");
			int enteredPin = getInt(input);
			if(Manager.getPin() != enteredPin) {
				System.out.println("Pin is incorrect");
				login(input);
			} else {
				managerOption(input);
				
			}
		} else if (login == 4) {
			System.out.println("Exiting System... ");
			System.exit(0);
		}
		else {
			System.out.println("Not a valid User number, please try again");
			login(input);

		}
	}
	
	
	public static void kitchen(Scanner input) {
		ArrayBag<MenuItems> nextOrder = new ArrayBag<>();
		if(Kitchen.orders.isEmpty()) {
			System.out.println("There are no orders to be filled.");
			System.out.println("Logging out...");
			login(input);
		} else {
			Kitchen.displayNextOrder();
			System.out.println("Enter 1 when order is completed or 2 to logout:");
			int kitchenChoice = getInt(input);
			if (kitchenChoice == 2) {
				System.out.println("Logging out... ");
				login(input);
			} else if (kitchenChoice == 1) {
				Kitchen.markNextOrderDone();
				kitchen(input);
			}
		}
		return;
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
			input.nextLine();
			System.out.println("Would you like to add an item(1), remove and item(2), change the pin(3), or logout(4)");
			int choice = getInt(input);
			if (choice == 1) {
				Manager.addItem(input);
				managerOption(input);
			} else if (choice == 2) {
				Manager.removeItem(input);
				managerOption(input);
			} else if (choice == 3) {
				boolean pinChanged = Manager.changePin(input);
				if(pinChanged == false) {
					login(input);
				} else {
					System.out.println("Pin successfully changed");
					managerOption(input);
				}
			} else if (choice == 4) {
				System.out.println("Logging out...");
				login(input);
			} else {
				System.out.println("Not a valid input, please try again: ");
				managerOption(input);
			}
			return;

		}
		
		//Customer methods

		/**
		 * displays the menu for the customer
		 * @param Scanner: input
		 */
		public static void displayMenu(Scanner input) {

			System.out.println("Would you like to look at Drinks(1) or Food(2), cancel order(3), or view cart(4)?");
			int menuchoice = getInt(input);
			if (menuchoice == 1) {
				if (Menu.drinks.isEmpty()) {
					System.out.println("The drink menu is currently empty, please make another selection");
					displayMenu(input);
				} else {
					Menu.displayDrinks();
					customerOption(input, menuchoice);
				}
			} else if (menuchoice == 2) {
				if (Menu.food.isEmpty()) {
					System.out.println("The food menu is currently empty, please make another selection");
					displayMenu(input);
				} else {
					Menu.displayFood();
					customerOption(input, menuchoice);
				}
			} else if (menuchoice == 3) {
				System.out.println("Loging out...");
				login(input);
			} else if (menuchoice == 4) {
				Customer.displayCart();
				displayMenu(input);
			}
			else {
				System.out.println("not a valid selction please try again");
				displayMenu(input);

			}
			return;
		}

		public static void customerOption(Scanner input, int menuType) {
			System.out.println("Would you like select an item(1), Checkout(2), Display another menu(3), view cart(4), or cancel order(5)?");
			int choice = getInt(input);
			if (choice == 1) {
				System.out.println("Which item would you like to select?");
				int item = getInt(input);
				//Assertion: menuType equals 1 or 2
				if (menuType == 1) {
					while(item <= 0 || item > Menu.drinks.size()) {
						System.out.println("There is no item with that number.  Which item would you like to select?");
						item = CoffeeShop.getInt(input);
					}
					Customer.selectItem(Menu.drinks.get(item - 1));
					Customer.displayCart();
					customerOption(input, menuType);
				} else {
					while(item <= 0 || item > Menu.food.size()) {
						System.out.println("There is no item with that number.  Which item would you like to select?");
						item = CoffeeShop.getInt(input);
					}
					Customer.selectItem(Menu.food.get(item - 1));
					Customer.displayCart();
					customerOption(input, menuType);
				}
				
			} else if (choice == 2) {
				boolean checkout = Customer.checkOut();
				if (!checkout) {
					System.out.println("Cannot checkout empty cart, please make another selection");
					customerOption(input, menuType);
				} else {
					System.out.println("Thank you.  Your order has been sent to the kitchen, it will be out shortly");
					login(input);
				}
			} else if (choice == 3) {
				displayMenu(input);
			} else if (choice == 4) {
				Customer.displayCart();
				customerOption(input, menuType);
			} else if (choice == 5) {
				System.out.println("Canceling order...");
				Customer.getCart().clear();
				System.out.println("Logging out...");
				login(input);
			} else {
				System.out.println("Not a valid input, please try again: ");
				customerOption(input, menuType);
			}
			return;
		}
		
		
	
}
