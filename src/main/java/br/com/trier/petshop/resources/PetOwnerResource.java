package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.PetOwner;
import br.com.trier.petshop.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dono-pet")
public class PetOwnerResource {

    @Autowired
    private PetOwnerService service;

    @PostMapping
    public ResponseEntity<PetOwner> insert(@RequestBody PetOwner petOwner){
        PetOwner newPetOwner = service.save(petOwner);
        return newPetOwner != null ? ResponseEntity.ok(newPetOwner) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetOwner> update(@PathVariable Integer id ,@RequestBody PetOwner petOwner){
        petOwner.setId(id);
        petOwner = service.update(petOwner);
        return petOwner != null ? ResponseEntity.ok(petOwner) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PetOwner>>listAll(){
        List<PetOwner> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetOwner> findById(@PathVariable Integer id){
        PetOwner petOwner = service.findById(id);
        return petOwner!=null ? ResponseEntity.ok(petOwner) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PetOwner>> findByNameStartingWithIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(service.findByNameStartingWithIgnoreCase(name));
    }
}
