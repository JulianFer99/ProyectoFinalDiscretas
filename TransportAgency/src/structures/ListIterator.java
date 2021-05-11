package structures;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T>{
	
	private NodeQueue<T> actual;
	
	public ListIterator(NodeQueue<T> node){
		actual =  node;
	}
	
	public boolean hasNext() {
		return actual!=null;
	}
	
	public T next() {
		T element =  actual.getData();
		actual =  actual.getNext();
		return element;
	}
}
