package Actividad3SimDeck;

public class Carta {
	private String palo;
	private String color;
	private String valor;
	
	public Carta(String palo, String color, int valor) {
		this.palo = palo;
		this.color = color;
		this.valor = calValor(valor);
		
	}
	
	private String calValor(int valor) {
		String val;

		switch (valor) {
		case 1:
			//As
			val = "A";
			break;
			
		case 11:
			//j
			val = "J";
			break;
			
		case 12:
			//dama
			val = "Q";
			break;
			
		case 13:
			//rey
			val = "K";
			break;

		default:
			val = Integer.toString(valor);
			break;
		}
		return val;
	}

	public String getPalo() {
		return palo;
	}

	public String getColor() {
		return color;
	}

	public String getValor() {
		return valor;
	}
	
}
