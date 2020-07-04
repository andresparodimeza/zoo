package com.zoo.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class  Zoologico extends JFrame{

	//ATRIBUTOS PARA LA CREACION DE LA VENTANA
	private JFrame view;
	private JButton button;
	private JLabel label;
	protected JRadioButton op1,op2;
	private ButtonGroup g;
		
	//METODO CREADOR DE LA VENTANA
	public Zoologico(){	
		//TITULO DE LA VENTANA
		this.view = new JFrame();
		
		//TITULO CENTRADO
		this.label = new JLabel("WELCOME TO MY ZOO");
		this.label.setBounds(190, 50, 150, 50);
		this.view.add(label);
		
		//BOTONES DE OPCIONES
		g=new ButtonGroup();//GRUPO CREADO PARA QUE SOLO SE SELECCIONE UNA OPCION
		
		this.op1 = new JRadioButton("Ingresar Nuevo Animal");
		this.op1.setBounds(140,150, 200,25); 
		this.op2 = new JRadioButton("Cantidad de Animales");
		this.op2.setBounds(140,175, 200,25); 
		
		//AÑADIMOS LOS BOTONES AL GRUPO
		g.add(op1);
		g.add(op2);
		
		//BOTON
		this.button = new JButton("NEXT");
		this.button.setBounds(375, 400, 100, 50);
		
		//ACCIOONES A REALIZAR EL BOTON
		this.button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	opciones(); 	
	        }
	    });
		
		this.view.add(op1);
		this.view.add(op2);
		this.view.add(button);
		
		this.view.setSize(500, 500);
		this.view.setLayout(null);
		this.view.setVisible(true);	
	}


	public void opciones() {
		
		if (op1.isSelected()){	
			NuevoAnimal sw = new NuevoAnimal(op1.getText());
        	view.setContentPane(sw.getJPanel());
        	view.invalidate();
        	view.validate();}
		
		if(op2.isSelected()){
			CantidadAnimal sw = new CantidadAnimal(op2.getText());
        	view.setContentPane(sw.getJPanel());
        	view.invalidate();
        	view.validate();}
		
		
	}


	
	
}
