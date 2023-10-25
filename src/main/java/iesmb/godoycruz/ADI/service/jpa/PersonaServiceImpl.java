package iesmb.godoycruz.ADI.service.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import iesmb.godoycruz.ADI.entity.Persona;
import iesmb.godoycruz.ADI.repository.PersonaRepository;
import iesmb.godoycruz.ADI.service.IPersonaService;

public class PersonaServiceImpl implements IPersonaService{
	 private final PersonaRepository personaRepository;

	    @Autowired
	    public PersonaServiceImpl(PersonaRepository personaRepository) {
	        this.personaRepository = personaRepository;
	    }

	    @Override
	    public Persona agregarPersona(Persona persona) {
	        // Aquí puedes realizar validaciones y lógica adicional antes de guardar la persona en la base de datos.
	        return personaRepository.save(persona);
	    }

	    @Override
	    public Persona obtenerPersonaPorId(Long id) {
	        return personaRepository.findById(id).orElse(null);
	    }

	    @Override
	    public String generarSaludo(String nombre) {
	        Persona persona = personaRepository.findByNombre(nombre);

	        if (persona == null) {
	            return "No se encontró a la persona con el nombre proporcionado.";
	        }

	        int edad = calcularEdad(persona.getFechaNacimiento());

	        String mensaje = "¡Hola, " + nombre + "! Tienes " + edad + " años.";

	        return mensaje;
	    }

	    private int calcularEdad(LocalDate fechaNacimiento) {
	        LocalDate fechaActual = LocalDate.now();
	        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
	        return edad;
	    }
}
