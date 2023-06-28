package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.PetOwner;
import br.com.trier.petshop.repositories.PetOwnerRepository;
import br.com.trier.petshop.services.PetOwnerService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {

    @Autowired
    PetOwnerRepository repository;

    private void petOwnerValidation(PetOwner obj) {
        if (obj == null) {
            throw new IllegalArgumentException("O dono do pet não pode ser nulo!");
        }
        List<PetOwner> petOwners = repository.findByCpf(obj.getCpf());
        if (!petOwners.isEmpty() && !petOwners.get(0).getId().equals(obj.getId())) {
            throw new IntegrityViolation(String.format("CPF %s já cadastrado!", obj.getCpf()));
        }
    }

    @Override
    public PetOwner save(PetOwner petOwner) {
        petOwnerValidation(petOwner);
        return repository.save(petOwner);
    }

    @Override
    public PetOwner update(PetOwner petOwner) {
        petOwnerValidation(petOwner);
        return repository.save(petOwner);
    }

    @Override
    public PetOwner findById(Integer id) {
        Optional<PetOwner> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhum proprietário encontrado com esse id %s".formatted(id)));
    }

    @Override
    public List<PetOwner> listAll() {
        return repository.findAll();
    }

    @Override
    public List<PetOwner> findByName(String name) {
        return repository.findByName(name);
    }


    @Override
    public List<PetOwner> findByNameStartingWithIgnoreCase(String name) {
        return repository.findByNameStartingWithIgnoreCase(name);
    }

    @Override
    public List<PetOwner> findByNameContainsIgnoreCase(String name) {
        return repository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<PetOwner> findByNameEqualsIgnoreCase(String name) {
        return repository.findByNameEqualsIgnoreCase(name);
    }

    @Override
    public List<PetOwner> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public void delete(Integer id) {
        PetOwner petOwner = findById(id);
        repository.delete(petOwner);
    }
}
