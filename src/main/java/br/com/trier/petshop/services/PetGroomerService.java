package br.com.trier.petshop.services;

import java.util.List;

import br.com.trier.petshop.domain.PetGroomer;
import br.com.trier.petshop.domain.Speciality;


public interface PetGroomerService {
	PetGroomer save(PetGroomer groomer);

	PetGroomer update(PetGroomer groomer);

	PetGroomer findById(Integer id);

	List<PetGroomer> listAll();

	List<PetGroomer> findByName(String name);

	List<PetGroomer> findByNameStartingWithIgnoreCase(String name);

	List<PetGroomer> findBySpeciality(Speciality speciality);

	void delete(Integer id);

}
