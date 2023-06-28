package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.Address;
import br.com.trier.petshop.domain.City;
import br.com.trier.petshop.domain.Neighborhood;

import java.util.List;

public interface AddressService {
	Address save (Address address);
	Address update (Address address);
	Address findById(Integer id);
	List<Address> listAll();
	List<Address> findByStreetAddress (String streetAddress);
	List<Address> findByZipCode (String zipCode);
	List<Address> findByNeighborhood (Neighborhood neighborhood);
	List<Address> findByCity (City city);
	void delete (Integer id);
}
