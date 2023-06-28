package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.City;
import br.com.trier.petshop.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidade")
public class CityResource {
	
	@Autowired
	private CityService service;
	
	@PostMapping
	public ResponseEntity<City> insert(@RequestBody City city){
		City newCity = service.save(city);
		return newCity != null ? ResponseEntity.ok(newCity) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<City> update(@PathVariable Integer id ,@RequestBody City city){
		city.setId(id);
		city = service.update(city);
		return city != null ? ResponseEntity.ok(city) : ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<City>>listAll(){
		List<City> lista = service.listAll();
		return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<City> findById(@PathVariable Integer id){
		City city = service.findById(id);
		return city!=null ? ResponseEntity.ok(city) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<City>> findByNameStartingWithIgnoreCase(@PathVariable String name){
		return ResponseEntity.ok(service.findByNameStartingWithIgnoreCase(name));
	}
}
