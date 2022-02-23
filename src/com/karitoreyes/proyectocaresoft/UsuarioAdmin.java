package com.karitoreyes.proyectocaresoft;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPPA, AdminCompatibleConHIPPA {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    public UsuarioAdmin(Integer id, String role) {
    	super(id);
    	this.role = role;
    	this.securityIncidents = new ArrayList<String>();
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", 
            new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if(pin>99999) {
			this.setPin(pin);
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.getId()==confirmedAuthID) {
			return true;
		}
		authIncident();
		return false;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
}