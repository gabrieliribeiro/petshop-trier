package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Address;
import br.com.trier.petshop.domain.City;
import br.com.trier.petshop.domain.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> findByStreetAddress (String streetAddress);
	List<Address> findByZipCode (String zipCode);
	List<Address> findByNeighborhood (Neighborhood neighborhood);
	List<Address> findByCity (City city);
}