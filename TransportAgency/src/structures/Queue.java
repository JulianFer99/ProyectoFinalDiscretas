package structures;

public class Queue<T> {

	private NodeQueue<T> head;
	
	public Queue() {
		head = null;
	}

	public void push(T data) {
		if (head == null) {
			head = new NodeQueue<T>(data);
		} else {
			NodeQueue<T> newNode = new NodeQueue<T>(data);
			NodeQueue<T> auxiliar = head;
			while (auxiliar.getNext() != null) {
				auxiliar = auxiliar.getNext();
			}
			auxiliar.setNext(newNode);
		}
	}

	public boolean exist(T data) {
		NodeQueue<T> auxiliar = head;
		boolean result = false;
		boolean isTrue = true;
		while (auxiliar != null && isTrue) {
			if (auxiliar.getData() == data) {
				result = true;
				isTrue = false;
			}
			auxiliar = auxiliar.getNext();
		}
		return result;
	}


	public T poll() {
		NodeQueue<T> result = head;
		NodeQueue<T> temporal = head.getNext();
		this.head=temporal;
		return result.getData();
	}
	
	public T peek() {
		return head.getData();
	}

	public boolean isEmpty() {
		boolean result;
		if (head == null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
