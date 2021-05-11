package structures;

import java.util.ArrayList;

public class Graph<T> {

	/**
	 * @author Manuel Canon
	 */

	private int numberVertex;
	private int[][] adyacense;
	private boolean distance[];
	public int valueObject = 0;
	private ArrayList<Vertex<T>> vertices;

	/**
	 * Inicializa un arreglo de vertices
	 */
	public Graph() {
		vertices = new ArrayList<Vertex<T>>();
	}

	/**
	 * Inserta un dato , en un vertice
	 * 
	 * @param vertex representa el vertice a ingresar
	 */
	public void insertData(Vertex<T> vertex) {
		if (isEmpty()) {
			vertex.setValue(valueObject);
			distance = new boolean[1];
			this.numberVertex = 1;
			adyacense = new int[numberVertex][numberVertex];
			valueObject++;
			vertices.add(vertex);
		} else {
			incrementMatrix();
			vertex.setValue(valueObject);
			valueObject ++;
			vertices.add(vertex);
			incrementMark();
		}
	}

	/**
	 * Borra un vertice
	 * 
	 * @param vertex es el vertice a borrar NO BORRA BIEN
	 */
	public void deleteData(Vertex<T> vertex) {
		if (!isEmpty()) {
			incrementMatrix();
			vertex.setValue(valueObject);
			valueObject++;
			vertices.add(vertex);
			incrementMark();
		}
	}

	private void incrementMark() {
		boolean[] auxiliar = distance;
		boolean[] newA = new boolean[auxiliar.length + 1];
		for (int i = 0; i < distance.length; i++) {
			newA[i] = auxiliar[i];
		}
		distance = newA;
	}

	/**
	 * Verifica si el grafo esta vacio
	 * 
	 * @return true si esta vacio o false si no lo esta
	 */
	public boolean isEmpty() {
		return (adyacense == null) ? true : false;
	}

	private void incrementMatrix() {
		int size = adyacense.length;
		int[][] result = new int[size + 1][size + 1];
		for (int i = 0; i < adyacense.length; i++) {
			for (int j = 0; j < adyacense[i].length; j++) {
				result[i][j] = adyacense[i][j];
			}
		}
		adyacense = result;

	}

	public void insertArc(ArcGraph<T> arc) {

		for (int i = 0; i < adyacense.length; i++) {
			for (int j = 0; j < adyacense[i].length; j++) {
				if (i == (arc.getVertexInitial().getValue()) && j == (arc.getVertexFinal().getValue())) {
					adyacense[i][j] = arc.getWeigth();
				}
			}
		}
	}

	public void deleteArc(ArcGraph<T> arc) {
		for (int i = 0; i < adyacense.length; i++) {
			for (int j = 0; j < adyacense[i].length; j++) {
				if (i == (arc.getVertexInitial().getValue()) && j == (arc.getVertexFinal().getValue())) {
					adyacense[i][j] = 0;
				}
			}
		}
	}

