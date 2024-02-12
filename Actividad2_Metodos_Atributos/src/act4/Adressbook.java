package act4;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Adressbook {
	private HashMap <String,String> contactos = new HashMap<>();
    private	String csvFile = "D:\\ProyectosTecmilenio\\Actividad2_Metodos_Atributos\\src\\act4\\datos.csv";
	
	public Adressbook() {
	}
	
	public void load() {
        String line = "";
        String cvsSplitBy = ",";
        
        contactos = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(cvsSplitBy);
                
                if (data.length >= 2) {
                    String key = data[0];
                    String value = data[1];
                    contactos.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
	}
	
	public void save() {
		
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (HashMap.Entry<String, String> entry : contactos.entrySet()) {
                writer.append(entry.getKey())
                      .append(',')
                      .append(entry.getValue())
                      .append('\n');
            }
            System.out.println("Datos guardados exitosamente en " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
	}
	
	public void list() {
		
        System.out.println("Contactos:");
        for (HashMap.Entry<String, String> entry : contactos.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        
	}
	
	public void create(String numero, String nombre) {
		
		contactos.put(numero, nombre);
		System.out.println("Se agrego el contacto: "+numero+", "+nombre);
	}
	
	public void delete(String clave) {
		String datoEliminado = contactos.remove(clave);
		
		if (datoEliminado != null) {
			System.out.println("Contacto eliminado con exito");
		} else {
			System.out.println("El contacto no existe");
		}
	}
	
	
}
