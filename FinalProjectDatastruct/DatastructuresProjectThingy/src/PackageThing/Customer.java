package PackageThing;

import java.sql.Array;

public final class Customer {
	private static double totalPrice;
	private static String Name;
	private static ArrayBag<MenuItems> cart;

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
		MenuItems[] cartArray = (MenuItems[]) new Array[cart.getCurrentSize()];
		cartArray = cart.toArray();
		int cartsize = cartArray.length;
		double totalprice = 0;
		for (int i = 0; i < cartsize; i++) {
			totalprice = totalprice + cartArray[i].getPrice();
		}
		System.out.println("Your subtotal is: " + totalprice);
		System.out.printf("MA tax is: %.2f%n", totalprice * 0.625);
		System.out.printf("Your total is: %.2f%n", (totalprice * 0.625 + totalprice));
		totalPrice = totalprice * 0.625 + totalprice;
		//not done need to copy to new bag to send to queue
		Kitchen.orders.enqueue(cart);
		return true;
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
}
