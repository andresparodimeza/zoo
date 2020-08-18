package com.zoo.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;



public class  Zoologico implements Runnable {

	//ATRIBUTOS PARA LA CREACION DE LA VENTANA
	private JFrame view;
	private JButton button;
	private JLabel label;
	protected JRadioButton op1,op2,op3,op4;
	private ButtonGroup g;
	private JTextArea areatexto;
		
	//METODO CREADOR DE LA VENTANA
	public Zoologico(){	
		//TITULO DE LA VENTANA
		this.view = new JFrame();
		
		//TITULOS
		this.label = new JLabel("WELCOME TO MY ZOO");
		this.label.setBounds(225, 15, 150, 50);
		this.view.add(label);
		
		this.label = new JLabel("SERVER");
		this.label.setBounds(265, 30, 150, 50);
		this.view.add(label);
		
		this.label = new JLabel("ACCIONES LOCALES");
		this.label.setBounds(75,75, 150, 50);
		this.view.add(label);
		
		this.label = new JLabel("ACCIONES EXTERNAS");
		this.label.setBounds(350,75, 150, 50);
		this.view.add(label);
		
		//PANEL DE ACCIONES
		this.areatexto = new JTextArea();
		this.areatexto.setBounds(300,125, 225, 225);
		this.view.add(areatexto);
		
		
		//BOTONES DE OPCIONES
		g=new ButtonGroup();//GRUPO CREADO PARA QUE SOLO SE SELECCIONE UNA OPCION
		
		this.op1 = new JRadioButton("(1) Ingresar Nuevo Animal");
		this.op1.setBounds(50,125, 200,25); 
		
		this.op2 = new JRadioButton("(2) Cantidad de Animales");
		this.op2.setBounds(50,150, 200,25);
		
		this.op3 = new JRadioButton("(3) Moficar un Animal");
		this.op3.setBounds(50,175, 200,25); 
		
		this.op4 = new JRadioButton("(4) Eliminar un Animal");
		this.op4.setBounds(50,200, 200,25); 

		
		//AÑADIMOS LOS BOTONES AL GRUPO
		g.add(op1);
		g.add(op2);
		g.add(op3);
		g.add(op4);
		
		//BOTON
		this.button = new JButton("NEXT");
		this.button.setBounds(375,400,90,50);
		
		//ACCIOONES A REALIZAR EL BOTON
		this.button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	opciones();  	
	        }
	    });
		
		this.view.add(op1);
		this.view.add(op2);
		this.view.add(op3);
		this.view.add(op4);
		this.view.add(button);
		
		this.view.setSize(600,500);
		this.view.setLayout(null);
		this.view.setVisible(true);	
		
		Thread mihilo = new Thread(this);
		mihilo.start();
		
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
		
		if(op3.isSelected()){
			
			CantidadAnimal sw = new CantidadAnimal(op3.getText());
        	view.setContentPane(sw.getJPanel());
        	view.invalidate();
        	view.validate();}
		
		if(op4.isSelected()){
			
			EliminaAnimal sw = new EliminaAnimal(op4.getText());
        	view.setContentPane(sw.getJPanel());
        	view.invalidate();
        	view.validate();}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			//----EL SERVIDOR ESTA DISPUESTO A RECIBIR SIEMPRE
			ServerSocket servidor = new ServerSocket(2929);
			
			String name, mensaje, accion;
			Paquete paquete_recibido;
			
			
			
			while(true){
				
				/*---EL SOCKET ACEPTA TODAS
				LAS CONECCCIONES QUE LLEGAN AL SERVIDOR--*/
			
				Socket misocket=servidor.accept();	
					
				//----OBJETOCREADO PARA ALMACENAR EL OBJETO ENVIADO POR EL CLIENTE--------------------------------
				ObjectInputStream paquete_datos=new ObjectInputStream(misocket.getInputStream());		
				paquete_recibido=(Paquete) paquete_datos.readObject();
				
				//----ALMACENAMOS LOS DATOS DEL OBJETO RECIBIDO EN LAS VARIABLES----------------------------------
				name=paquete_recibido.getNick();
				mensaje=paquete_recibido.getMensaje();
				accion=paquete_recibido.getAccion();
				
				//----MOSTRAMOS LA INFIORMACION EN EL SERVIDOR----------------------------------------------------
				areatexto.append("\n"+name+": "+mensaje+"\n Realizar la accion #"+accion);
				
				int p= Integer.parseInt(accion);
				
				if(p==1){
				op1.setSelected(true);
				opciones();
		        	}else
		        		if(p==2){
		        		op2.setSelected(true);
		        		opciones();
				        	}else
				        		if(p==3){
				        		op3.setSelected(true);
				        		opciones();
						        	}else
						        		if(p==4){
						        		op4.setSelected(true);
						        		opciones();}
				
				
				//---CREAMOS EL PUENTE-----------------------------------------------------------------------------
				Socket enviaDestinatario=new Socket("127.0.0.1",9292);
				
				//---PAQUETE RECIBIDO DEL PRIMER CLIENTE PARA LLEVARLO AL DESTINO----------------------------------
				ObjectOutputStream paqueteReenvio =new ObjectOutputStream(enviaDestinatario.getOutputStream());
					
				//---ALMACENAMOS LA INFORMACION A REENVIAR---------------------------------------------------------
				paqueteReenvio.writeObject(paquete_recibido);
					
				paqueteReenvio.close();
				enviaDestinatario.close();
				misocket.close();   
			
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}
}