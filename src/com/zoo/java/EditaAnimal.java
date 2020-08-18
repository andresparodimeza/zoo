package com.zoo.java;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class EditaAnimal {
	//ATRIBUTOS
		private JPanel panel;
		private JLabel label;
		private JButton button,button1,button2;
		private JTable tabla;
		private JTextArea textA;
		private DefaultTableModel dtm;

		
		//CONSTRUCTOR
		public  EditaAnimal(String texto){
			//CREAMOS EL PANEL DE OPCIONES
			this.panel = new JPanel();
			
			//TITULO
			this.label = new JLabel(texto);
			this.label.setBounds(190, 15, 130, 25);
			this.panel.add(label);
		
			this.label = new JLabel("Nº ANIMALES:");
			this.label.setBounds(45, 410, 130, 25);
			this.panel.add(label);
			
			this.textA = new JTextArea();
			this.textA.setBounds(125, 410, 30, 20);
			this.panel.add(textA);
			
			this.tabla = new JTable(dtm);
			this.tabla.setBounds(45, 40, 500, 350);
			dtm=(DefaultTableModel)tabla.getModel();

			
			String titulos[]={"1","2","3","4","4","6","7","8","9"};
			dtm.setColumnIdentifiers(titulos);
			
			final DB db = DB.getInstances();
			
			ArrayList<String> algo =db.dbStatement("SELECT * FROM mamifero");
			Iterator<String> itera= algo.iterator();
			 String[] obj = new String[9];
			 
			 while(itera.hasNext()){	
				 for(int i=0;i<9;++i){
					 String elemento=itera.next();
					 obj[i]=(elemento);
				 }
				dtm.addRow(obj);
			 }
			
			int total;
			total=dtm.getRowCount();
			textA.setText(String.valueOf("   "+total));
			
		    this.panel.add(tabla);
			
			
			//BOTONES
			this.button = new JButton("BACK");
			this.button.setBounds(445, 400, 100, 50);
			this.button1 = new JButton("DELETE");
			this.button1.setBounds(330, 400, 100, 50);
			this.button2 = new JButton("EDIT");
			this.button2.setBounds(215, 400, 100, 50);
			
			
			//ACCIOONES A REALIZAR EL BOTON
			this.button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.setVisible(false);
				        }
				    });
					
			this.button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int fila, total;
					fila=tabla.getSelectedRow();
					if(fila==0){
						db.dbStatement("DELETE FROM mamifero WHERE nombre = '"+fila+"';");
						dtm.removeRow(fila);
						
					}else
						JOptionPane.showMessageDialog(null, "Seleccione un Animal de la tabla para eliminarlo.");
		        	total=dtm.getRowCount();
		        	textA.setText(String.valueOf(total));
				        }
				    });
			
			this.button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.setVisible(false);
		        	
		        	
				        }
				    });
			
			//AÑADIMOS LAS PREGUNTAS Y EL BOTON AL PANEL
			this.panel.add(button);
			this.panel.add(button1);
			this.panel.add(button2);
			this.panel.setSize(600,500);
			this.panel.setLayout(null);
			this.panel.setVisible(true);
		}
		

		public JPanel getJPanel() {
			return this.panel;
		}
}
