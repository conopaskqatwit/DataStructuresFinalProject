package PackageThing;

/**
 * 2 A class that implements a queue of objects by using 3 a two-part circular
 * chain of linked nodes. 4
 */
public final class CircularLinkedQueue<T> implements QueueInterface<T> {
	private Node queueNode; // References first node in queue
	private Node freeNode; // References node after back of queue

	public CircularLinkedQueue() {
		freeNode = new Node(null, null);
		freeNode.setNextNode(freeNode);
		queueNode = freeNode;
	} // end default constructor

	private class Node {
		private T data; // Queue entry
		private Node next; // Link to next node

	} // end Node
} // end TwoPartCircularLinkedQueue