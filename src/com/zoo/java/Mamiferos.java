package com.zoo.java;

public class Mamiferos extends Animal implements Vertebrados,Reproduccion,Comida{

	
//CONSTRUCTOR DE UN MAMIFERO
	public Mamiferos(String nombre, String genero, String Vivir,String Moverse, String Comer,
			String Defecar) {
		super(nombre, genero, Vivir, Moverse, Comer, Defecar);
		
		mamifero();
	}

//CUALIDADES PROPIAS DE LOS MAMIFEROS
	public String mamifero(){
		return "SOY MAMIFERO";}
	
	
	
//EL MAMIMEFO PRESENTA CONLUMNA VERTEBRAL Y HUESOS
	public String vertebra() {return "TENGO VERTEBRAS";}
	
//COMO EL MAMIFERO SE REPRODUCE
	public String oviparos() {return "SOY DE UN OVIPARO";}
	public String viviparos() {return "SOY UN VIVIPARO";}
	public String ovoviviparos() {return "SOY UN OVOVIVIPARO";}	
	
//COMO ES LA ALIMENTACION DEL MAMIFERO
	public String herbivoros() {return "SOY HERBIVORO";}
	public String carnivoros() {return "SOY CARNIVORO";}
	public String omnivoros() {return "SOY OMNIVORO";}

	
}
