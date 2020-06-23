package com.zoo.java;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class NuevoAnimal extends JFrame{
	//ATRIBUTOS
	private JPanel panel;
	private JLabel label,label1,label2,label3,label4,label5,label6,label7;
	private JButton button;
	private JRadioButton M,A,AN,R,P;
	private ButtonGroup g;
	private JFrame view;
	
	//CONSTRUCTOR
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
				    panel.removeAll();
			       	opciones(); 	
			        }
			    });
				
		
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
	
	
	public void opciones() {
		
		if(M.isSelected()){
			
			String nombre = JOptionPane.showInputDialog(null,"¿NOMBRE DEL ANIMAL?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			String genero = JOptionPane.showInputDialog(null,"¿GENERO?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			
			int v = JOptionPane.showConfirmDialog(null,"¿ESTA VIVO?", "CUESTIONARIO",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int mov = JOptionPane.showConfirmDialog(null,"¿PUEDE MOVERSE?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int c = JOptionPane.showConfirmDialog(null,"¿PUEDE COMER?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int d = JOptionPane.showConfirmDialog(null,"¿PUEDE DEFECAR?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String vivir ="",moverse=null,comer=null,defecar=null;
			
			if(v==0){vivir=Integer.toString(v); vivir="si";
			}else if(v==1){	vivir=Integer.toString(v);vivir="NO";}
			
			if(v==0){moverse=Integer.toString(mov); moverse="si";
			}else if(v==1){	moverse=Integer.toString(mov);moverse="NO";}
			
			if(v==0){comer=Integer.toString(c); comer="si";
			}else if(v==1){	comer=Integer.toString(c);comer="NO";}
			
			if(v==0){defecar=Integer.toString(d); defecar="si";
			}else if(v==1){	defecar=Integer.toString(d);defecar="NO"; }
			
			Mamiferos m= new Mamiferos(nombre,genero,vivir,moverse,comer,defecar);
			
			
			this.view = new JFrame();
			this.paintAll(getGraphics());
			this.label1 = new JLabel("NUEVO MAMIFERO");
			this.label1.setBounds(190, 50, 150, 50);
			this.view.add(label1);
			
			this.label2 = new JLabel("NOMBRE: "+nombre);
			this.label2.setBounds(190, 75, 200, 50);
			this.view.add(label2);
			
			this.label3 = new JLabel("GENERO: "+genero);
			this.label3.setBounds(190,100, 225, 50);
			this.view.add(label3);
			
			this.label4 = new JLabel("ESTA VIVO: "+vivir);
			this.label4.setBounds(190, 125, 250, 50);
			this.view.add(label4);
			
			this.label5 = new JLabel("SE PUEDE MOVER: "+moverse);
			this.label5.setBounds(190, 150, 275, 50);
			this.view.add(label5);
			
			this.label6 = new JLabel("PUEDE COMER: "+comer);
			this.label6.setBounds(190, 175, 300, 50);
			this.view.add(label6);
			
			this.label7 = new JLabel("PUEDE DEFECAR: "+defecar);
			this.label7.setBounds(190, 200, 325, 50);
			this.view.add(label7);
			
			this.view.setSize(500, 500);
			this.view.setLayout(null);
			this.view.setVisible(true);
		}
			
		if(A.isSelected()){
			String nombre = JOptionPane.showInputDialog(null,"¿NOMBRE DEL ANIMAL?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			String genero = JOptionPane.showInputDialog(null,"¿GENERO?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			
			int v = JOptionPane.showConfirmDialog(null,"¿ESTA VIVO?", "CUESTIONARIO",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int mov = JOptionPane.showConfirmDialog(null,"¿PUEDE MOVERSE?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int c = JOptionPane.showConfirmDialog(null,"¿PUEDE COMER?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int d = JOptionPane.showConfirmDialog(null,"¿PUEDE DEFECAR?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String vivir ="",moverse=null,comer=null,defecar=null;
			
			if(v==0){vivir=Integer.toString(v); vivir="si";
			}else if(v==1){	vivir=Integer.toString(v);vivir="NO";}
			
			if(v==0){moverse=Integer.toString(mov); moverse="si";
			}else if(v==1){	moverse=Integer.toString(mov);moverse="NO";}
			
			if(v==0){comer=Integer.toString(c); comer="si";
			}else if(v==1){	comer=Integer.toString(c);comer="NO";}
			
			if(v==0){defecar=Integer.toString(d); defecar="si";
			}else if(v==1){	defecar=Integer.toString(d);defecar="NO"; }
			
			Aves a= new Aves(nombre,genero,vivir,moverse,comer,defecar);
			
			this.view = new JFrame();
			this.paintAll(getGraphics());
			this.label1 = new JLabel("NUEVA AVE");
			this.label1.setBounds(190, 50, 150, 50);
			this.view.add(label1);
			
			this.label2 = new JLabel("NOMBRE: "+nombre);
			this.label2.setBounds(190, 75, 200, 50);
			this.view.add(label2);
			
			this.label3 = new JLabel("GENERO: "+genero);
			this.label3.setBounds(190, 100, 225, 50);
			this.view.add(label3);
			
			this.label4 = new JLabel("ESTA VIVO: "+vivir);
			this.label4.setBounds(190, 125, 250, 50);
			this.view.add(label4);
			
			this.label5 = new JLabel("SE PUEDE MOVER: "+moverse);
			this.label5.setBounds(190, 150, 275, 50);
			this.view.add(label5);
			
			this.label6 = new JLabel("PUEDE COMER: "+comer);
			this.label6.setBounds(190, 175, 300, 50);
			this.view.add(label6);
			
			this.label7 = new JLabel("PUEDE DEFECAR: "+defecar);
			this.label7.setBounds(190, 200, 325, 50);
			this.view.add(label7);
			
			this.view.setSize(500, 500);
			this.view.setLayout(null);
			this.view.setVisible(true);
		}
		
		if(AN.isSelected()){
			String nombre = JOptionPane.showInputDialog(null,"¿NOMBRE DEL ANIMAL?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			String genero = JOptionPane.showInputDialog(null,"¿GENERO?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			
			int v = JOptionPane.showConfirmDialog(null,"¿ESTA VIVO?", "CUESTIONARIO",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int mov = JOptionPane.showConfirmDialog(null,"¿PUEDE MOVERSE?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int c = JOptionPane.showConfirmDialog(null,"¿PUEDE COMER?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int d = JOptionPane.showConfirmDialog(null,"¿PUEDE DEFECAR?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String vivir ="",moverse=null,comer=null,defecar=null;
			
			if(v==0){vivir=Integer.toString(v); vivir="si";
			}else if(v==1){	vivir=Integer.toString(v);vivir="NO";}
			
			if(v==0){moverse=Integer.toString(mov); moverse="si";
			}else if(v==1){	moverse=Integer.toString(mov);moverse="NO";}
			
			if(v==0){comer=Integer.toString(c); comer="si";
			}else if(v==1){	comer=Integer.toString(c);comer="NO";}
			
			if(v==0){defecar=Integer.toString(d); defecar="si";
			}else if(v==1){	defecar=Integer.toString(d);defecar="NO"; }
			
			Anfibios an = new Anfibios(nombre,genero,vivir,moverse,comer,defecar);
			
			this.view = new JFrame();
			this.paintAll(getGraphics());
			this.label1 = new JLabel("NUEVO ANFIBIO");
			this.label1.setBounds(190, 50, 150, 50);
			this.view.add(label1);
			
			this.label2 = new JLabel("NOMBRE: "+nombre);
			this.label2.setBounds(190, 75, 200, 50);
			this.view.add(label2);
			
			this.label3 = new JLabel("GENERO: "+genero);
			this.label3.setBounds(190, 100, 225, 50);
			this.view.add(label3);
			
			this.label4 = new JLabel("ESTA VIVO: "+vivir);
			this.label4.setBounds(190, 125, 250, 50);
			this.view.add(label4);
			
			this.label5 = new JLabel("SE PUEDE MOVER: "+moverse);
			this.label5.setBounds(190, 150, 275, 50);
			this.view.add(label5);
			
			this.label6 = new JLabel("PUEDE COMER: "+comer);
			this.label6.setBounds(190, 175, 300, 50);
			this.view.add(label6);
			
			this.label7 = new JLabel("PUEDE DEFECAR: "+defecar);
			this.label7.setBounds(190, 200, 325, 50);
			this.view.add(label7);
			
			this.view.setSize(500, 500);
			this.view.setLayout(null);
			this.view.setVisible(true);
		}
		
		if(R.isSelected()){
			String nombre = JOptionPane.showInputDialog(null,"¿NOMBRE DEL ANIMAL?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			String genero = JOptionPane.showInputDialog(null,"¿GENERO?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			
			int v = JOptionPane.showConfirmDialog(null,"¿ESTA VIVO?", "CUESTIONARIO",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int mov = JOptionPane.showConfirmDialog(null,"¿PUEDE MOVERSE?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int c = JOptionPane.showConfirmDialog(null,"¿PUEDE COMER?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int d = JOptionPane.showConfirmDialog(null,"¿PUEDE DEFECAR?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String vivir ="",moverse=null,comer=null,defecar=null;
			
			if(v==0){vivir=Integer.toString(v); vivir="si";
			}else if(v==1){	vivir=Integer.toString(v);vivir="NO";}
			
			if(v==0){moverse=Integer.toString(mov); moverse="si";
			}else if(v==1){	moverse=Integer.toString(mov);moverse="NO";}
			
			if(v==0){comer=Integer.toString(c); comer="si";
			}else if(v==1){	comer=Integer.toString(c);comer="NO";}
			
			if(v==0){defecar=Integer.toString(d); defecar="si";
			}else if(v==1){	defecar=Integer.toString(d);defecar="NO"; }
			
			Reptiles r=new Reptiles (nombre,genero,vivir,moverse,comer,defecar);
			
			this.view = new JFrame();
			this.paintAll(getGraphics());
			this.label1 = new JLabel("NUEVO REPTIL");
			this.label1.setBounds(190, 50, 150, 50);
			this.view.add(label1);
			
			this.label2 = new JLabel("NOMBRE: "+nombre);
			this.label2.setBounds(190, 75, 200, 50);
			this.view.add(label2);
			
			this.label3 = new JLabel("GENERO: "+genero);
			this.label3.setBounds(190, 100, 225, 50);
			this.view.add(label3);
			
			this.label4 = new JLabel("ESTA VIVO: "+vivir);
			this.label4.setBounds(190, 125, 250, 50);
			this.view.add(label4);
			
			this.label5 = new JLabel("SE PUEDE MOVER: "+moverse);
			this.label5.setBounds(190, 150, 275, 50);
			this.view.add(label5);
			
			this.label6 = new JLabel("PUEDE COMER: "+comer);
			this.label6.setBounds(190, 175, 300, 50);
			this.view.add(label6);
			
			this.label7 = new JLabel("PUEDE DEFECAR: "+defecar);
			this.label7.setBounds(190, 200, 325, 50);
			this.view.add(label7);
			
			this.view.setSize(500, 500);
			this.view.setLayout(null);
			this.view.setVisible(true);
		}
		
		if(P.isSelected()){
			String nombre = JOptionPane.showInputDialog(null,"¿NOMBRE DEL ANIMAL?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			String genero = JOptionPane.showInputDialog(null,"¿GENERO?", "CUESTIONARIO", JOptionPane.QUESTION_MESSAGE);
			
			int v = JOptionPane.showConfirmDialog(null,"¿ESTA VIVO?", "CUESTIONARIO",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int mov = JOptionPane.showConfirmDialog(null,"¿PUEDE MOVERSE?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int c = JOptionPane.showConfirmDialog(null,"¿PUEDE COMER?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int d = JOptionPane.showConfirmDialog(null,"¿PUEDE DEFECAR?", "CUESTIONARIO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String vivir ="",moverse=null,comer=null,defecar=null;
			
			if(v==0){vivir=Integer.toString(v); vivir="si";
			}else if(v==1){	vivir=Integer.toString(v);vivir="NO";}
			
			if(v==0){moverse=Integer.toString(mov); moverse="si";
			}else if(v==1){	moverse=Integer.toString(mov);moverse="NO";}
			
			if(v==0){comer=Integer.toString(c); comer="si";
			}else if(v==1){	comer=Integer.toString(c);comer="NO";}
			
			if(v==0){defecar=Integer.toString(d); defecar="si";
			}else if(v==1){	defecar=Integer.toString(d);defecar="NO"; }
			
			Peces p= new Peces(nombre,genero,vivir,moverse,comer,defecar);
			
			this.view = new JFrame();
			this.paintAll(getGraphics());
			this.label1 = new JLabel("NUEVO PES");
			this.label1.setBounds(190, 50, 150, 50);
			this.view.add(label1);
			
			this.label2 = new JLabel("NOMBRE: "+nombre);
			this.label2.setBounds(190, 75, 200, 50);
			this.view.add(label2);
			
			this.label3 = new JLabel("GENERO: "+genero);
			this.label3.setBounds(190, 100, 225, 50);
			this.view.add(label3);
			
			this.label4 = new JLabel("ESTA VIVO: "+vivir);
			this.label4.setBounds(190, 125, 250, 50);
			this.view.add(label4);
			
			this.label5 = new JLabel("SE PUEDE MOVER: "+moverse);
			this.label5.setBounds(190, 150, 275, 50);
			this.view.add(label5);
			
			this.label6 = new JLabel("PUEDE COMER: "+comer);
			this.label6.setBounds(190, 175, 300, 50);
			this.view.add(label6);
			
			this.label7 = new JLabel("PUEDE DEFECAR: "+defecar);
			this.label7.setBounds(190, 200, 325, 50);
			this.view.add(label7);
			
			this.view.setSize(500, 500);
			this.view.setLayout(null);
			this.view.setVisible(true);
		}
		
	}

	
	 JPanel getJPanel() {
		return this.panel;
	}
}
