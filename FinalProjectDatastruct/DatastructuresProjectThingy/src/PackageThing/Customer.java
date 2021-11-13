package PackageThing;

public class Customer {
	private double totalPrice;
	private String Name;
	private ArrayBag<MenuItems> Cart;
	public Customer() {
		
	}
	public Customer(String name) {
		
	}
/**return true if able to select item otherwise false
 * 
 * @param item
 * @return
 */
	public boolean selectItem(MenuItems item) {

		return false;
	}
	/**
	 * 
	 * 
	 * Displays totalPrice and sends items in cart to kitchen/barista queue
	 * @return boolean
	*/
	public boolean checkOut() {
	
	return false;
	}
	/**Removes item from cart
	 * @param item
	 * @return
	 */
	public MenuItems removeItem(MenuItems item) {
	
	return item;
	}
	/**
	 * sets name of the bag
	 * @param name
	 */
	public void setName(String name){
	}
	
	
	

}
