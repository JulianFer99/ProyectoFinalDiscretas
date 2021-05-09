package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {
	private JLabel title;
	
	private JMenuBar mb;
    private JMenu menu;
    private JMenuItem addBus, addDriver, information, calculateRoute, edit;
    private JTextArea description;
    private JTextArea contact;
    
//    private Maps

	public MainWindow(String title) {
		super(title);
		setSize(new Dimension(550, 620));
		setLayout(new GridBagLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		beginComponents();
		addComponents();
	}

	public void beginComponents() {
		description = new JTextArea("Los Libertadores es un servicio de transporte \n"
					+"de pasajeros entregado por Coflonorte, una empresa \n"
					+"de transporte terrestre fundada el año 1953 en Boyacá \n"
					+"con el nombre Flota Norte, tomando su nombre actual \n"
					+"en el año 1965. Los Libertadores ofrecen sus servicios \n"
					+"principalmente desde Bogotá con salida desde la \n"
					+"Terminal Salitre. La empresa también ofrece, junto \n"
					+"con el transporte de pasajeros, servicios de turismo, \n"
					+"servicios personalizados y carga.");
		
		contact = new JTextArea("Oficina Principal: Calle 9 # 20-08 Sogamoso – Boyacá.\r\n"
				+ "	(57+8) 7725815 Línea Amiga\r\n"
				+ "                Email: servicioalcliente@coflonorte.com");
	
	}

	public void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		title = new JLabel("Sistema de Recorridos Libertadores SAS");
		title.setFont(new Font("Serif", Font.PLAIN, 25));
		add(title, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		add(menu(), gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 2;
		ImageIcon imgFlag = new ImageIcon("resources/bus.jpg");
		JLabel bnrFlag = new JLabel();
		bnrFlag.setIcon(imgFlag);
		add(bnrFlag, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 2;
		gbc.gridx = 2;
		add(new JLabel("      "), gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 2;
		gbc.gridx = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		description.setBackground(new Color(0, 0, 0, 0));
		description.setFont(new Font("Serif", Font.PLAIN, 15));
		add(description, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		
		gbc.gridy = 3;
//		gbc.gridx = 2;
		gbc.gridwidth = 4;
		add(new JLabel("      "), gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		ImageIcon imgMap = new ImageIcon("resources/map.png");
		JLabel bnrMap = new JLabel();
		bnrMap.setIcon(imgMap);
		contact.setBackground(new Color(0, 0, 0, 0));
		add(bnrMap, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 6;
		gbc.gridwidth = 4;
		add(contact, gbc);
	}

	private Component menu() {
		mb = new JMenuBar();
		setJMenuBar(mb);
		addBus = new JMenu("Registrar Bus");
		mb.add(addBus);
		addDriver = new JMenu("Registrar Conductor");
		mb.add(addDriver);
		information = new JMenu("Informacion");
		mb.add(information);
		calculateRoute = new JMenu("Calcular Recorrido");
		mb.add(calculateRoute);
		edit = new JMenu("Editar");
		mb.add(edit);
		
		return mb;
	}
}
