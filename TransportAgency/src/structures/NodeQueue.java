package structures;

public class NodeQueue<T> {
	
	private T data;
	private NodeQueue<T> next;

	public NodeQueue(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	public NodeQueue<T> getNext() {
		return next;
	}

	public void setNext(NodeQueue<T> next) {
		this.next = next;
	}
}

