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
import br.com.trier.petshop.domain.dto.ScheduleTypeDTO;
import br.com.trier.petshop.services.ScheduleTypeService;

@RestController
@RequestMapping(value = "/tipo-agendamento")
public class ScheduleTypeResource {
	
	@Autowired
	private ScheduleTypeService service;
	
	@PostMapping
    public ResponseEntity<ScheduleTypeDTO> insert(@RequestBody ScheduleTypeDTO scheduleType){
		ScheduleType newScheduleType = service.save(new ScheduleType(scheduleType));
        return newScheduleType != null ? ResponseEntity.ok(newScheduleType.toDto()) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleTypeDTO> update(@PathVariable Integer id ,@RequestBody ScheduleTypeDTO scheduleTypeDTO){
    	ScheduleType scheduleType = new ScheduleType(scheduleTypeDTO);
    	scheduleType.setId(id);
    	scheduleType = service.update(scheduleType);
        return scheduleType != null ? ResponseEntity.ok(scheduleType.toDto()) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ScheduleTypeDTO>>listAll(){
    	return ResponseEntity.ok(service.listAll().stream()
				.map((scheduleType) -> scheduleType.toDto())
				.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleTypeDTO> findById(@PathVariable Integer id){
    	ScheduleType scheduleType = service.findById(id);
        return scheduleType!=null ? ResponseEntity.ok(scheduleType.toDto()) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/descricao/{description}")
    public ResponseEntity<List<ScheduleTypeDTO>> findByDescription(@PathVariable String description){
    	return ResponseEntity.ok(service.findByDescription(description).stream()
				.map((scheduleType) -> scheduleType.toDto())
				.toList());
    }

    @GetMapping("/descricao-inicia/{description}")
    public ResponseEntity<List<ScheduleTypeDTO>> findByDescriptionStartingWithIgnoreCase(@PathVariable String description){
    	return ResponseEntity.ok(service.findByDescriptionStartingWithIgnoreCase(description).stream()
				.map((scheduleType) -> scheduleType.toDto())
				.toList());
    }
    
    @GetMapping("/protuario/{requerMedicalRecord}")
    public ResponseEntity<List<ScheduleTypeDTO>> findByRequerMedicalRecord(@PathVariable Boolean requerMedicalRecord){
    	return ResponseEntity.ok(service.findByRequerMedicalRecord(requerMedicalRecord).stream()
				.map((scheduleType) -> scheduleType.toDto())
				.toList());
    }
}
