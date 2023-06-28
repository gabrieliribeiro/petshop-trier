package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Neighborhood;
import br.com.trier.petshop.repositories.NeighborhoodRepository;
import br.com.trier.petshop.services.NeighborhoodService;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService{
	
	@Autowired
	NeighborhoodRepository repository;

	@Override
	public Neighborhood save(Neighborhood neighborhood) {
		return repository.save(neighborhood);
	}

	@Override
	public Neighborhood update(Neighborhood neighborhood) {
		return repository.save(neighborhood);
	}

	@Override
	public Neighborhood findById(Integer id) {
		Optional<Neighborhood> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound("Nenhum bairro encontrado com id %s não encontrada!".formatted(id)));
	}

	@Override
	public List<Neighborhood> listAll() {
		return repository.findAll();
	}

	@Override
	public List<Neighborhood> findByDescription(String description) {
		return repository.findByDescription(description);
	}

	@Override
	public List<Neighborhood> findByDescriptionStartingWithIgnoreCase(String description) {
		return repository.findByDescriptionStartingWithIgnoreCase(description);
	}

	@Override
	public List<Neighborhood> findByDescriptionContainsIgnoreCase(String description) {
		return repository.findByDescriptionContainsIgnoreCase(description);
	}

	@Override
	public List<Neighborhood> findByDescriptionEqualsIgnoreCase(String description) {
		return repository.findByDescriptionEqualsIgnoreCase(description);
	}

	@Override
	public void delete(Integer id) {
		Neighborhood neighborhood = findById(id);
		repository.delete(neighborhood);
	}

}
