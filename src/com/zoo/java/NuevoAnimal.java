package com.zoo.java;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;


public class NuevoAnimal {
	//ATRIBUTOS
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private JRadioButton M,A,AN,R,P;
	private ButtonGroup g;
	private ClaseDeAnimal m;
	
	//CONSTRUCTOR DE VENTANA Y BOTONES DE SELLECION
	public NuevoAnimal(String texto){
		//CREAMOS EL PANEL DE OPCIONES
		this.panel = new JPanel();
		
		//LE COLOCAMOS UN TITULO
		this.label = new JLabel(texto);
		this.label.setBounds(190, 50, 150, 50);
		this.panel.add(label);
		
		//CREAMOS EL GRUPO PARA LAS OPCIONES
		g=new ButtonGroup();
		
		//FORMULAMOS LAS OPCIONES
		this.M = new JRadioButton("Mamiferos");
		this.M.setBounds(140,150, 200,25); 
	
		this.A = new JRadioButton("Aves");
		this.A.setBounds(140,175, 200,25); 
		
		this.AN = new JRadioButton("Anfibios");
		this.AN.setBounds(140,200, 200,25); 
		
		this.R = new JRadioButton("Reptiles");
		this.R.setBounds(140,225, 200,25); 
		
		this.P = new JRadioButton("Peces");
		this.P.setBounds(140,250, 200,25); 
			
		//AÑADIMOS LOS BOTONES AL GRUPO
		g.add(M);
		g.add(A);
		g.add(AN);
		g.add(R);
		g.add(P);
		
		//BOTON
		this.button = new JButton("NEXT");
		this.button.setBounds(375, 400, 100, 50);
				
		//ACCIOONES A REALIZAR EL BOTON
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       	opciones(); 	
			        } });
				
		
		//AÑADIMOS LAS PREGUNTAS Y EL BOTON AL PANEL
		this.panel.add(M);
		this.panel.add(A);
		this.panel.add(AN);
		this.panel.add(R);
		this.panel.add(P);
		this.panel.add(button);
		
		this.panel.setSize(500, 500);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
	}
	
	//ACCIONES DE LOS BOTONES DE SELECCION
	public void opciones() {		
		final ArrayList<String> Array = new ArrayList<String>();
		String sonido = "ninguno";
		String tipo = null, alim = null;
		String repro = null;
		String vert = null;
		String come = null;
		String vive = null;
		String defec = null;
		m = new ClaseDeAnimal();
		
		if(M.isSelected()){ tipo=m.mamifero(true); Array.add(0,tipo); }
		else 
			if(A.isSelected()){ tipo=m.ave(true); Array.add(0,tipo);}
			else 
				if(AN.isSelected()){tipo=m.anfibio(true); Array.add(0,tipo);}
				else 
					if(R.isSelected()){tipo=m.reptil(true); Array.add(0,tipo);}
					else
						if (P.isSelected()){tipo=m.pes(true); Array.add(0,tipo);}
						else 
							{JOptionPane.showMessageDialog(null,"***ERRO, SELECIONE UN TIPO***","ERROR",JOptionPane.ERROR_MESSAGE);
							new Zoologico();
				            }
		
		
		
			String nombre = JOptionPane.showInputDialog(null,"¿NOMBRE DEL ANIMAL?", 
					"CUESTIONARIO",JOptionPane.QUESTION_MESSAGE);
			String genero = JOptionPane.showInputDialog(null,"¿GENERO?",
					"CUESTIONARIO",JOptionPane.QUESTION_MESSAGE);
			
			m.setNombre(nombre);
			
			if ((nombre==null)||(genero==null)){
				JOptionPane.showMessageDialog(null,"***ERRO, NO EXIXTE NOMBRE o GENERO***","ERROR",JOptionPane.ERROR_MESSAGE);	
				new Zoologico();
	        	Window w = SwingUtilities.getWindowAncestor(panel);
	        	w.setVisible(false);
			}else 
				{Array.add(1,nombre);
				Array.add(2,genero);}
			
			
			
			
			int vi = JOptionPane.showConfirmDialog(null,"¿ESTA VIVO?", "CUESTIONARIO",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(vi==0){vive=m.Vive();Array.add(3,vive);}
			else 
				if(vi==1){vive=m.NoVive();Array.add(3,vive);}
				else
					{JOptionPane.showMessageDialog(null,"***ERRO  1 ***","ERROR",JOptionPane.ERROR_MESSAGE);
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.setVisible(false);
					}
			
			
				
			String [] opciones = {"Ovipara","Vivipara","Ovovivipara"};
			int r = JOptionPane.showOptionDialog(null, "¿COMO ES SU REPRODUCCION?", "CUESTIONARIO", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]);
			
			if(r==0){repro=m.oviparos(); Array.add(4,repro);}
		    else 
				if(r==1){repro=m.viviparos(); Array.add(4,repro);}
				else 
					if(r==2){repro=m.ovoviviparos(); Array.add(4,repro);}
					else 
						{JOptionPane.showMessageDialog(null,"***ERRO  2 ***","ERROR",JOptionPane.ERROR_MESSAGE);
						new Zoologico();
			        	Window w = SwingUtilities.getWindowAncestor(panel);
			        	w.setVisible(false);}
			
			
			
			int c = JOptionPane.showConfirmDialog(null,"¿PUEDE COMER?", "CUESTIONARIO",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(c==0){come=m.Comer();Array.add(5,come);}
			else 
				if(c==1){come=m.NoComer();Array.add(5,come);}
				else 
					{JOptionPane.showMessageDialog(null,"***ERRO  3***","ERROR",JOptionPane.ERROR_MESSAGE);
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.setVisible(false);
					}
			
			
			
			String [] opcion = {"Herbivora","Carnivora","Omnivora"};
			int a = JOptionPane.showOptionDialog(null, "¿COMO ES SU ALIMENTACION?", "CUESTIONARIO", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opcion, opcion[0]);
			
			if(a==0){ alim=m.herbivoros(); Array.add(6,alim);}
			else 
				if(a==1){alim=m.carnivoros(); Array.add(6,alim);}
				else 
					if(a==2){alim=m.omnivoros(); Array.add(6,alim);}
					else 
						{JOptionPane.showMessageDialog(null,"***ERROR  4 ***","ERROR",JOptionPane.ERROR_MESSAGE);
						new Zoologico();
			        	Window w = SwingUtilities.getWindowAncestor(panel);
			        	w.setVisible(false);
						}
			
			
			
			int v = JOptionPane.showConfirmDialog(null,"¿TIENE VERTEBRAS?", "CUESTIONARIO",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(v==0){vert=m.vertebra();Array.add(7,vert);}
			else 
				if(v==1){vert=m.NoVertebra();Array.add(7,vert);}
				else 
					{JOptionPane.showMessageDialog(null,"***ERRO  5 ***","ERROR",JOptionPane.ERROR_MESSAGE);
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.setVisible(false);
					}
			
			
			
			int d = JOptionPane.showConfirmDialog(null,"¿PUEDE DEFECAR?", "CUESTIONARIO",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(d==0){defec=m.Defeca();Array.add(8,defec);}
			else 
				if(d==1){defec=m.NoDefeca();Array.add(8,defec);}
				else 
					{JOptionPane.showMessageDialog(null,"***ERRO 6 ***","ERROR",JOptionPane.ERROR_MESSAGE);
					new Zoologico();
		        	Window w = SwingUtilities.getWindowAncestor(panel);
		        	w.setVisible(false);
					}
			
			
			
			int s = JOptionPane.showConfirmDialog(null,"¿PUEDE HACER ALGUN SONIDO?", "CUESTIONARIO",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
				
			if(s==0){sonido = JOptionPane.showInputDialog(null,"¿QUE SONIDO HACE?",
					"CUESTIONARIO",JOptionPane.QUESTION_MESSAGE);
				m.setSonido(sonido);  sonido=m.sonido(); Array.add(9,sonido);}
			
		    panel.removeAll();
		    panel.repaint();
		    
			this.label = new JLabel(tipo);
			this.label.setBounds(190, 50, 150, 50);
			this.panel.add(label);
			
			this.label = new JLabel("Nombre: "+nombre);
			this.label.setBounds(100, 75, 200, 50);
			this.panel.add(label);
			
			this.label = new JLabel("Genero: "+genero);
			this.label.setBounds(100,100, 225, 50);
			this.panel.add(label);
			
			this.label = new JLabel("VIve: "+vive);
			this.label.setBounds(100, 125, 250, 50);
			this.panel.add(label);
			
			this.label = new JLabel("Reproduccion: "+repro);
			this.label.setBounds(100, 150, 275, 50);
			this.panel.add(label);
			
			this.label = new JLabel("Come: "+come);
			this.label.setBounds(100, 175, 300, 50);
			this.panel.add(label);
		
			this.label = new JLabel("Tipo de Alimentacion: "+alim);
			this.label.setBounds(100, 200, 325, 50);
			this.panel.add(label);	
			
			this.label= new JLabel("Tiene vertebras: "+vert);
			this.label.setBounds(100,225,350,50);
			this.panel.add(label);
			
			this.label=new JLabel("Puede defecar: "+defec);
			this.label.setBounds(100,250,375,50);
			this.panel.add(label);
			
			this.label=new JLabel("Hace algun sonido: "+sonido);
			this.label.setBounds(100,275,400,50);
			this.panel.add(label);
			
			this.button = new JButton("SAVE ALL");
			this.button.setBounds(375, 400, 100, 50);
			
			
			
			//ACCIOONES A REALIZAR EL BOTON
			this.button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					    panel.removeAll();  
					    DB db = DB.getInstances();
						Object[]obj=Array.toArray();
						db.dbPrepareStatement("INSERT INTO "+ Array.get(0)+"(nombre, genero, vive,"
						+ " reproduccion, come, tipo_de_alimentacion, tiene_vertebras, puede_defecar,"
						+ " hace_algun_sonido)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", obj);
						 
						new Zoologico();
			        	Window w = SwingUtilities.getWindowAncestor(panel);
			        	w.setVisible(false);
						
					}	
				});  
				    
			this.panel.add(button);
	}		

	 JPanel getJPanel() {return this.panel;}
}
