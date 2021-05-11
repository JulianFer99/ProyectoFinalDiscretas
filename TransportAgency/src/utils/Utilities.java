package utils;

import java.util.ArrayList;

import models.City;

public class Utilities {

	public static ArrayList<Integer> convertToCity(String text) {
		ArrayList<Integer> citys = new ArrayList<Integer>();
		String[] aux = text.split(",");
		String[] aux2 = aux[aux.length - 1].split("-");
		for (int i = 0; i < aux.length - 1; i++) {
			citys.add(Integer.parseInt(aux[i]));
		}
		citys.add(Integer.parseInt(aux2[0]));
		citys.add(Integer.parseInt(aux2[1]));
		return citys;
	}

	public static String convertResult(ArrayList<Integer> result, ArrayList<String> result1) {

		String text = "";
		text += ("La ruta mas corta entre " + result1.get(0) + " y " + result1.get(result1.size()-1) + " es : ");
		for (String string : result1) {
			text += (string + ",");
		}
		text += ("\nCon una distancia de :" + result.get(result.size() - 1) + "Km");
		return text;
	}
	
	public static String convertResultCity(ArrayList<Integer> result, ArrayList<City> result1) {

		String text = "";
		text += ("La ruta mas corta entre " + result1.get(0).getName() + " y " + result1.get(result1.size()-1).getName() + " es :");
		for (City city : result1) {
			text += (city.getName() + "-");
		}
		text += (":con una distancia de :" + result.get(result.size() - 1) + "Km");
		return text;
	}
}
