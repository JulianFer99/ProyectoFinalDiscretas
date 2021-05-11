package enums;

public enum Text {
	MENU_2("¡ BIENVENIDO AL SISTEMA DE TRANSPORTE !"
			+"\n\nDigite la funcionalidad que desea realizar"
			+"\n                      " + "1.Ingresar una nueva ciudad al sistema"
			+ "\n                      " +"2.Ingresar nuevo conductor"
			+ "\n   _____________  - - "+ "3.Ingresar un nuevo bus\n" 
			+ " _/_|[][][][][] | - - " + "4.Ingresar distancia entre dos ciudades\n"
			+"(      Terminal | - - " + "5.Agregar ruta a un bus\n"
			+"=--OO-------OO--= - - " + "6.Calcular la ruta mas corta entre dos ciudades\n"
			+"                      "  + "7.Mostrar los buses actuales de la empresa y las rutas que tienen\n"
			+"                      "  + "8.Salir del sistema\n\n"),	
	ADD_CITY_SUCESS ("  __                   ___                       \r\n"
			+ " |\"\"|  ___    _   __  |\"\"\"|  __                   \r\n"
			+ " |\"\"| |\"\"\"|  |\"| |\"\"| |\"\"\"| |\"\"|        \r\n"
			+ " |\"\"| |\"\"\"|  |\"| |\"\"| |\"\"\"| |\"\"|       \r\n"
			+ " |\"\"| |\"\"\"|  |\"| |\"\"| |\"\"\"| |\"\"|      \r\n"
			+ " \"'''\"''\"'\"\"'\"\"\"''\"''''\"\"\"'\"\"'\"\"'  \n¡ Ciudad agregada con exito al sistema !\n\n"),
	ADD_BUS_SUCESS("   _____________\r\n"
			+ " _/_|[][][][][] | - -\r\n"
			+ "(               | - -\r\n"
			+ "=--OO-------OO--=\n"
			+ "¡ El bus fue agregado exitosamente !\n\n"),
	ADD_ROUTE_SUCESS("____________________________________\r\n"
					+ "    						         \r\n"
					+ " _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\r\n"
					+ "                                  \r\n"
					+ " __________________________________\r\n"
					+ "¡ Ruta agrega exitosamente ! \n\n"),
	ADD_DRIVER_SUCESS("  ______\r\n"
			+ " /|_||_\\`.__\r\n"
			+ "(   _    _ _\\\r\n"
			+ "=`-(_)--(_)-'  "
			+ "\n ¡ Conductor Agregado con éxito !\n\n"),
	ADD_DISTANCE_SUCESS("============================================================\r\n"
			           + "La distancia entre las ciudades fue agregada exitosamente \n"
			           + "===========================================================\n\n"),
	READ_NAME_CITY("╔═══════════════════════════════╗\r\n"
			     + "║Ingrese el nombre de la ciudad ║\r\n"
			     + "╚═══════════════════════════════╝\n"),
	READ_NAME_CITY1("╔══════════════════════════════════════╗\r\n"
				  + "║Ingrese el nombre de la primer ciudad ║\r\n"
		          + "╚══════════════════════════════════════╝\n"),
	READ_NAME_CITY2("╔═══════════════════════════════════════╗\r\n"
			      + "║Ingrese el nombre de la segunda ciudad ║\r\n"
	              + "╚═══════════════════════════════════════╝\n"),
	READ_POPULATION_CITY("╔═══════════════════════════════════╗\r\n"
		               + "║Ingrese la población de la ciudad  ║\r\n"
                       + "╚═══════════════════════════════════╝\n"),
	READ_LICENSE_PLATE_BUS("╔══════════════════════════╗\r\n"
                         + "║Ingrese la placa del bus  ║\r\n"
                         + "╚══════════════════════════╝\n"),
	READ_CAPACITY_BUS("╔══════════════════════════════╗\r\n"
                    + "║Ingrese la capacidad del bus  ║\r\n"
                    + "╚══════════════════════════════╝\n"),
	READ_NAME_DRIVER("╔═════════════════════════════════╗\r\n"
                   + "║Ingrese el nombre del conductor  ║\r\n"
                   + "╚═════════════════════════════════╝\n"),
	READ_ID_DRIVER("╔════════════════════════════╗\r\n"
                 + "║Ingrese el id del conductor ║\r\n"
                 + "╚════════════════════════════╝\n"),
	READ_DISTANCE("╔═════════════════════════════════════════╗\r\n"
                + "║Ingrese la distancia entre las ciudades  ║\r\n"
                + "╚═════════════════════════════════════════╝\n"),
	READ_ID_ROUTE("╔══════════════════════════╗\r\n"
                + "║Ingrese el id de la ruta  ║\r\n"
                + "╚══════════════════════════╝\n"),
	READ_NAME_DEPARTURE_CITY("╔══════════════════════════════════════════╗\r\n"
                           + "║Ingrese el nombre de la ciudad de salida  ║\r\n"
                           + "╚══════════════════════════════════════════╝\n"),
	READ_NAME_ARRIVAL_CITY("╔═══════════════════════════════════════════╗\r\n"
                         + "║Ingrese el nombre de la ciudad de llegada  ║\r\n"
                         + "╚═══════════════════════════════════════════╝\n"),
	READ_NAME_DEPARTURE_TIME("╔═══════════════════════════════════════════╗\r\n"
                           + "║Ingrese la hora de salida en formato HH:ss ║\r\n"
                           + "╚═══════════════════════════════════════════╝\n"),
	READ_SALARY_DRIVER("╔═════════════════════════════════╗\r\n"
                     + "║Ingrese el salario del conductor ║\r\n"
                     + "╚═════════════════════════════════╝\n");






	
	
	private String text;
	
	private Text(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
