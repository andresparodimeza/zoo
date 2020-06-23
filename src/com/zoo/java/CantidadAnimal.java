package com.zoo.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class CantidadAnimal {

	//ATRIBUTOS
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	//CONSTRUCTOR
	public  CantidadAnimal(String texto){
		//CREAMOS EL PANEL DE OPCIONES
		this.panel = new JPanel();
		
		//LE COLOCAMOS UN TITULO
		this.label = new JLabel(texto);
		this.label.setBounds(190, 50, 150, 50);
		this.panel.add(label);
	
		
		
		//BOTON
		this.button = new JButton("NEXT");
		this.button.setBounds(375, 400, 100, 50);
				
		//ACCIOONES A REALIZAR EL BOTON
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ConexionSQL(); 	
			        }
			    });
				
		
		//AÑADIMOS LAS PREGUNTAS Y EL BOTON AL PANEL
		this.panel.add(button);
		
		this.panel.setSize(500, 500);
		this.panel.setLayout(null);
		this.panel.setVisible(true);

	}
	
	/*
	 * METODO PARA CONETAR A POSGRESQL
	 */
	public static void ConexionSQL(){
		String clave="2909..1999";
		try{
		//CLASE PARA USAR EL DRIVER
		Class.forName("org.postgresql.Driver");
		//RUTA DE BASE DE DATOS
		String url = "jdbc:postgresql://localhost:5432/Zoologico";
		//CONEXION A LA BASE DE DATOS
		Connection cn= DriverManager.getConnection(url, "postgres", clave);
		//TRAE LOS DATOS
		Statement st = cn.createStatement();
		//SELECCIONA LA TABLA
		String sql = "SELECT * FROM Mamiferos";
		ResultSet rs=st.executeQuery(sql);
		//LLAMA AL METODO
		listar(rs);
		}catch(ClassNotFoundException ex){	
			// TODO:handle exception
			System.out.print("Error en el Driver");
		}catch (SQLException e){
			// TODO:handle exception
			System.out.print(e.getMessage());
		}
	}
	
	
	/*
	 * METODO PARA LISTAR DATOS
	 */
	
	public static void listar(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stud
		System.out.print("\n");
		//SE ENCARGA DE RECORRER FILA POR FILA
		while(rs.next()){
			//MUESTRA lA 1 COLUMNA DE LA FILA
			System.out.println("NOMBRE: "+rs.getString(1)+"\t");
			//MUESTRA lA 2 COLUMNA DE LA FILA
			System.out.println("GENERO: "+rs.getString(2)+"\t");;
		}
	}
	

	public JPanel getJPanel() {
		return this.panel;
	}
}
