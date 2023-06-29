package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/especialidade")
public class SpecialityResource {

    @Autowired
    private SpecialityService service;

    @PostMapping
    public ResponseEntity<Speciality> insert(@RequestBody Speciality speciality){
        Speciality newSpeciality = service.save(speciality);
        return newSpeciality != null ? ResponseEntity.ok(newSpeciality) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speciality> update(@PathVariable Integer id ,@RequestBody Speciality speciality){
        speciality.setId(id);
        speciality = service.update(speciality);
        return speciality != null ? ResponseEntity.ok(speciality) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Speciality>>listAll(){
        List<Speciality> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> findById(@PathVariable Integer id){
        Speciality speciality = service.findById(id);
        return speciality!=null ? ResponseEntity.ok(speciality) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/descricao/{description}")
    public ResponseEntity<List<Speciality>> findByDescription(@PathVariable String description){
        return ResponseEntity.ok(service.findByDescription(description));
    }

    @GetMapping("/descricao-inicia/{description}")
    public ResponseEntity<List<Speciality>> findByDescriptionStartingWithIgnoreCase(@PathVariable String description){
        return ResponseEntity.ok(service.findByDescriptionStartingWithIgnoreCase(description));
    }
}
