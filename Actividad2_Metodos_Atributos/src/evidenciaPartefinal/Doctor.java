package evidenciaPartefinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Doctor {
	private int idDoctor;
	private String nomDoctor;
	private String espDoctor;
	
	public Doctor(int idDoctor, String nomDoctor, String espDoctor) {
		this.idDoctor = idDoctor;
		this.nomDoctor = nomDoctor;
		this.espDoctor = espDoctor;
		
	}
	
	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNomDoctor() {
		return nomDoctor;
	}

	public void setNomDoctor(String nomDoctor) {
		this.nomDoctor = nomDoctor;
	}

	public String getEspDoctor() {
		return espDoctor;
	}

	public void setEspDoctor(String espDoctor) {
		this.espDoctor = espDoctor;
	}
}
