package controller;

import enums.Text;
import models.Agency;
import models.Bus;
import models.City;
import models.Driver;
import models.Route;
import structures.Graph;
import views.View;

public class Controller {

	private Agency agencyObj;
	private View viewObj;

	public Controller() {
		agencyObj = new Agency("Reina");
		viewObj = new View();
		loadData();
		run();

	}


	private void run() {
		boolean isTrue = true;
		while (isTrue) {
			int option = viewObj.showMenu();
			switch (option) {

			case 1:
				String nameCity = viewObj.readString(Text.READ_NAME_CITY.getText());
				int populationCity = viewObj.readInt(Text.READ_POPULATION_CITY.getText());
				agencyObj.addCityToGraph(nameCity,populationCity);
				viewObj.showMessage(Text.ADD_CITY_SUCESS.getText());
				break;

			case 2:
				agencyObj.addDriver(new Driver(viewObj.readString(Text.READ_NAME_DRIVER.getText()),
						viewObj.readInt(Text.READ_ID_DRIVER.getText()),
						viewObj.readInt(Text.READ_SALARY_DRIVER.getText())));
				viewObj.showMessage(Text.ADD_DRIVER_SUCESS.getText());
				break;
			case 3:
				agencyObj.addBus(new Bus(viewObj.readString(Text.READ_LICENSE_PLATE_BUS.getText()),
						viewObj.readInt(Text.READ_CAPACITY_BUS.getText()),
						agencyObj.askDriver(viewObj.readInt(Text.READ_ID_DRIVER.getText()))));
				viewObj.showMessage(Text.ADD_BUS_SUCESS.getText());
				break;

			case 4:
				String city1_ = viewObj.readString(Text.READ_NAME_CITY1.getText());
				String city2_ = viewObj.readString(Text.READ_NAME_CITY2.getText());
				int distance = viewObj.readInt(Text.READ_DISTANCE.getText());
				agencyObj.addDistanceToGraph(city1_,city2_,distance);
				viewObj.showMessage(Text.ADD_DISTANCE_SUCESS.getText());
				break;
				
			case 5:
			String licensePlate = viewObj.readString(Text.READ_LICENSE_PLATE_BUS.getText());
			Route route = new Route(viewObj.readInt(Text.READ_ID_ROUTE.getText()), viewObj.readString(Text.READ_NAME_DEPARTURE_CITY.getText()), viewObj.readString(Text.READ_NAME_ARRIVAL_CITY.getText()), viewObj.readString(Text.READ_NAME_DEPARTURE_TIME.getText()));
			agencyObj.addRouteBus(licensePlate,route);
			viewObj.showMessage(Text.ADD_ROUTE_SUCESS.getText());
			break;

			case 6:
				String city1 = viewObj.readString(Text.READ_NAME_CITY1.getText());
				String city2 = viewObj.readString(Text.READ_NAME_CITY2.getText());
				
				int value1 = agencyObj.askVertex(city1).getValue();
				int value2 = agencyObj.askVertex(city2).getValue();
				
				String result = agencyObj.calculateMiniumDistance(value1, value2);
				viewObj.showMessage(result);				
				break;
			case 7:
				this.showBuses();
			break;
			case 8:
				isTrue = false;
				break;

			}
		}
	}
	
	private void loadData() {
		
		agencyObj.addCityToGraph("Tunja",12345);
		agencyObj.addCityToGraph("Sogamoso",54321);
		agencyObj.addCityToGraph("Duitama",54321);
		agencyObj.addCityToGraph("Paipa",54321);
		agencyObj.addCityToGraph("Firavitoba",54321);
		agencyObj.addDistanceToGraph("Tunja", "Paipa", 21);
		agencyObj.addDistanceToGraph("Tunja", "Firavitoba", 44);
		agencyObj.addDistanceToGraph("Paipa", "Duitama", 13);
		agencyObj.addDistanceToGraph("Duitama", "Sogamoso", 5);
		agencyObj.addDistanceToGraph("Firavitoba", "Sogamoso", 10);
		
		agencyObj.addDriver(new Driver("Fernando", 123, 812731));
		agencyObj.addBus(new Bus("ABC123", 32, agencyObj.askDriver(123)));
		
		agencyObj.addDriver(new Driver("Juan", 321, 12412412));
		agencyObj.addBus(new Bus("DEF567", 32, agencyObj.askDriver(321)));
		
		agencyObj.addRouteBus("ABC123", new Route(1, "Tunja", "Sogamoso", "08:10"));
		agencyObj.addRouteBus("ABC123", new Route(2, "Tunja", "Paipa", "05:15"));
		agencyObj.addRouteBus("ABC123", new Route(3, "Tunja", "Duitama", "14:30"));
		
		agencyObj.addRouteBus("DEF567", new Route(1, "Tunja", "Sogamoso", "08:10"));
		agencyObj.addRouteBus("DEF567", new Route(2, "Tunja", "Paipa", "05:15"));
		agencyObj.addRouteBus("DEF567", new Route(3, "Tunja", "Duitama", "14:30"));
		
		
	}
	
	private void showBuses() {
		String formatLine = "%1$-20s %2$-20s %3$-20s %4$-20s %5$-20s %6$-20s %7$-40s %8$-20s";
		viewObj.showMessage("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
		viewObj.showMessage(String.format(formatLine, "PLACA BUS","CAPACIDAD","CONDUCTOR","CIUDAD DE SALIDA","CIUDAD DE LLEGADA","HORA DE SALIDA","RUTA MAS CORTA","DISTANCIA"));
		String[] show = agencyObj.toStringBuses().split("__");
		for (String string : show) {
			viewObj.showMessage("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
			viewObj.showMessage(string);
		}
		viewObj.showMessage("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
	}
}
