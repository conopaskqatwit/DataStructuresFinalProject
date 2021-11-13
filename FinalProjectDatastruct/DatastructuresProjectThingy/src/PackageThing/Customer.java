package PackageThing;

import java.sql.Array;

public class Customer {
	private double totalPrice;
	private String Name;
	private ArrayBag<MenuItems> Cart;

	public Customer(String name) {
		this.Name = name;
	}

	/**
	 * return true if able to select item otherwise false
	 * 
	 * @param item
	 * @return
	 */
	public boolean selectItem(MenuItems item) {
		Cart.add(item);
		return true;
	}

	/**
	 * 
	 * 
	 * Displays totalPrice and sends items in cart to kitchen/barista queue
	 * 
	 * @return boolean
	 */
	public boolean checkOut(Kitchen k) {
		MenuItems[] cartArray = (MenuItems[]) new Array[Cart.getCurrentSize()];
		cartArray = Cart.toArray();
		int cartsize = cartArray.length;
		double totalprice = 0;
		for (int i = 0; i < cartsize; i++) {
			totalprice = totalprice + cartArray[i].price;
		}
		System.out.println("Your subtotal is: " + totalprice);
		System.out.printf("MA tax is: %.2f%n", totalprice * 0.625);
		System.out.printf("Your total is: %.2f%n", (totalprice * 0.625 + totalprice));
		this.totalPrice = totalprice * 0.625 + totalprice;
		k.orders.enqueue(Cart);
		return true;
	}

	/**
	 * Removes item from cart
	 * 
	 * @param item
	 * @return
	 */
	public MenuItems removeItem(MenuItems item) {
		Cart.remove(item);
		return item;
	}

	/**
	 * sets name of the bag
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}

}
