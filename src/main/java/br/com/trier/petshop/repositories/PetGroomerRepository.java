package br.com.trier.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trier.petshop.domain.PetGroomer;
import br.com.trier.petshop.domain.Speciality;

@Repository
public interface PetGroomerRepository extends JpaRepository<PetGroomer, Integer>{
	
	List<PetGroomer> findByName(String name);

	List<PetGroomer> findByNameStartingWithIgnoreCase(String name);

	List<PetGroomer> findBySpeciality(Speciality speciality);
}
