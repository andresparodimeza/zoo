package com.zoo.java;

public class Reptiles extends Animal implements Vertebrados,Reproduccion,Comida{

	public Reptiles(String tipo, String genero, String caracteristica,
			String Vivir, String Comer, String Defecar) {
		super(tipo, genero, caracteristica, Vivir, Comer, Defecar);
		reptil();
	}

	//CUALIDADES PROPIAS DE LOS REPTILES
			public void reptil(){
				System.out.println("SOY UN REPTIL");
				System.out.println("NO TENGO PELOS, NI PLUMAS, MAS BIEN PIEL ESCAMOSA");
				System.out.println("MIS DIENTES SON CONICOS");}
			
	//EL REPTIL PRESENTA CONLUMNA VERTEBRAL Y HUESOS
		public String vertebra() {return "-TENGO VERTEBRAS";}
		
	//COMO EL REPTIL SE REPRODUCE
		public String oviparos() {return "SOY DE UN OVIPARO";}
		public String viviparos() {return "SOY UN VIVIPARO";}
		public String ovoviviparos() {return "SOY UN OVOVIVIPARO";}	
		
	//COMO ES LA ALIMENTACION DEL REPTIL
		public String herbivoros() {return "SOY HERBIVORO";}
		public String carnivoros() {return "SOY CARNIVORO";}
		public String omnivoros() {return "SOY OMNIVORO";}

}
