package iesmb.godoycruz.ADI.service;

import iesmb.godoycruz.ADI.entity.Persona;

public interface IPersonaService {
	Persona agregarPersona(Persona persona);
    Persona obtenerPersonaPorId(Long id);
    String generarSaludo(String nombre);
}