	public ArrayList<Integer> traverseGraph(int numberInitial) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<Integer> auxiliar = new Queue<Integer>();
		int number = numberInitial;
		distance[number] = true;
		auxiliar.push(number);
		while (!auxiliar.isEmpty()) {
			result.add(auxiliar.poll());
			ArrayList<Integer> adyacense = this.askAdyance(number);
			for (int i = 0; i < adyacense.size(); i++) {
				if (distance[adyacense.get(i)] == false) {
					distance[adyacense.get(i)] = true;
					auxiliar.push(adyacense.get(i));
				}
			}
			if (!auxiliar.isEmpty()) {
				number = auxiliar.peek();
			}
		}
		this.distance = new boolean[this.adyacense.length];
		return result;
	}

	public ArrayList<T> showObjects(int value) {
		ArrayList<T> result = new ArrayList<T>();
		ArrayList<Integer> auxiliar = this.traverseGraph(value);
		for (int i = 0; i < auxiliar.size(); i++) {
			for (int j = 0; j < adyacense.length; j++) {
				if (vertices.get(i).getValue() == auxiliar.get(j)) {
					result.add(vertices.get(i).getData());
				}
			}
		}
		return result;
	}

	public ArrayList<T> showObjects2(ArrayList<Integer> numbers) {
		ArrayList<T> result = new ArrayList<T>();
		ArrayList<Integer> auxiliar = numbers;
		for (Integer integer : auxiliar) {
			for (int i = 0; i < vertices.size(); i++) {
				if (integer == vertices.get(i).getValue()) {
					result.add(vertices.get(i).getData());
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> askAdyance(int number) {
		int auxiliar = number;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < adyacense.length; i++) {
			for (int j = 0; j < adyacense[i].length; j++) {
				if (i == auxiliar && adyacense[i][j] != 0) {
					result.add(j);
				}
			}
		}
		return result;
	}

	public void printMatrix(int[][] adyacense) {
		for (int i = 0; i < adyacense.length; i++) {
			for (int j = 0; j < adyacense[i].length; j++) {
				System.out.print(adyacense[i][j] + "\t" + "");
			}
			System.out.println("\n");
		}
	}

	public String dijkstra(int origen, int destinity) {
		emptyDistance();
		int number = origen;
		int auxiliarPass = 0;
		int auxiliarValue = 0;
		int last = 0;
		String rute = number + ",";
		
		distance[number] = true;

		int[][] matrixAux = new int[adyacense.length][adyacense.length];
		ArrayList<Integer> auxiliar = this.askAdyance(number);

		for (Integer integer : auxiliar) {
			if (distance[integer] == false) {
				matrixAux[integer][auxiliarPass] = adyacense[number][integer];

			}
		}

		auxiliarValue = adyacense[number][this.askMinor(matrixAux, auxiliarPass)];
		number = this.askMinor(matrixAux, auxiliarPass);
		distance[number] = true;
		rute += "" + number;
		auxiliarPass++;
		last = number;

		while (number != destinity) {

			auxiliar = new ArrayList<Integer>();
			auxiliar = this.askAdyance(number);
			for (int i = 0; i < auxiliar.size(); i++) {
				if (distance[auxiliar.get(i)] == false) {
					distance[auxiliar.get(i)] = true;
					matrixAux[auxiliar.get(i)][auxiliarPass] = adyacense[number][auxiliar.get(i)] + auxiliarValue;
					if (matrixAux[auxiliar.get(i)][auxiliarPass - 1] != 0) {
						if (matrixAux[auxiliar.get(i)][auxiliarPass - 1] < matrixAux[i][auxiliarPass]) {
							matrixAux[auxiliar.get(i)][auxiliarPass] = matrixAux[i][auxiliarPass - 1];
						}
					}
				}
			}
			number = this.askMinor(matrixAux, auxiliarPass);
			if (matrixAux[last][auxiliarPass - 1] < matrixAux[number][auxiliarPass]) {
				rute += "," + number;
				auxiliarValue = matrixAux[number][auxiliarPass];
			} else {
				rute = "" + number;
				auxiliarValue = adyacense[number][this.askMinor(matrixAux, auxiliarPass)];
			}
			last = number;
			auxiliarPass++;
		}
		return rute + "-" + auxiliarValue;
	}

	public int askMinor(int[][] matrix, int point) {
		int result = 0;
		int minor = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][point] != 0) {
				minor = matrix[i][point];
				result = i;
			}
		
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][point] != 0) {
				if ((matrix[i][point]) < minor) {
					minor = matrix[i][point];
					result = i;
				}
			}

		}

		return result;
	}

	public Vertex<T> askVertex(T date) {
		Vertex<T> result = new Vertex<T>(null,0);

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getData() == date) {
				result = vertices.get(i);
			}
		}
		return result;
	}
	
	public ArrayList<Vertex<T>> getVertices(){
		return vertices;
	}
	
	private void emptyDistance() {
		for (int i = 0; i < distance.length; i++) {
			distance[i]=false;
		}
	}

}
