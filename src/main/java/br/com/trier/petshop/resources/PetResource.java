package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Pet;
import br.com.trier.petshop.domain.PetOwner;
import br.com.trier.petshop.domain.Species;
import br.com.trier.petshop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/pet")
public class PetResource {
    @Autowired
    private PetService service;

    @PostMapping
    public ResponseEntity<Pet> insert(@RequestBody Pet pet){
        Pet newPet = service.save(pet);
        return newPet != null ? ResponseEntity.ok(newPet) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable Integer id , @RequestBody Pet pet){
        pet.setId(id);
        pet = service.update(pet);
        return pet != null ? ResponseEntity.ok(pet) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Pet>>listAll(){
        List<Pet> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Integer id){
        Pet pet = service.findById(id);
        return pet!=null ? ResponseEntity.ok(pet) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Pet>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/nome-inicia/{name}")
    public ResponseEntity<List<Pet>> findByNameStartingWithIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(service.findByNameStartingWithIgnoreCase(name));
    }

    @GetMapping("/dono-pet/{petOwner}")
    public ResponseEntity<List<Pet>> findByPetOwner(@PathVariable PetOwner petOwner){
        return ResponseEntity.ok(service.findByPetOwner(petOwner));
    }

    @GetMapping("/especie/{species}")
    public ResponseEntity<List<Pet>> findBySpecies(@PathVariable Species species){
        return ResponseEntity.ok(service.findBySpecies(species));
    }

    @GetMapping("/porte/{petSize}")
    public ResponseEntity<List<Pet>> findByPetSize(@PathVariable String petSize){
        return ResponseEntity.ok(service.findByPetSize(petSize));
    }

    @GetMapping("/pelagem/{petFurSize}")
    public ResponseEntity<List<Pet>> findByPetFurSize(@PathVariable String petFurSize){
        return ResponseEntity.ok(service.findByPetFurSize(petFurSize));
    }

    @GetMapping("/cor-pelagem/{petFurColor}")
    public ResponseEntity<List<Pet>> findByPetFurColor(@PathVariable String petFurColor){
        return ResponseEntity.ok(service.findByPetFurColor(petFurColor));
    }

}
