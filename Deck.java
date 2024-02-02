package Actividad3SimDeck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Carta> Cartas;
	
	public Deck() {
		Cartas = new ArrayList<Carta>();
		crearCartas(Cartas);
		
		//debug
		System.out.println(Cartas.size());
		for (Carta carta : Cartas) {
			System.out.println("Palo: "+carta.getPalo()+" Color: "+carta.getColor()+" Valor: "+ carta.getValor());
		}
	}
	
	private void crearCartas(ArrayList<Carta> Cartas) {

		int contPalo = 0;
		Carta cartaAux = new Carta("","",0);

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 13; j++) {
				switch (contPalo) {
				case 0:
					//picas y negro
					cartaAux = new Carta("Picas","Negro", (j+1));
					break;
				case 1:
					//corazones y rojo
					cartaAux = new Carta("Corazones","Rojo", (j+1));
					break;
				case 2:
					//diamantes y rojo
					cartaAux = new Carta("Diamantes","Rojo", (j+1));
					break;
				case 3:
					//treboles y negro
					cartaAux = new Carta("Treboles","Negro", (j+1));
					break;

				default:
					break;
				}
				Cartas.add(cartaAux);
			}
			contPalo++;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(Cartas);
	}
	
	public Carta head() {
		Carta cartaAux = Cartas.get(0);
		Cartas.remove(0);
		
		return cartaAux;
	}
	
	public Carta pick() {
		Random random = new Random();
		int cartAzar = random.nextInt(Cartas.size());
		Carta cartaAux = Cartas.get(cartAzar);
		Cartas.remove(cartAzar);
		
		return cartaAux;
	}
	
	public Carta[] hand() {
		Carta[] mano = new Carta[5];
		
		for (int i = 0; i < mano.length; i++) {
			mano[i] = pick();
		}
		return mano;
	}
	
	public int cartasRestantes() {
		return Cartas.size();
	}
	
}
