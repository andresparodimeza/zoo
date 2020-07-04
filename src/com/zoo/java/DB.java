package com.zoo.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private static DB DB = new DB();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driverDB = "org.postgresql.Driver";
	private String dbName= "Zoologico";
	private String urlDB = "jdbc:postgresql://localhost:5432/"+this.dbName;
	private String userDB = "postgres";
	private String passDB = "2909..1999";
	
	private DB(){
		try {
			Class.forName(driverDB); //REGISTRO DEL DRIVER
			this.conn = DriverManager.getConnection(urlDB, userDB, passDB);//ESTABLECER LA CONEXXION CON LA BASE DE DATOS
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	
	public static DB getInstances(){
		return DB;
	}
	
	
	
	
	public ResultSet dbStatement(String query){
		try{
			this.stmt=this.conn.createStatement();
			this.rs=this.stmt.executeQuery(query);
			
			System.out.println("NOMBRE \t GENERO \t\t\t ALIMENTACION"
					+"\t REPRODUCCION \t TIENE VERTEBRAS");
			
			while(rs.next()){
				rs.getString("nombre");
				rs.getString("genero");
				rs.getString("vive");
				rs.getString("reproduccion");
				rs.getString("come");
				rs.getString("tipo_de_alimentacion");
				rs.getString("tiene_vertebras");
				rs.getString("puede_defecar");
				rs.getString("hace_algun_sonido");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				this.stmt.close();
				this.rs.close();
			}catch (SQLException e){
				e.printStackTrace();
			}	
		}	
		return rs;
	}
	
	

	
	
	public void dbPrepareStatement (String query, Object[] obj){
		try{
			this.pstmt= this.conn.prepareStatement(query);
			this.pstmt.setString(1, (String) obj[1]);
			this.pstmt.setString(2, (String) obj[2]);
			this.pstmt.setString(3, (String) obj[3]);
			this.pstmt.setString(4, (String) obj[4]);
			this.pstmt.setString(5, (String) obj[5]);
			this.pstmt.setString(6, (String) obj[6]);
			this.pstmt.setString(7, (String) obj[7]);
			this.pstmt.setString(8, (String) obj[8]);
			this.pstmt.setString(9, (String) obj[9]);
			this.pstmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				this.pstmt.close();
			}catch (SQLException e){
			 e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public void dbClose(){
		try{
			this.conn.close();
			System.out.println("C Error");
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
		
