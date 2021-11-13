package PackageThing;

public interface QueueInterface<T> {

	/** 
	 * Adds new entry to back of queue.
	 * @param newEntry  object to be added.
	 */
	public void enqueue(T newEntry);
	
	/**
	 * Removes and returns entry from front of queue
	 * @returns object at front of queue
	 * @throws EmptyQueueException if queue empty before operation
	 */
	public T dequeue() throws EmptyQueueException;
	
	/**
	 * Detects whether queue is empty
	 * @return True if queue is empty, otherwise false
	 */
	public boolean isEmpty();
	
	/**
	 * Retrieves entry from the front of queue
	 * @return object at front of queue
	 * @throws EmptyQueueException is queue is empty
	 */
	public T getFront() throws EmptyQueueException;
	
	/**
	 * Removes all entries from queue
	 */
	public void clear();
	
}
