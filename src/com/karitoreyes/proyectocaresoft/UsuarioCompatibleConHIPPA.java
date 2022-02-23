package com.karitoreyes.proyectocaresoft;

public interface UsuarioCompatibleConHIPPA {
	abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}