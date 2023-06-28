package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Integer> {

    List<PetOwner> findByName (String name);

    List<PetOwner> findByNameStartingWithIgnoreCase (String name);
    List<PetOwner> findByNameContainsIgnoreCase (String name);
    List<PetOwner> findByNameEqualsIgnoreCase (String name);

    List<PetOwner> findByCpf (String cpf);

}
