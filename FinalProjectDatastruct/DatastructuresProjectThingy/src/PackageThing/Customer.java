package PackageThing;

import java.sql.Array;
/**
 * Customer Class
 * @author conopaskq
 *
 */
public final class Customer {
	/**
	 * Data Fields for Customer
	 */
	private static double totalPrice;
	private static String Name;
	private static ArrayBag<MenuItems> cart = new ArrayBag<MenuItems>();

	private Customer(String name) {
		Name = name;
	}

	/**
	 * return true if able to select item otherwise false
	 * 
	 * @param item
	 * @return
	 */
	public static boolean selectItem(MenuItems item) {
		cart.add(item);
		return true;
	}

	/**
	 * 
	 * 
	 * Displays totalPrice and sends items in cart to kitchen/barista queue
	 * 
	 * @return boolean
	 */
	public static boolean checkOut() {
		if (!cart.isEmpty()) {
			totalPrice = 0;
			MenuItems temp;
			ArrayBag<MenuItems> finalCart = new ArrayBag<MenuItems>();
			while(!cart.isEmpty()) {
				temp = cart.remove();
				totalPrice = totalPrice + temp.getPrice();
				finalCart.add(temp);
			}
			
			System.out.println("Your subtotal is: " + totalPrice);
			System.out.printf("MA tax is: %.2f%n", totalPrice * 0.625);
			System.out.printf("Your total is: %.2f%n", (totalPrice * 0.625 + totalPrice));
			totalPrice = totalPrice * 0.625 + totalPrice;
			Kitchen.orders.enqueue(finalCart);
			return true;
		} else
			return false;
	}

	/**
	 * Removes item from cart
	 * 
	 * @param item
	 * @return
	 */
	public static MenuItems removeItem(MenuItems item) {
		cart.remove(item);
		return item;
	}

	/**
	 * sets name of the bag
	 * 
	 * @param name
	 */
	public static void setName(String name) {
		Name = name;
	}
public static ArrayBag<MenuItems> getCart(){
	return cart;
}
//Display Bag of menuitems
	public static void displayCart() {
		if (cart.isEmpty()) {
			System.out.println("Cart is Empty");
		} else {
			System.out.println("Cart Items");
			MenuItems item;
			ArrayBag<MenuItems> temp = new ArrayBag<>();
			while(!cart.isEmpty()) {
				temp.add(cart.remove());
			}
	        while(!temp.isEmpty()) {
	        	item = temp.remove();
	        	System.out.println(item.displayMenuItems());
	        	cart.add(item);
	        }
		}
        return;
	}
}
