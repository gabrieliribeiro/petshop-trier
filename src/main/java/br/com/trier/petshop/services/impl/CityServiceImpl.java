package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.City;
import br.com.trier.petshop.repositories.CityRepository;
import br.com.trier.petshop.services.CityService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	CityRepository repository;
	
	private void validateCity(City obj) {
		List<City> cities = repository.findByNameAndState(obj.getName(), obj.getState());
		for (City city : cities) {
			if (city.getId() != obj.getId()) {
				throw new IntegrityViolation("Cidade %s já cadastrada no estado %s!".formatted(obj.getName(), obj.getState()));
			}
		}
	}

	@Override
	public City save(City city) {
		validateCity(city);
		return repository.save(city);
	}

	@Override
	public City update(City city) {
		validateCity(city);
		return repository.save(city);
	}

	@Override
	public City findById(Integer id) {
		Optional<City> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound("Cidade com id %s não encontrada!".formatted(id)));
	}

	@Override
	public List<City> listAll() {
		return repository.findAll();
	}

	@Override
	public List<City> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<City> findByNameStartingWithIgnoreCase(String name) {
		return repository.findByNameStartingWithIgnoreCase(name);
	}

	@Override
	public List<City> findByNameContainsIgnoreCase(String name) {
		return repository.findByNameContainsIgnoreCase(name);
	}

	@Override
	public List<City> findByNameEqualsIgnoreCase(String name) {
		return repository.findByNameEqualsIgnoreCase(name);
	}

	@Override
	public void delete(Integer id) {
		City city = findById(id);
		repository.delete(city);
	}

}
