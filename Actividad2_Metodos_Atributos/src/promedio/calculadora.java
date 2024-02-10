package promedio;

public class calculadora {
	
	public static double calPromedio(int[] calificaciones) {
		
		 int suma = 0;
	        for (int i = 0; i < calificaciones.length; i++) {
	            suma += calificaciones[i];
	        }
	        
	        double promedio = (double) suma / calificaciones.length;
		return promedio;
	}
	
	public static char calCalificacion(double promedio) {
		char calificacion = 'N';
		
		if (promedio <=0 ||promedio >100) {
            System.out.println("Promedio fuera de rango");
            return calificacion;
		}
        if (promedio <= 50) {
        	 calificacion = 'F';
        } else if (promedio <= 60) {
       	 		calificacion = 'E';
        } else if (promedio <= 70) {
        		calificacion = 'D';
        } else if (promedio <= 80) {
       	 calificacion = 'C';
        } else if (promedio <= 90) {
       	 calificacion = 'B';
        } else if (promedio <= 100) {
       	 calificacion = 'A';
        }
        return calificacion;
	}
}
