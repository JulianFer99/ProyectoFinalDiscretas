package models;

import java.util.ArrayList;

import structures.ArcGraph;
import structures.Graph;
import structures.Vertex;
import utils.Utilities;

public class Agency {

	private String name;
	private ArrayList<Bus> buses;
	private Graph<City> cities;
	private ArrayList<Driver> drivers;
	private int auxiliar = 0;

	public Agency(String name) {
		super();
		this.name = name;
		buses = new ArrayList<Bus>();
		cities = new Graph<City>();
		drivers = new ArrayList<Driver>();
	}
	

	
	public Agency(String name, ArrayList<Bus> buses, Graph<City> cities, ArrayList<Driver> drivers) {
		super();
		this.name = name;
		this.buses = buses;
		this.cities = cities;
		this.drivers = drivers;
	}



	public void addRouteBus(String licensePlate,Route route) {
		Bus auxiliar = this.askBus(licensePlate);
		auxiliar.addRoute(route);
	}

	public void addCityToGraph(String nameCity, int population) {
		Vertex<City> vertex = new Vertex<City>(new City(nameCity, population),auxiliar);
		cities.insertData(vertex);
		auxiliar++;
	}

	public void addDistanceToGraph(String nameCity1, String nameCity2, int distance) {
		ArcGraph<City> arc = new ArcGraph<>(this.askVertex(nameCity1), this.askVertex(nameCity2), distance);
		ArcGraph<City> arc2 = new ArcGraph<>(this.askVertex(nameCity2), this.askVertex(nameCity1), distance);

		cities.insertArc(arc);
		cities.insertArc(arc2);
	}

	public Vertex<City> askVertex(String name) {
		Vertex<City> result = new Vertex<City>(null,0);
		for (int i = 0; i < cities.getVertices().size(); i++) {
			if (cities.getVertices().get(i).getData().getName().equals(name)  ) {
				result = cities.getVertices().get(i);
			}
		}
		return result;
	}
	
	public int askPositionVertex(String name) {
		int result = 0 ;
		for (int i = 0; i < cities.getVertices().size(); i++) {
			if (cities.getVertices().get(i).getData().getName() == name) {
				result = i;
			}
		}
		return result;
	}
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public void deleteDriver(Driver driver) {
		drivers.remove(driver);
	}
	
	public Driver askDriver(int id) {
		Driver result = null;
		for (int i = 0; i < drivers.size(); i++) {
			if(drivers.get(i).getId()==id) {
				result = drivers.get(i);
			}
		}
		return result;
	}
	
	public Bus askBus(String licensePlate) {
		Bus result = null;
		for (int i = 0; i < buses.size(); i++) {
			if(buses.get(i).getLicensePlate().equals(licensePlate)) {
				result = buses.get(i);
			}
		}
		return result;
	}
	
	public void addBus(Bus bus) {
		buses.add(bus);
	}

	public void deleteBus(String licensePlate) {
		for (int i = 0; i < buses.size(); i++) {
			if (buses.get(i).getLicensePlate() == licensePlate) {
				buses.remove(i);
			}
		}
	}
	
	public String calculateMiniumDistance(int city1,int city2) {
		ArrayList<Integer> result = Utilities.convertToCity(cities.dijkstra(city1,city2));
		ArrayList<City> result1 = cities.showObjects2(result);
		String text = Utilities.convertResultCity(result, result1);
		return text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Bus> getBuses() {
		return buses;
	}
	
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}


	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}

	public Graph<City> getGraph() {
		return cities;
	}
	
	public void setGraph(Graph<City> cities) {
		this.cities = cities;
	}
	
	public String toStringBuses() {	
		String listBuses = "";
		String formatLine = "%1$-20s %2$-40s %3$-10s ";
		
		for (int i = 0; i < buses.size(); i++) {
			String[] routes = buses.get(i).toStringVector().split("-");
			for (int j = 0; j < buses.get(i).getRoutes().size(); j++) {
				int departure = this.askVertex(buses.get(i).getRoutes().get(j).getDepartureCity()).getValue();
				int arrival = this.askVertex(buses.get(i).getRoutes().get(j).getArrivalCity()).getValue();
				String route = this.calculateMiniumDistance(departure, arrival) ;
				String[] text= route.split(":"); 
				listBuses += String.format(formatLine, routes[j],text[1],text[3]) ;
				listBuses += "__";
			}
		}
		return listBuses;
	}

}
