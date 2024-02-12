package evidenciaPartefinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Paciente {
	//ruta del archivo csv
	
	private String nomPaciente;
	private int idPaciente;
	
	public Paciente(String nomPaciente, int idPaciente) {		
		this.nomPaciente = nomPaciente;
		this.idPaciente = idPaciente;
		
	}
    
	public String getNomPaciente() {
		return nomPaciente;
	}

	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
}
