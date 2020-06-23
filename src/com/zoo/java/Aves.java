package com.zoo.java;

public class Aves extends Animal implements Vertebrados,Reproduccion,Comida{

	public Aves(String tipo, String genero, String caracteristica,
			String Vivir, String Comer, String Defecar) {
		super(tipo, genero, caracteristica, Vivir, Comer, Defecar);
		ave();
	}

	//CUALIDADES PROPIAS DE LAS AVES
		public void ave(){
			System.out.println("SOY UN AVE");
			System.out.println("TENGO PLUMAS");
			System.out.println("PUEDO VOLAR");
			System.out.println("PUEDO CANTAR");}
		
		
	//EL AVE PRESENTA CONLUMNA VERTEBRAL Y HUESOS
		public String vertebra() {return "TENGO VERTEBRAS";}
		
	//COMO EL AVE SE REPRODUCE
		public String oviparos() {return "SOY DE UN OVIPARO";}
		public String viviparos() {return "SOY UN VIVIPARO";}
		public String ovoviviparos() {return "SOY UN OVOVIVIPARO";}	
		
	//COMO ES LA ALIMENTACION DEL AVE
		public String herbivoros() {return "SOY HERBIVORO";}
		public String carnivoros() {return "SOY CARNIVORO";}
		public String omnivoros() {return "SOY OMNIVORO";}

}
