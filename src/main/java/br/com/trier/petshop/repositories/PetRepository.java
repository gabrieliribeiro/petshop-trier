package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Pet;
import br.com.trier.petshop.domain.PetOwner;
import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByName (String name);
    List<Pet> findByNameStartingWithIgnoreCase (String name);
    List<Pet> findByPetOwner (PetOwner petOwner);
    List<Pet> findBySpecies(Species species);
    List<Pet> findByRace (Race race);
    List<Pet> findByPetSize (String petSize);
    List<Pet> findByPetSizeEqualsIgnoreCase (String petSize);
    List<Pet> findByPetFurSize (String petFurSize);
    List<Pet> findByPetFurColor (String petFurColor);
    List<Pet> findByPetFurSizeEqualsIgnoreCase (String petFurSize);
}
