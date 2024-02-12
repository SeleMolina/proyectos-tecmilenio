package evidenciaPartefinal;

import java.util.ArrayList;
import java.util.Scanner;

public class AplCitas {
		private static ArrayList<Doctor> doctores = new ArrayList<>();
		private static ArrayList<Paciente> pacientes = new ArrayList<>();    
		private static ArrayList<Cita> citas = new ArrayList<>();  
	public static void main(String[] args) {
 
		
		//cargar metodos
		
		doctores = Persitencia.loadDoctor();
		pacientes = Persitencia.loadPaciente();
		citas = Persitencia.loadcitas();

        // Menú
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Dar de alta a un doctor");
            System.out.println("2. Dar de alta a un paciente");
            System.out.println("3. Crear una cita");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    darDeAltaDoctor(scanner);
                    break;
                case 2:
                    darDeAltaPaciente(scanner);
                    break;
                case 3:
                    crearCita(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);

        // Guardar los datos actualizados en la persistencia
        guardarDatos();
    }

 // Método para guardar los datos en la persistencia
    private static void guardarDatos() {
        //Persitencia.save(pacientes, doctores, citas);
        Persitencia.saveDoctores(doctores);
        Persitencia.savePacientes(pacientes);
        Persitencia.saveCitas(citas);
    }

    // Método para dar de alta a un doctor
    private static void darDeAltaDoctor(Scanner scanner) {
        System.out.println("Ingrese el ID del doctor:");
        int idDoctor = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        System.out.println("Ingrese el nombre del doctor:");
        String nomDoctor = scanner.nextLine();

        System.out.println("Ingrese la especialidad del doctor:");
        String espDoctor = scanner.nextLine();

        Doctor doctor = new Doctor(idDoctor, nomDoctor, espDoctor);
        doctores.add(doctor);
        
        System.out.println("Doctor registrado con exito");
    }

    // Método para dar de alta a un paciente
    private static void darDeAltaPaciente(Scanner scanner) {
        System.out.println("Ingrese el nombre del paciente:");
        String nomPaciente = scanner.nextLine();

        System.out.println("Ingrese el ID del paciente:");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        Paciente paciente = new Paciente(nomPaciente, idPaciente);
        pacientes.add(paciente);
        
        System.out.println("paciente registrado con exito");
        
    }

    // Método para crear una cita
    private static void crearCita(Scanner scanner) {
        System.out.println("Ingrese el ID del doctor:");
        int idDoctor = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()
        
        boolean flag = false;
        Doctor auxDoctor = null;
        for (Doctor doctor : doctores) {
			if (doctor.getIdDoctor() == idDoctor) {
				auxDoctor = doctor;
				flag = true;
				break;
			}
		}
        if (!flag) {
			System.out.println("Doctor no encontrado");
			return;
		}


        System.out.println("Ingrese el ID del paciente:");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        flag = false;
        Paciente auxPaciente = null;
        for (Paciente paciente : pacientes) {
			if (paciente.getIdPaciente() == idPaciente) {
				auxPaciente = paciente;
				flag = true;
				break;
			}
		}
        if (!flag) {
			System.out.println("Paciente no encontrado");
			return;
		}

        System.out.println("Ingrese la fecha de la cita:");
        String fecha = scanner.nextLine();

        Cita cita = new Cita(auxDoctor, auxPaciente, fecha);
        citas.add(cita);
        
        System.out.println("Cita registrada con exito");
        
    }	
}
