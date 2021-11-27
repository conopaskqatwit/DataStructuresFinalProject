package PackageThing;

public class Kitchen {
	public static CircularLinkedQueue<ArrayBag<MenuItems>> orders = new CircularLinkedQueue<ArrayBag<MenuItems>>();

	/**
	 * marks the food part of order as complete
	 * 
	 * @param order
	 * @return
	 */
	public static void markNextOrderDone() {
		try {
			ArrayBag<MenuItems> filledOrder = orders.dequeue();
		} catch (EmptyQueueException e) {
			System.out.println("There are no orders to be filled.  Logging out... ");
			return;
		}
	}
	
	public static void displayNextOrder() {
		try {
			ArrayBag<MenuItems> nextOrder = orders.getFront();
			if (nextOrder.isEmpty()) {
				orders.dequeue();
				displayNextOrder();
			} else {
				System.out.println("Next Order: ");
				MenuItems item;
				ArrayBag<MenuItems> temp = new ArrayBag<>();
				while(!nextOrder.isEmpty()) {
					temp.add(nextOrder.remove());
				}
		        while(!temp.isEmpty()) {
		        	item = temp.remove();
		        	System.out.println(item.getName());
		        	nextOrder.add(item);
		        }
			}
		} catch (EmptyQueueException e) {
			System.out.println("There are no orders to be filled.  Logging out... ");
			return;
		}
        return;
	}
}
