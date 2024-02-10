package Actividad3SimDeck;

public class AplCartas {
	
	public static void main(String[] args) {
		//variables
		Deck mazo = new Deck();
		Carta AuxCarta;
		//metodos
		//mezclar
		System.out.println("El deck se mezclo");
		mazo.shuffle();
		
		//obtener la primer carta, head
		System.out.println("obtener la primer carta, head");
		AuxCarta = mazo.head();
		System.out.println("Palo: "+AuxCarta.getPalo()+", Color: "+AuxCarta.getColor()+", Valor:"+AuxCarta.getValor());
		System.out.println("Quedan:"+ mazo.cartasRestantes());
		
		//pick una carta al azar
		System.out.println("pick una carta al azar");
		AuxCarta = mazo.pick();
		System.out.println("Palo: "+AuxCarta.getPalo()+", Color: "+AuxCarta.getColor()+", Valor:"+AuxCarta.getValor());
		System.out.println("Quedan:"+ mazo.cartasRestantes());
		
		//hand obtener un mazo de 5 cartas
		System.out.println("hand obtener un mazo de 5 cartas");
		for (Carta carta : mazo.hand()) {
			System.out.println("Palo: "+carta.getPalo()+", Color: "+carta.getColor()+", Valor:"+carta.getValor());
		}
		System.out.println("Quedan:"+ mazo.cartasRestantes());
	}

}
