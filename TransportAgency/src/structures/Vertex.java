package structures;

public class Vertex<T> {
/**
 * @author Manuel Cañon
 */

	private T data;
	private int value;

/**
 * Ingresa un objeto al vertice
 * @param data es el objeto 
 */
	public Vertex(T data,int value) {
		this.data = data;
		this.value = value;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
