package evidenciaPartefinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Persitencia {
	private static	String csvpaciente = "D:\\ProyectosTecmilenio\\Actividad2_Metodos_Atributos\\src\\evidenciaPartefinal\\pacientes.csv";	
	private static	String csvdoctor = "D:\\ProyectosTecmilenio\\Actividad2_Metodos_Atributos\\src\\evidenciaPartefinal\\doctores.csv";	
	private static String csvcita = "D:\\ProyectosTecmilenio\\Actividad2_Metodos_Atributos\\src\\evidenciaPartefinal\\citas.csv";	
	
	public static ArrayList<Paciente> loadPaciente(){
    	ArrayList<Paciente> pacientes = new ArrayList<>();    
		
        try (BufferedReader br = new BufferedReader(new FileReader(csvpaciente))) {
            String line;
            while ((line = br.readLine()) != null) {          	
                String[] data = line.split(",");
                
                if (data.length == 2) {
                    String nomPaciente = data[0].trim();
                    int idPaciente = Integer.parseInt(data[1].trim());
                    pacientes.add(new Paciente(nomPaciente, idPaciente));
                    System.out.println("Nombre: " + nomPaciente + ", ID: " + idPaciente);
                    
                } else {
                    System.out.println("Error: La línea no tiene el formato esperado.");
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer el archivo CSV.");
        }
        return pacientes;
	}
	
	   public static void savePacientes(ArrayList<Paciente> pacientes) {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvpaciente))) {
	            for (Paciente paciente : pacientes) {
	                String line = paciente.getNomPaciente() + "," + paciente.getIdPaciente();
	                bw.write(line);
	                bw.newLine();
	            }
	            System.out.println("Datos de pacientes guardados en el archivo CSV.");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Error al guardar los datos de pacientes en el archivo CSV.");
	        }
	    }
	
	public static ArrayList<Doctor> loadDoctor() {
		ArrayList<Doctor> doctores = new ArrayList<>();    
		
		 try (BufferedReader br = new BufferedReader(new FileReader(csvdoctor))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                
	                if (data.length == 3) {
	                    int idDoctor = Integer.parseInt(data[0].trim());
	                    String nomDoctor = data[1].trim();
	                    String espDoctor = data[2].trim();
	                    doctores.add(new Doctor(idDoctor, nomDoctor, espDoctor));
	                 } else {
	                    System.out.println("Error: La línea no tiene el formato esperado.");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Error al leer el archivo CSV.");
	        }
		 return doctores;
	}
	
	public static void saveDoctores(ArrayList<Doctor> doctores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvdoctor))) {
            for (Doctor doctor : doctores) {
                String line = doctor.getIdDoctor() + "," + doctor.getNomDoctor() + "," + doctor.getEspDoctor();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Datos de doctores guardados en el archivo CSV.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de doctores en el archivo CSV.");
        }
    }
	
    public static ArrayList<Cita> loadcitas() {
    	ArrayList<Cita> citas = new ArrayList<>();    
		Paciente auxPaciente;
		Doctor auxDoctor;
    	
        try (BufferedReader br = new BufferedReader(new FileReader(csvcita))) {
            String line;
            
            while ((line = br.readLine()) != null) {            	
                String[] data = line.split(",");
                
                if (data.length == 6) {
                	String nomDoctor = data[0].trim();
                    int idDoctor = Integer.parseInt(data[1].trim());
                    String espDoctor = data[2].trim();
                    auxDoctor = new Doctor(idDoctor, nomDoctor, espDoctor);
                    
                    String nomPaciente = data[3].trim();
                    int idPaciente = Integer.parseInt(data[4].trim());
                    auxPaciente = new Paciente(nomPaciente, idPaciente);
                    String fecha = data[5].trim();
                    
                    citas.add(new Cita(auxDoctor, auxPaciente, fecha));
                     } else {
                    System.out.println("Error: La línea no tiene el formato esperado.");
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer el archivo CSV.");
            
        }
        return citas;
    }
    
    public static void saveCitas(ArrayList<Cita> citas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvcita))) {
            for (Cita cita : citas) {
                String line = cita.getDoctor().getNomDoctor() + "," +
                        cita.getDoctor().getIdDoctor() + "," +
                        cita.getDoctor().getEspDoctor() + "," + 
                        cita.getPaciente().getNomPaciente() + "," +
                        cita.getPaciente().getIdPaciente() + "," +
                        cita.getDate();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Datos de citas guardados en el archivo CSV.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de citas en el archivo CSV.");
        }
    }
    
    
}
