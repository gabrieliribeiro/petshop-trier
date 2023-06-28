package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.Pet;
import br.com.trier.petshop.domain.PetOwner;
import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.domain.Species;

import java.util.List;

public interface PetService {
    Pet save (Pet pet);
    Pet update (Pet pet);
    Pet findById(Integer id);
    List<Pet> listAll();
    List<Pet> findByName (String name);
    List<Pet> findByNameStartingWithIgnoreCase (String name);
    List<Pet> findByPetSize (String petSize);
    List<Pet> findByPetSizeEqualsIgnoreCase (String petSize);
    List<Pet> findByPetFurSize (String petFurSize);
    List<Pet> findByPetFurColor (String petFurColor);
    List<Pet> findByPetFurSizeEqualsIgnoreCase (String petFurSize);
    List<Pet> findByPetOwner (PetOwner petOwner);
    List<Pet> findBySpecies(Species species);
    void delete (Integer id);
}
