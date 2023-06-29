package br.com.trier.petshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trier.petshop.domain.PetGroomer;
import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.services.PetGroomerService;

@RestController
@RequestMapping(value = "/petgroomer")
public class PetGroomerResource {
	
	@Autowired
	private PetGroomerService service;
	
	
	@PostMapping
    public ResponseEntity<PetGroomer> insert(@RequestBody PetGroomer petGroomer){
		PetGroomer newPetGroomer = service.save(petGroomer);
        return newPetGroomer != null ? ResponseEntity.ok(newPetGroomer) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetGroomer> update(@PathVariable Integer id ,@RequestBody PetGroomer petGroomer){
    	petGroomer.setId(id);
        petGroomer = service.update(petGroomer);
        return petGroomer != null ? ResponseEntity.ok(petGroomer) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PetGroomer>>listAll(){
        List<PetGroomer> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetGroomer> findById(@PathVariable Integer id){
    	PetGroomer petGroomer = service.findById(id);
        return petGroomer!=null ? ResponseEntity.ok(petGroomer) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<List<PetGroomer>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/nome-inicia/{name}")
    public ResponseEntity<List<PetGroomer>> findByNameStartingWithIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(service.findByNameStartingWithIgnoreCase(name));
    }

    @GetMapping("/especialidade/{speciality}")
    public ResponseEntity<List<PetGroomer>> findBySpeciality(@PathVariable Speciality speciality){
        return ResponseEntity.ok(service.findBySpeciality(speciality));
    }

}
