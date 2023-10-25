package iesmb.godoycruz.ADI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iesmb.godoycruz.ADI.entity.Persona;

public interface PersonaRepository extends JpaRepository <Persona, Long>{

	Persona findByNombre(String nombre);
}
