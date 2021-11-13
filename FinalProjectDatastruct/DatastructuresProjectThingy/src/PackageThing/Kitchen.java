package PackageThing;

public class Kitchen {
	public CircularLinkedQueue<ArrayBag<MenuItems>> orders;
	
/**
 * marks the food part of order as complete
 * @param order
 * @return
 */
	public boolean markDone(ArrayBag order) {
	if (order.isEmpty())
		return true;
		
		
	else {
		return false;
	}
   }
}
