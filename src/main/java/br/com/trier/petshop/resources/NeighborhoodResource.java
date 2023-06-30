package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Neighborhood;
import br.com.trier.petshop.services.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bairro")
public class NeighborhoodResource {
	
	@Autowired
	private NeighborhoodService service;
	
	@PostMapping
	public ResponseEntity<Neighborhood> insert(@RequestBody Neighborhood neighborhood){
		Neighborhood newNeighboorhood = service.save(neighborhood);
		return newNeighboorhood != null ? ResponseEntity.ok(newNeighboorhood) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Neighborhood> update(@PathVariable Integer id ,@RequestBody Neighborhood neighboorhood){
		neighboorhood.setId(id);
		neighboorhood = service.update(neighboorhood);
		return neighboorhood != null ? ResponseEntity.ok(neighboorhood) : ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Neighborhood>>listAll(){
		List<Neighborhood> lista = service.listAll();
		return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Neighborhood> findById(@PathVariable Integer id){
		Neighborhood neighborhood = service.findById(id);
		return neighborhood!=null ? ResponseEntity.ok(neighborhood) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/name/{description}")
	public ResponseEntity<List<Neighborhood>> findByDescriptionStartingWithIgnoreCase(@PathVariable String description){
		return ResponseEntity.ok(service.findByDescriptionStartingWithIgnoreCase(description));
	}
}
