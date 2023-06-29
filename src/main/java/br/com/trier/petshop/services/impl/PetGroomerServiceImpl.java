package br.com.trier.petshop.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trier.petshop.domain.PetGroomer;
import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.repositories.PetGroomerRepository;
import br.com.trier.petshop.services.PetGroomerService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

@Service
public class PetGroomerServiceImpl implements PetGroomerService{
	
	@Autowired
	PetGroomerRepository repository;
	
	private void petGroomerValidation(PetGroomer obj){
        if (obj == null) {
            throw new IntegrityViolation("O Pet Groomer não pode ser nula!");
        }
        if (obj.getSpeciality() == null) {
            throw new IntegrityViolation("A especialidade não pode ser nula!");
        }
        if (obj.getName() == null) {
            throw new IntegrityViolation("O nome do Pet Groomer não pode ser nulo!");
        }
        if (obj.getFone() == null) {
            throw new IntegrityViolation("O fone do Pet Groomer não pode ser nulo!");
        }
    }

	@Override
	public PetGroomer save(PetGroomer groomer) {
		petGroomerValidation(groomer);
		return repository.save(groomer);
	}

	@Override
	public PetGroomer update(PetGroomer groomer) {
		petGroomerValidation(groomer);
		return repository.save(groomer);
	}

	@Override
	public PetGroomer findById(Integer id) {
		Optional<PetGroomer> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhum pet groomer encontrado com esse id %s".formatted(id)));
    }

	@Override
	public List<PetGroomer> listAll() {
		return repository.findAll();
	}

	@Override
	public List<PetGroomer> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<PetGroomer> findByNameStartingWithIgnoreCase(String name) {
		return repository.findByNameStartingWithIgnoreCase(name);
	}

	@Override
	public List<PetGroomer> findBySpeciality(Speciality speciality) {
		return repository.findBySpeciality(speciality);
	}

	@Override
	public void delete(Integer id) {
		PetGroomer petGroomer = findById(id);
		repository.delete(petGroomer);	
	}
}
