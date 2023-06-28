package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.domain.Veterinarian;
import br.com.trier.petshop.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veterinario")
public class VeterinarianResource {
    @Autowired
    private VeterinarianService service;
    @PostMapping
    public ResponseEntity<Veterinarian> insert(@RequestBody Veterinarian veterinarian){
        Veterinarian newVeterinarian = service.save(veterinarian);
        return newVeterinarian != null ? ResponseEntity.ok(newVeterinarian) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinarian> update(@PathVariable Integer id ,@RequestBody Veterinarian veterinarian){
        veterinarian.setId(id);
        veterinarian = service.update(veterinarian);
        return veterinarian != null ? ResponseEntity.ok(veterinarian) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Veterinarian>>listAll(){
        List<Veterinarian> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinarian> findById(@PathVariable Integer id){
        Veterinarian race = service.findById(id);
        return race!=null ? ResponseEntity.ok(race) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<List<Veterinarian>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/nome-inicia/{name}")
    public ResponseEntity<List<Veterinarian>> findByNameStartingWithIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(service.findByNameStartingWithIgnoreCase(name));
    }

    @GetMapping("/crm/{crm}")
    public ResponseEntity<List<Veterinarian>> findByCrm(@PathVariable String crm){
        return ResponseEntity.ok(service.findByCrm(crm));
    }

    @GetMapping("/especialidade/{speciality}")
    public ResponseEntity<List<Veterinarian>> findBySpeciality(@PathVariable Speciality speciality){
        return ResponseEntity.ok(service.findBySpeciality(speciality));
    }
}
