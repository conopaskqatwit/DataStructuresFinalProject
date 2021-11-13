package PackageThing;

public final class CircularLinkedQueue<T> implements QueueInterface<T>{

	private Node firstNode;
	private Node freeNode;
	
	private class Node {
		
		private T  data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			this.data = dataPortion;
			this.next = nextNode;
		}
		
		private T getData() {
			return this.data;
		}
		
		private void setData(T newData) {
			this.data = newData;
		}
		
		private Node getNextNode() {
			return this.next;
		}
		
		private void setNextNode(Node nextNode) {
			this.next = nextNode;
		}
		
	}
	
	public CircularLinkedQueue() {
		this.freeNode = new Node(null, null);
		this.freeNode.setNextNode(this.freeNode);
		this.firstNode = this.freeNode;
	}
	
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		freeNode.setData(newEntry);
		if (isNewNodeNeeded()) {
			Node newNode = new Node(null, this.freeNode.getNextNode());
			this.freeNode.setNextNode(newNode);
		}
		this.freeNode = this.freeNode.getNextNode();
	}
	
	private boolean isNewNodeNeeded() {
		return this.firstNode == this.freeNode.getNextNode();
	}

	public T dequeue() throws EmptyQueueException{
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			T front = this.getFront();
			this.firstNode.setData(null);
			this.firstNode = this.firstNode.getNextNode();
			return front;
		}
		
	}

	public boolean isEmpty() {
		return this.firstNode == this.freeNode;
	}

	public T getFront() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return this.firstNode.getData();
		}
	}

	public void clear() {
		while(!this.isEmpty()) {
			try {
				this.dequeue();
			} catch (EmptyQueueException e) {
				return;
			}
		}
	}

	
	
}
