package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.Neighborhood;

import java.util.List;

public interface NeighborhoodService {
	Neighborhood save (Neighborhood neighborhood);
	Neighborhood update (Neighborhood neighborhood);
	Neighborhood findById(Integer id);
	List<Neighborhood> listAll();
	List<Neighborhood> findByDescription (String description);
	List<Neighborhood> findByDescriptionStartingWithIgnoreCase (String description);
	List<Neighborhood> findByDescriptionContainsIgnoreCase (String description);
	List<Neighborhood> findByDescriptionEqualsIgnoreCase (String description);
	void delete (Integer id);
	
}
