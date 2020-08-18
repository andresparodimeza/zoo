package com.zoo.java;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EliminaAnimal{
	//ATRIBUTOS
		private JPanel panel;
		private JLabel label;
		private JButton button,button1;
		private JTextArea textA;
		private JTextField textFi;

		
		//CONSTRUCTOR
		public  EliminaAnimal(String texto){

			//CREAMOS EL PANEL DE OPCIONES
			this.panel = new JPanel();
			
			//TITULO
			this.label = new JLabel(texto);
			this.label.setBounds(190, 15, 130, 25);
			this.panel.add(label);
		
			this.label = new JLabel("ACCION:");
			this.label.setBounds(45, 50, 130, 25);
			this.panel.add(label);
			
			this.label = new JLabel("NOMBRE DEL ANIMAL:");
			this.label.setBounds(45, 75, 130, 25);
			this.panel.add(label);
					
			this.textFi= new JTextField ();
			this.textFi.setBounds(176, 75, 120, 20);
			this.panel.add(textFi);		

			this.textA = new JTextArea();
			this.textA.setBounds(95, 50, 120, 20);
			this.panel.add(textA);	
			
			//BOTONES
			this.button = new JButton("BACK");
			this.button.setBounds(445, 400, 100, 50);
			this.button1 = new JButton("DELETE");
			this.button1.setBounds(330, 400, 100, 50);
			
			
			//ACCIOONES A REALIZAR EL BOTON
			this.button.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {	
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.hide();
				        }
				    });
					
			this.button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.print(textFi.getText());

						DB db = DB.getInstances();

						db.dbPrepareStatement2("DELETE FROM mamifero WHERE nombre ='"+textFi.getText()+"' ;");
						//JOptionPane.showMessageDialog(null, "Seleccione un Animal de la tabla para eliminarlo.");

				        }
				    });
			
			
			//AÑADIMOS LOS BOTONES AL PANEL
			
			this.panel.add(button);
			this.panel.add(button1);
			
			this.panel.setSize(600,500);
			this.panel.setLayout(null);
			
			this.panel.setVisible(true);
			
		}
		

		public JPanel getJPanel() {
			return this.panel;
		}
}
