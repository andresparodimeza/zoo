package com.zoo.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CantidadAnimal {

	//ATRIBUTOS
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private JTextArea campo;
	
	//CONSTRUCTOR
	public  CantidadAnimal(String texto){
		//CREAMOS EL PANEL DE OPCIONES
		this.panel = new JPanel();
		
		//TITULO
		this.label = new JLabel(texto);
		this.label.setBounds(190, 15, 130, 25);
		this.panel.add(label);
		
		this.campo = new JTextArea();
		this.campo.setBounds(45, 40, 400, 350);
		this.panel.add(campo);
		
		DB db = DB.getInstances();
		db.dbStatement("SELECT * FROM mamifero");
		System.out.println("FUNCIONO "+db);
		
		//BOTON
		this.button = new JButton("BACK");
		this.button.setBounds(375, 400, 100, 50);
				
		//ACCIOONES A REALIZAR EL BOTON
		this.button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			        }
			    });
				
		
		//AÑADIMOS LAS PREGUNTAS Y EL BOTON AL PANEL
		this.panel.add(button);
		
		this.panel.setSize(500, 500);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
	}
	

	public JPanel getJPanel() {
		return this.panel;
	}
}
