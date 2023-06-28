package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.City;

import java.util.List;

public interface CityService {
	City save (City city);
	City update (City city);
	City findById(Integer id);
	List<City> listAll();
	List<City> findByName (String name);
	List<City> findByNameStartingWithIgnoreCase (String name);
	List<City> findByNameContainsIgnoreCase (String name);
	List<City> findByNameEqualsIgnoreCase (String name);
	void delete (Integer id);
}
