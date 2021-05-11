package views;

import java.util.Scanner;

import javax.swing.JOptionPane;

import enums.Text;

public class View {
	
	private Scanner scannerObj;
	
	public View() {
		scannerObj = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println(Text.MENU_2.getText());
		return Integer.parseInt(scannerObj.nextLine());
	}
	
	public int readInt(String message) {
		System.out.println(message);
		return Integer.parseInt(scannerObj.nextLine());
	}
	
	public String readString(String message) {
		System.out.print(message);
		return scannerObj.nextLine();
	}
	
	public String readCity1() {
		System.out.print(Text.READ_NAME_CITY1.getText());
		return scannerObj.nextLine().replaceAll("\\s", "");
	}
	
	public String readCity2() {
		System.out.print(Text.READ_NAME_CITY2.getText());
		return scannerObj.nextLine();	
	}
	public String readCity3() {
		System.out.print(Text.READ_NAME_CITY2.getText());
		return scannerObj.nextLine().replaceAll("\\s", "");	
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	
	

}
