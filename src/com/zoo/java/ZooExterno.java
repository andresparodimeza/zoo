package com.zoo.java;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ZooExterno {

	public static void main(String[]args){
		//TODO Auto-generated method stub
		new Marco();
	}

}


 class Marco  implements Runnable {
	 
	private JFrame view;
	private JTextField text;
	private JTextArea chat;
	private JLabel label,labelname;
	private JButton miboton;
	private JRadioButton button1,button2,button3,button4;
	private ButtonGroup g;
	
	
	 public Marco(){
		this.view = new JFrame();
		
		//------------PANEL PARA PEDIR TU USUARIO
		String nick_usuario=JOptionPane.showInputDialog("NOMBRE DE ZOOLOGICO:");
		
		//------------HACE APARECER EN PANTALLA (( NICK:___ ))--------------------
		this.label = new JLabel("Name:");
		this.label.setBounds(15,15,50,20);
		this.view.add(label);
		
		//------------MUESTRA EN PANTALLA (( NICK: [ NICK_USUARIO ] ))------------
		this.labelname = new JLabel ();
		this.labelname.setText(nick_usuario);
		this.labelname.setBounds(55,15,80,20);
		this.view.add (labelname);
		
		//-------------MUESTRA EN PANTALLA ((ONLINE))-----------------------------
		this.label=new JLabel(" Online ZOO.SERV");
		this.label.setBounds(160,15,150,20);
		this.view.add(label);
		
		//-------------CAMPO PARA MOSTRAR MENSAJES--------------------------------
		this.chat = new JTextArea(12,22);
		this.chat.setBounds(15,40,255,260);
		this.view.add(chat);
			
		//-------------MUESTRA EN PANTALLA ((NOMBRE DEL ANIMAL))------------------	
		this.label=new JLabel("------------------------------------------------------");
		this.label.setBounds(35,370,255,20);
		this.view.add(label);
							
		//-------------MUESTRA EN PANTALLA ((NOMBRE DEL ANIMAL))-------------	
		this.label=new JLabel("NOMBRE DEL ANIMAL");
		this.label.setBounds(70,390,150,20);
		this.view.add(label);
				
		//-------------CAMPO PARA ESCRIBIR MSJ-------------------------------
		this.text=new JTextField();
		this.text.setBounds(15,410,255,30);
		this.view.add(text);
		
		//-------------BOTONES PARA LAS ACCIONES-----------------------------
		g = new ButtonGroup();
		this.button1 =new JRadioButton("AGG ANIMAL");
		this.button1.setBounds(13,310,130,30);
		this.view.add(button1);
		g.add(button1);
		
		this.button2=new JRadioButton("CANT.ANIMALS");
		this.button2.setBounds(145,310,130,30);
		this.view.add(button2);
		g.add(button2);
		
		this.button3=new JRadioButton("MODIFIC ANIMAL");
		this.button3.setBounds(13,350,130,30);
		this.view.add(button3);
		g.add(button3);
		
		this.button4=new JRadioButton("ELIMINA ANIMAL");
		this.button4.setBounds(145,350,130,30);
		this.view.add(button4);
		g.add(button4);
		
		//-------------BOTON PARA ENVIAR MENSAJE----------------------------------
		this.miboton=new JButton("Enviar");
		this.miboton.setBounds(80,475,130,50);
		EnviaTexto evento=new EnviaTexto();
		this.miboton.addActionListener(evento);
		this.view.add(miboton);
		
	
		this.view.setSize(300,600);
		this.view.setLayout(null);
		this.view.setVisible(true);	
	
			
			/*-----SE EJECUTA EL METODO WINDOW OPENED 
			Y SE ESTABLECEUN SOCKET CON EL SERVIDOR*/
			this.view.addWindowListener(new EnvioOnline());	
			
			/*---PONEMOS EN FUNCIONAMIENTO EL HILO PARA QUE 
			SE EJECUTE NE SEGUNDO PLANO*/
			Thread hilo=new Thread(this);
			hilo.start();
			
	 		}
	  
	 
	 private class EnviaTexto implements ActionListener{
		 
		 	 
			//AGREGA TU MENSAJE A LA PANTALLA DE CHAT
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if(button1.isSelected()){ chat.append("\n YO:"+button1.getText()); }
				else 
					if(button2.isSelected()){chat.append("\n YO:"+button2.getText());}
					else 
						if(button3.isSelected()){chat.append("\n YO:"+button3.getText());}
						else 
							if(button4.isSelected()){chat.append("\n YO:"+button4.getText());}
								else 
									{JOptionPane.showMessageDialog(null,"***ERROR, SELECIONE UN ACCION***","ERROR",JOptionPane.ERROR_MESSAGE); }
				
				
				
				try {
					//APERTURA DE PUENTE PARA EL ENVIO DE PAQUETES	
					Socket misocket=new Socket("127.0.0.1",2929);
						
					
					//-----CREAMOS UN OBJETO QUE ENVIAREMOS---------
						Paquete datos=new Paquete();
					//---ATRIBUTOS DEL PAQUETE----
						datos.setNick(labelname.getText());
						datos.setMensaje(text.getText());

						if(button1.isSelected()){ datos.setAccion("1"); }
						else 
							if(button2.isSelected()){ datos.setAccion("2");}
							else 
								if(button3.isSelected()){datos.setAccion("3");}
								else 
									datos.setAccion("4");
				
					
					//FLUJO DE DATOS PARA ENVIAR EL OBJETO AL DESTINO
					ObjectOutputStream paquete_datos= new ObjectOutputStream(misocket.getOutputStream());
					paquete_datos.writeObject(datos);
					misocket.close();
						
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			
		}
		
	 
		@Override
		public void run() {
		// TODO Auto-generated method stub
						
		try{
			
			//-----COLOCAMOS AL CLIENTE DISPUESTO A RECIBIR 
			ServerSocket servidor_cliente= new ServerSocket(9292);
			
			//----CANAL PARA RECIBIR EL PAQUETE
			Socket entradac;
			Paquete paqueteRecibido;
			
			
			//----BUCLE INFINITO PARA QUE ESTE SIEMPRE RECIBIENDO
			while(true){
				
				 //--ACEPTA TODAS LAS CONECCIONES
					entradac=servidor_cliente.accept();
				
				//---CREAMOS EL FLUJO DE DATOS DE ENTRADA CAPAZ DE TRANSPORTAR OBJETOS
					ObjectInputStream flujoentrada = new ObjectInputStream (entradac.getInputStream());
				
				//----LEER LO QUE LLEGA POR EL FLUJO DE ENTRADA
					paqueteRecibido=(Paquete) flujoentrada.readObject();
				
					chat.append("\n"+paqueteRecibido.getNick()+"\n"+paqueteRecibido.getMensaje()+"\n"+paqueteRecibido.getAccion());
				
				}
			
			}catch(Exception e){System.out.println(e.getMessage());}
			
			
		} 
 
 }
 

 
 /*CLASE ADAPTADORA: AQUELLA QUE IMPLEMENTA 
 TOOS LOS METODOS PERTENECIENTES A UNA INTERFACE (WINDOW LISTENER)*/ 
 
 //-----------------------ENVIO SEÑAL ONLINE----------------------------------
 class EnvioOnline extends WindowAdapter{
	 
	 //------METODO WINDOW OPENED PARA QUE LA ACCION SE EJECUTE AL ABRIR LA VENTANA
	 public void windowOpened(WindowEvent e){
		 
		 try{
			 //--------SOCKET CON LA DIRECCION IP Y PUERTO DEL SERVIDOR
			 Socket misocket = new Socket("192.162.42.85",2909);
			 
			 //---PAQUETE QUE RECIBIRA EL SERVIDOR
			 Paquete datos=new Paquete();
			 datos.setMensaje(" online");
			 
			 //----FLUJO DE DATOS PARA ENVIAR EL OBJETO A TRAVES DEL SOCKET
			 ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream());
			 paquete_datos.writeObject(datos);
			 
			 misocket.close();
		 
		 }catch (Exception e2){}	 
	 } 
}
 


class Paquete implements Serializable{
	
	private String nombre , mensaje, accion;
		
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getNick() {
		return nombre;
	}

	public void setNick(String nick) {
		this.nombre = nick;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}


