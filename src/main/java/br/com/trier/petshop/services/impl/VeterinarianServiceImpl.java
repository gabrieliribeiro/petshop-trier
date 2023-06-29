package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.domain.Species;
import br.com.trier.petshop.domain.Veterinarian;
import br.com.trier.petshop.repositories.VeterinarinRepository;
import br.com.trier.petshop.services.VeterinarianService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianServiceImpl implements VeterinarianService {

    @Autowired
    VeterinarinRepository repository;

    private void veterinarianValidation(Veterinarian obj){
        if (obj == null) {
            throw new IntegrityViolation("O veterinário não pode ser nula!");
        }
        if (obj.getCrm() == null) {
            throw new IntegrityViolation("O CRM não pode ser nulo!");
        }
        if (obj.getSpeciality() == null) {
            throw new IntegrityViolation("A especialidade não pode ser nula!");
        }
        if (obj.getName() == null) {
            throw new IntegrityViolation("O nome do veterinário não pode ser nulo!");
        }
        if (obj.getFone() == null) {
            throw new IntegrityViolation("O fone do veterinário não pode ser nulo!");
        }
    }

    @Override
    public Veterinarian save(Veterinarian veterinarian) {
        veterinarianValidation(veterinarian);
        return repository.save(veterinarian);
    }

    @Override
    public Veterinarian update(Veterinarian veterinarian) {
        veterinarianValidation(veterinarian);
        return repository.save(veterinarian);
    }

    @Override
    public Veterinarian findById(Integer id) {
        Optional<Veterinarian> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhum veterinário encontrado com esse id %s".formatted(id)));
    }

    @Override
    public List<Veterinarian> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Veterinarian> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Veterinarian> findByNameStartingWithIgnoreCase(String name) {
        return repository.findByNameStartingWithIgnoreCase(name);
    }

    @Override
    public List<Veterinarian> findByCrm(String crm) {
        return repository.findByCrm(crm);
    }

    @Override
    public List<Veterinarian> findBySpeciality(Speciality speciality) {
        return repository.findBySpeciality(speciality);
    }

    @Override
    public void delete(Integer id) {
        Veterinarian veterinarian = findById(id);
        repository.delete(veterinarian);
    }
}
