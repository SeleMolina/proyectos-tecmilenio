package act4;

import java.util.Scanner;

public class ApiAdressbook {
	
	
	public static void main(String[] args) {
		Adressbook agenda= new Adressbook();
		
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los datos de la agenda");
            System.out.println("2. Agregar un nuevo contacto");
            System.out.println("3. Eliminar un contacto");
            System.out.println("4. Cargar los contactos");
            System.out.println("5. Guardar los contactos");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: \n");
            String input = scanner.nextLine().trim(); // Lee la entrada del usuario y elimina los espacios en blanco alrededor
            
            if (input.isEmpty()) {
            	 System.out.println("Por favor, ingrese una opción del menú.");
                continue;
            }
            
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero como opción del menú.");
                opcion = 0;
                scanner.nextLine(); // Consumir la nueva línea
                continue;
            }

            switch (opcion) {
                case 1:
                    agenda.list();
                    break;
                    
                case 2:
                    System.out.print("Ingrese el numero Telefonico: ");
                    String numero = scanner.next();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.next();
                    agenda.create(numero, nombre);
                    break;
                    
                case 3:
                    System.out.print("Ingrese numero telefonico: ");
                    String numeliminar = scanner.next();
                    agenda.delete(numeliminar);
                    break;
                    
                case 4:
                    agenda.load();
                    break;
                    
                case 5:
                	agenda.save();
                    break;
                    
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 6);
        
        scanner.close();

	}
}
