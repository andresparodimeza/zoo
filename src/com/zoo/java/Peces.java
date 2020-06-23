package com.zoo.java;

public class Peces extends Animal implements Invertebrados,Reproduccion,Comida{

	public Peces(String tipo, String genero, String caracteristica,
			String Vivir, String Comer, String Defecar) {
		super(tipo, genero, caracteristica, Vivir, Comer, Defecar);
		pes();
	}

	//CUALIDADES PROPIAS DE LOS PECES
			public void pes(){
				System.out.println("SOY UN PES");
				System.out.println("TENGO ESCAMAS");
				System.out.println("TENGO BRANQUIAS");
				System.out.println("SOY HIDRODINAMICO");
				System.out.println("SOY HETEROTERMO");}
			
	//EL PES PRESENTA CONLUMNA VERTEBRAL Y HUESOS
		public String vertebra() {return "TENGO VERTEBRAS";}
		public String noVertebra() {return "NO TENGO VERTEBRAS";}
		
	//COMO EL PES SE REPRODUCE
		public String oviparos() {return "SOY DE UN OVIPARO";}
		public String viviparos() {return "SOY UN VIVIPARO";}
		public String ovoviviparos() {return "SOY UN OVOVIVIPARO";}	
		
	//COMO ES LA ALIMENTACION DEL PES
		public String herbivoros() {return "SOY HERBIVORO";}
		public String carnivoros() {return "SOY CARNIVORO";}
		public String omnivoros() {return "SOY OMNIVORO";}


}
