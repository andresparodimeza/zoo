package com.animal.java;

public abstract class Animal {
	
	//MIS ATRIBUTOS
	private String Nombre;
	private String Sonido;
	

	//COSNTRUCTOR, CREANDO UN NUEVO ANIMAL
	public Animal(){}
	
	
	public String getNombre(){return this.Nombre;}
	public void setNombre(String nombre){this.Nombre=nombre;}
	
	public String getSonido() {return Sonido;}
	public void setSonido(String sonido) {Sonido = sonido;}

	
	
	public String Vive(){return getNombre()+"  VIVO";}
	public String NoVive(){return getNombre()+" MUERTO";}
	
	public String Comer(){return getNombre()+" COME";}
	public String NoComer(){return getNombre()+"  NO COME";}
	
	public String Defeca(){return getNombre()+" DEFECA";}
	public String NoDefeca(){return getNombre()+"  NO DEFECA";}
	
	
	public abstract String sonido();
	
}
