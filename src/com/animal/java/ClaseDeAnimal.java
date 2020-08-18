package com.animal.java;


public class ClaseDeAnimal extends Animal implements Vertebrados,Reproduccion,Comida{

	
//CONSTRUCTOR DE UN MAMIFERO
public ClaseDeAnimal() {}

	//CUALIDADES PROPIAS DEL ANIMAL
	public String mamifero(boolean b){
		return "mamifero";}
	public String ave(boolean b){
		return "ave";}
	public String anfibio(boolean b){
		return "anfibio";}
	public String reptil(boolean b){
		return "reptil";}
	public String pes(boolean b){
		return "pes";}
	
//EL MAMIMEFO PRESENTA CONLUMNA VERTEBRAL Y HUESOS
	public String vertebra() {return "TENGO VERTEBRA";}
	public String NoVertebra() {return " NO TENGO VERTEBRA";}
	
//COMO EL MAMIFERO SE REPRODUCE
	public String oviparos() {return " OVIPARA";}
	public String viviparos() {return " VIVIPARA";}
	public String ovoviviparos() {return " OVOVIVIPARA";}	
	
//COMO ES LA ALIMENTACION DEL MAMIFERO
	public String herbivoros() {return " HERBIVORA";}
	public String carnivoros() {return " CARNIVORA";}
	public String omnivoros() {return " OMNIVORA";}


	@Override
	public String sonido() {
		return getSonido();
	}
}
