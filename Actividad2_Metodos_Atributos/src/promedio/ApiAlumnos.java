package promedio;

import java.util.Iterator;
import java.util.Scanner;

public class ApiAlumnos {

	public static void main(String[] args) {
		Alumno[] alumnos = new Alumno[3];
		//variables auxiliares
		Scanner sc = new Scanner(System.in);
		String nombre;
		int[] auxCal = new int[5];
		
		for (int i = 0; i < alumnos.length; i++) {
			System.out.println("");
			System.out.println("ingrese el nombre del alumno");
			nombre = sc.next();
			
			for (int j = 0; j < auxCal.length; j++) {
				System.out.println("ingrese la calificacion: "+j);
				auxCal[j] = sc.nextInt();
			}
			alumnos[i] = new Alumno(nombre, auxCal);
			
			alumnos[i].setPromedio(calculadora.calPromedio(alumnos[i].getCalificaciones()));;
			
			alumnos[i].setCalificacion(calculadora.calCalificacion(alumnos[i].getPromedio()));
		}
		
		for (int i = 0; i < alumnos.length; i++) {
			System.out.println("Nombre del estudiante: "+alumnos[i].getNombre());
			
				for (int j = 0; j < alumnos[i].calificaciones.length; j++) {
					
					System.out.println("Calificacion "+(j+1)+": "+ alumnos[i].calificaciones[j]);
				}
				
			System.out.println("Promedio: "+alumnos[i].getPromedio());
			System.out.println("Calificacion: "+alumnos[i].getCalificacion());
			
		}
		
	}

}
