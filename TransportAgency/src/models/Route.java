package models;

public class Route {
	private int idRoute;
	private String departureCity;
	private String arrivalCity;
	private String departureTime;

	public Route(int idRoute, String departureCity, String arrivalCity, String departureTime) {
		super();
		this.idRoute = idRoute;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureTime = departureTime;
	}

	public int getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(int idRoute) {
		this.idRoute = idRoute;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

}
