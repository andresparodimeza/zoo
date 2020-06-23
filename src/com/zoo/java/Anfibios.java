package com.zoo.java;

public class Anfibios extends Animal implements Invertebrados,Reproduccion,Comida{

	public Anfibios(String tipo, String genero, String caracteristica,
			String Vivir, String Comer, String Defecar) {
		super(tipo, genero, caracteristica, Vivir, Comer, Defecar);
		anfibio();
	}
	
	//CUALIDADES PROPIAS DE LOS ANFIBIOS
	public void anfibio(){
		System.out.println("SOY UN ANFIBIO");
		System.out.println("TENGO PIEL PERMEABLE");
		System.out.println("SOY HECTOTERMO");}
	
	//EL AMFIBIO PRESENTA CONLUMNA VERTEBRAL Y HUESOS
		public String vertebra() {return "-TENGO VERTEBRAS";}
		public String noVertebra() {return "NO TENGO VERTEBRAS";}
		
	//COMO EL AMFIBIO SE REPRODUCE
		public String oviparos() {return "SOY DE UN OVIPARO";}
		public String viviparos() {return "SOY UN VIVIPARO";}
		public String ovoviviparos() {return "SOY UN OVOVIVIPARO";}	
		
	//COMO ES LA ALIMENTACION DEL AMFIBIO
		public String herbivoros() {return "SOY HERBIVORO";}
		public String carnivoros() {return "SOY CARNIVORO";}
		public String omnivoros() {return "SOY OMNIVORO";}

}
