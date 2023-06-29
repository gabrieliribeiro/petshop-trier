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

import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.services.ScheduleTypeService;

@RestController
@RequestMapping(value = "/tipo-agendamento")
public class ScheduleTypeResource {
	
	@Autowired
	private ScheduleTypeService service;
	
	@PostMapping
    public ResponseEntity<ScheduleType> insert(@RequestBody ScheduleType scheduleType){
		ScheduleType newScheduleType = service.save(scheduleType);
        return newScheduleType != null ? ResponseEntity.ok(newScheduleType) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleType> update(@PathVariable Integer id ,@RequestBody ScheduleType scheduleType){
    	scheduleType.setId(id);
    	scheduleType = service.update(scheduleType);
        return scheduleType != null ? ResponseEntity.ok(scheduleType) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ScheduleType>>listAll(){
        List<ScheduleType> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleType> findById(@PathVariable Integer id){
    	ScheduleType scheduleType = service.findById(id);
        return scheduleType!=null ? ResponseEntity.ok(scheduleType) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/descricao/{description}")
    public ResponseEntity<List<ScheduleType>> findByDescription(@PathVariable String description){
        return ResponseEntity.ok(service.findByDescription(description));
    }

    @GetMapping("/descricao-inicia/{description}")
    public ResponseEntity<List<ScheduleType>> findByDescriptionStartingWithIgnoreCase(@PathVariable String description){
        return ResponseEntity.ok(service.findByDescriptionStartingWithIgnoreCase(description));
    }
    
    @GetMapping("/protuario/{requerMedicalRecord}")
    public ResponseEntity<List<ScheduleType>> findByRequerMedicalRecord(@PathVariable Boolean requerMedicalRecord){
        return ResponseEntity.ok(service.findByRequerMedicalRecord(requerMedicalRecord));
    }
}
