package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Address;
import br.com.trier.petshop.domain.City;
import br.com.trier.petshop.domain.Neighborhood;
import br.com.trier.petshop.repositories.AddressRepository;
import br.com.trier.petshop.services.AddressService;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository repository;

	@Override
	public Address save(Address address) {
		return repository.save(address);
	}

	@Override
	public Address update(Address address) {
		return repository.save(address);
	}

	@Override
	public Address findById(Integer id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFound("Nenhum endereço encontrado com id %s".formatted(id)));
	}

	@Override
	public List<Address> listAll() {
		return repository.findAll();
	}

	@Override
	public List<Address> findByStreetAddress(String streetAddress) {
		return repository.findByStreetAddress(streetAddress);
	}

	@Override
	public List<Address> findByZipCode(String zipCode) {
		return repository.findByZipCode(zipCode);
	}

	@Override
	public List<Address> findByNeighborhood(Neighborhood neighborhood) {
		return repository.findByNeighborhood(neighborhood);
	}

	@Override
	public List<Address> findByCity(City city) {
		return repository.findByCity(city);
	}

	@Override
	public void delete(Integer id) {
		Address address = findById(id);
		repository.delete(address);
	}
}
