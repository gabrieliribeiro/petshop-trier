package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.domain.Species;
import br.com.trier.petshop.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/especie")
public class SpeciesResource {
    @Autowired
    private SpeciesService service;

    @PostMapping
    public ResponseEntity<Species> insert(@RequestBody Species species){
        Species newSpecies = service.save(species);
        return newSpecies != null ? ResponseEntity.ok(newSpecies) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Species> update(@PathVariable Integer id ,@RequestBody Species species){
        species.setId(id);
        species = service.update(species);
        return species != null ? ResponseEntity.ok(species) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Species>>listAll(){
        List<Species> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Species> findById(@PathVariable Integer id){
        Species race = service.findById(id);
        return race!=null ? ResponseEntity.ok(race) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/descricao/{description}")
    public ResponseEntity<List<Species>> findByDescription(@PathVariable String description){
        return ResponseEntity.ok(service.findByDescription(description));
    }

    @GetMapping("/descricao-inicia/{description}")
    public ResponseEntity<List<Species>> findByDescriptionStartingWithIgnoreCase(@PathVariable String description){
        return ResponseEntity.ok(service.findByDescriptionStartingWithIgnoreCase(description));
    }

}
