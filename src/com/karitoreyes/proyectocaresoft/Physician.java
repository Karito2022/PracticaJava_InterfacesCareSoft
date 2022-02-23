package com.karitoreyes.proyectocaresoft;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends Usuario implements UsuarioCompatibleConHIPPA{

	private ArrayList<String> patientNotes;
	public Physician(int id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
	}
	
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}


	@Override
	public boolean assignPin(int pin) {
		if(pin>999) {
			this.setPin(pin);;
			return true;
		}
		return false;
	}


	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.getId() == confirmedAuthID) {
			return true;
		}
		return false;
	}
	
}