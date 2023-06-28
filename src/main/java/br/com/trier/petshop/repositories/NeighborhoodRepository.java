package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Integer> {
	List<Neighborhood> findByDescription (String description);
	List<Neighborhood> findByDescriptionStartingWithIgnoreCase (String description);
	List<Neighborhood> findByDescriptionContainsIgnoreCase (String description);
	List<Neighborhood> findByDescriptionEqualsIgnoreCase (String description);
}
