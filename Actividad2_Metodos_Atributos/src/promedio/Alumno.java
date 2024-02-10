package promedio;


public class Alumno {
	String nombre;
	int[] calificaciones = new int[5];
	double promedio;
	char calificacion;
	
	public Alumno( String nombre, int[] calificaciones) {
		this.nombre = nombre;
		this.calificaciones = calificaciones;
	}
	
	public int[] getCalificaciones() {
		return calificaciones;
	}
	
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public void setCalificacion (char calificacion) {
		this.calificacion = calificacion;
	}
	
	public char getCalificacion () {
		return calificacion;
	}
	
	public double getPromedio () {
		return promedio;
	}
	
	public String getNombre() {
		return nombre;
	}
}
