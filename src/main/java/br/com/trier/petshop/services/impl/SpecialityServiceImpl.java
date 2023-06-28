package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.repositories.SpecialityRepository;
import br.com.trier.petshop.services.SpecialityService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    SpecialityRepository repository;

    private void specialityValidation(Speciality obj){
        if (obj == null) {
            throw new IntegrityViolation("A especialidade não pode ser nula!");
        }
    }

    @Override
    public Speciality save(Speciality speciality) {
        specialityValidation(speciality);
        return repository.save(speciality);
    }

    @Override
    public Speciality update(Speciality speciality) {
        specialityValidation(speciality);
        return repository.save(speciality);
    }

    @Override
    public Speciality findById(Integer id) {
        Optional<Speciality> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhuma especialidade encontrada com o id %s".formatted(id)));
    }

    @Override
    public List<Speciality> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Speciality> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public List<Speciality> findByDescriptionStartingWithIgnoreCase(String description) {
        return repository.findByDescriptionStartingWithIgnoreCase(description);
    }

    @Override
    public void delete(Integer id) {
        Speciality speciality = findById(id);
        repository.delete(speciality);
    }
}
