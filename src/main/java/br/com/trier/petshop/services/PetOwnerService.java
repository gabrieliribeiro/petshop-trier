package br.com.trier.petshop.services;



import br.com.trier.petshop.domain.PetOwner;

import java.util.List;

public interface PetOwnerService {
    PetOwner save (PetOwner petOwner);
    PetOwner update (PetOwner petOwner);
    PetOwner findById(Integer id);
    List<PetOwner> listAll();
    List<PetOwner> findByName (String name);
    List<PetOwner> findByNameStartingWithIgnoreCase (String name);
    List<PetOwner> findByNameContainsIgnoreCase (String name);
    List<PetOwner> findByNameEqualsIgnoreCase (String name);
    List<PetOwner> findByCpf (String cpf);
    void delete (Integer id);
}
