package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/raca")
public class RaceResource {

    @Autowired
    private RaceService service;

    @PostMapping
    public ResponseEntity<Race> insert(@RequestBody Race race){
        Race newRace = service.save(race);
        return newRace != null ? ResponseEntity.ok(newRace) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Race> update(@PathVariable Integer id ,@RequestBody Race race){
        race.setId(id);
        race = service.update(race);
        return race != null ? ResponseEntity.ok(race) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Race>>listAll(){
        List<Race> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> findById(@PathVariable Integer id){
        Race race = service.findById(id);
        return race!=null ? ResponseEntity.ok(race) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/name/{raceName}")
    public ResponseEntity<List<Race>> findByRaceName(@PathVariable String raceName){
        return ResponseEntity.ok(service.findByRaceName(raceName));
    }

}
