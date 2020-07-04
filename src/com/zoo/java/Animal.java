package com.zoo.java;

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
	public String NoVive(){return getNombre()+" ESTA MUERTO";}
	
	public String Comer(){return getNombre()+"  PUEDE COMER";}
	public String NoComer(){return getNombre()+"  NO PUEDE COMER";}
	
	public String Defeca(){return getNombre()+"  PUEDE DEFECAR";}
	public String NoDefeca(){return getNombre()+"  NO PUEDE DEFECAR";}
	
	
	public abstract String sonido();
	
}
