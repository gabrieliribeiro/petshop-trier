package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Address;
import br.com.trier.petshop.domain.City;
import br.com.trier.petshop.domain.Neighborhood;
import br.com.trier.petshop.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<Address> insert(@RequestBody Address address){
		Address newAddress = service.save(address);
		return newAddress != null ? ResponseEntity.ok(newAddress) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> update(@PathVariable Integer id ,@RequestBody Address address){
		address.setId(id);
		address = service.update(address);
		return address != null ? ResponseEntity.ok(address) : ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Address>>listAll(){
		List<Address> lista = service.listAll();
		return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> findById(@PathVariable Integer id){
		Address address = service.findById(id);
		return address!=null ? ResponseEntity.ok(address) : ResponseEntity.badRequest().build();
	}

	@GetMapping("nome-rua/{streetAddress}")
	public ResponseEntity<List<Address>> findByStreetAddress(@PathVariable String streetAddress){
		return ResponseEntity.ok(service.findByStreetAddress(streetAddress));
	}

	@GetMapping("cep/{zipCode}")
	public ResponseEntity<List<Address>> findByZipCode(@PathVariable String zipCode){
		return ResponseEntity.ok(service.findByZipCode(zipCode));
	}

	@GetMapping("bairro/{neighborhood}")
	public ResponseEntity<List<Address>> findByNeighborhood(@PathVariable Neighborhood neighborhood){
		return ResponseEntity.ok(service.findByNeighborhood(neighborhood));
	}

	@GetMapping("cidade/{city}")
	public ResponseEntity<List<Address>> findByCity(@PathVariable City city){
		return ResponseEntity.ok(service.findByCity(city));
	}

}
