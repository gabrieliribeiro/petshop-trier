package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    List<Species> findByDescription (String description);
    List<Species> findByDescriptionStartingWithIgnoreCase (String description);
}
