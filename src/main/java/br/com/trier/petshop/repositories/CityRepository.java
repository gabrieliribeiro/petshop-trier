package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	List<City> findByName (String name);
	List<City> findByNameAndState (String name, String state);
	List<City> findByNameStartingWithIgnoreCase (String name);
	List<City> findByNameContainsIgnoreCase (String name);
	List<City> findByNameEqualsIgnoreCase (String name);
}
