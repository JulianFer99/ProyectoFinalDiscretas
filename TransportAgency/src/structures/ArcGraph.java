package structures;

public class ArcGraph<T> {

	private Vertex<T> vertexInitial, vertexFinal;
	private int weigth;

	public ArcGraph(Vertex<T> vertexInitial, Vertex<T> vertexFinal, int weigth) {
		super();
		this.vertexInitial = vertexInitial;
		this.vertexFinal = vertexFinal;
		this.weigth = weigth;
	}

	public Vertex<T> getVertexInitial() {
		return vertexInitial;
	}

	public void setVertexInitial(Vertex<T> vertexInitial) {
		this.vertexInitial = vertexInitial;
	}

	public Vertex<T> getVertexFinal() {
		return vertexFinal;
	}

	public void setVertexFinal(Vertex<T> vertexFinal) {
		this.vertexFinal = vertexFinal;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

}
