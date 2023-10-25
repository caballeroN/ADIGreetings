package iesmb.godoycruz.ADI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import iesmb.godoycruz.ADI.entity.Persona;
import iesmb.godoycruz.ADI.repository.PersonaRepository;

import java.time.LocalDate;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaRepository personaRepository; 

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Método para agregar una nueva persona a la base de datos
    @PostMapping
    public Persona agregarPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    // Método para obtener una persona por su ID
    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    // Método para generar un saludo basado en el nombre de una persona
    @GetMapping("/saludo")
    public String generarSaludo(@RequestParam String nombre) {
    	// Recuperar la persona por nombre desde la base de datos
        Persona persona = personaRepository.findByNombre(nombre);

        if (persona == null) {
            return "No se encontró a la persona con el nombre proporcionado.";
        }

        // Calcular la edad a partir de la fecha de nacimiento
        int edad = calcularEdad(persona.getFechaNacimiento());

        // Generar el mensaje de saludo
        String mensaje = "¡Hola, " + nombre + "! Tienes " + edad + " años.";
        

        return mensaje;
    }
    
    private int calcularEdad(LocalDate fechaNacimiento) {
        // Implementar el cálculo de la edad a partir de la fecha de nacimiento
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        return edad;
    }
}
