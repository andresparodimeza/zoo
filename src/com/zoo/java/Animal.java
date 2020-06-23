package com.zoo.java;

public abstract class Animal {
	
	//MIS ATRIBUTOS
	protected String Nombre;
	protected String Genero;
	private String Vivir;
	private String Comer;
	private String Defecar;
	private String Moverse;
	public String VerseCuchi;
	
	//COSNTRUCTOR, CREANDO UN NUEVO ANIMAL
	public Animal(String nombre, String genero, String vivir,
			String moverse, String comer, String defecar){
		
		
		this.Nombre=nombre;
		this.Genero=genero;
		this.Comer= comer;
		this.Defecar=defecar;
		this.Vivir=vivir;
		this.Moverse= moverse;
		NomGen();
		Comer();
		Defecar();
		Vivir();
		Moverse();
	}
	
	public String NomGen(){return "NOMBRE:"+this.Nombre+"\t GENERO:"+this.Genero;}
	public String Comer(){return "PUEDO COMER: "+ this.Comer;}
	public String Defecar(){return "PUEDO DEFECAR: "+this.Defecar;}
	public String Vivir(){return "ESTOY VIVO: "+this.Vivir;}
	public String Moverse(){return "ME PUEDO MOVER: "+ this.Moverse;}
}
