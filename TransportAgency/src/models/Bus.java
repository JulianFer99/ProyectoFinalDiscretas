package models;

import java.util.ArrayList;

public class Bus {

	private String licensePlate;
	private int capacity;
	private Driver driver;
	private ArrayList<Route> routes;

	public Bus(String licensePlate, int capacity, Driver driver) {
		super();
		this.licensePlate = licensePlate;
		this.capacity = capacity;
		this.driver = driver;
		routes = new ArrayList<Route>();
	}
	
	public void addRoute(int idRoute,String departureCity,String arrivalCity,String departureTime) {
		routes.add(new Route(idRoute,departureCity, arrivalCity, departureTime));
	}
	
	public void addRoute(Route route) {
		routes.add(route);
	}
	
	public void deleteRoute(int idRoute) {
		routes.remove(this.askRoute(idRoute));
	}
	
	public Route askRoute(int idRoute) {
		Route result = null;
		for (int i = 0; i < routes.size(); i++) {
			result = (routes.get(i).getIdRoute()==idRoute)?routes.get(i):null; 
			
			}
		return result;
	}
	

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String toStringVector() {
		String result = "";
		String formatLine = "%1$-20s %2$-20s %3$-20s %4$-20s %5$-20s %6$-20s";
		for (int i = 0; i < routes.size(); i++) {
			result += String.format(formatLine,this.licensePlate,this.capacity,driver.getName(),routes.get(i).getDepartureCity(),routes.get(i).getArrivalCity(),routes.get(i).getDepartureTime());
			result += "-";

		}
		return result;
	} 
	
	public ArrayList<Route> getRoutes(){
		return routes;
	}
}
