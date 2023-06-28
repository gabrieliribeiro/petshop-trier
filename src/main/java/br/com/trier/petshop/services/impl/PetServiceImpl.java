package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Pet;
import br.com.trier.petshop.domain.PetOwner;
import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.domain.Species;
import br.com.trier.petshop.repositories.PetRepository;
import br.com.trier.petshop.services.PetService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    PetRepository repository;

    private void petValidation(Pet obj){
        if (obj == null) {
            throw new IntegrityViolation("O Pet não pode ser nulo!");
        }

        if (obj.getPetOwner() == null) {
            throw new IntegrityViolation("O nome do propretário não pode ser nulo!");
        }

        if (obj.getSpecies() == null) {
            throw new IntegrityViolation("A espécie não pode ser nula!");
        }
    }

    @Override
    public Pet save(Pet pet) {
        petValidation(pet);
        return repository.save(pet);
    }

    @Override
    public Pet update(Pet pet) {
        petValidation(pet);
        return repository.save(pet);
    }

    @Override
    public Pet findById(Integer id) {
        Optional<Pet> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhuma raça encontrada com esse id %s".formatted(id)));
    }

    @Override
    public List<Pet> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Pet> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Pet> findByNameStartingWithIgnoreCase(String name) {
        return repository.findByNameStartingWithIgnoreCase(name);
    }

    @Override
    public List<Pet> findByPetOwner(PetOwner petOwner) {
        return repository.findByPetOwner(petOwner);
    }

    @Override
    public List<Pet> findByPetSize(String petSize) {
        return repository.findByPetSize(petSize);
    }

    @Override
    public List<Pet> findByPetSizeEqualsIgnoreCase(String petSize) {
        return repository.findByPetSizeEqualsIgnoreCase(petSize);
    }

    @Override
    public List<Pet> findByPetFurSize(String petFurSize) {
        return repository.findByPetFurSize(petFurSize);
    }

    @Override
    public List<Pet> findByPetFurColor(String petFurColor) {
        return repository.findByPetFurColor(petFurColor);
    }

    @Override
    public List<Pet> findByPetFurSizeEqualsIgnoreCase(String petFurSize) {
        return repository.findByPetFurSizeEqualsIgnoreCase(petFurSize);
    }

    @Override
    public List<Pet> findBySpecies(Species species) {
        return repository.findBySpecies(species);
    }

    @Override
    public void delete(Integer id) {
        Pet pet = findById(id);
        repository.delete(pet);
    }
}
