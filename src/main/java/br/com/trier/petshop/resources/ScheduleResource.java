package br.com.trier.petshop.resources;

import java.time.ZonedDateTime;
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

import br.com.trier.petshop.domain.Schedule;
import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.services.ScheduleService;

@RestController
@RequestMapping(value = "/agenda")
public class ScheduleResource {
	
	@Autowired
	private ScheduleService service;
	
	@PostMapping
    public ResponseEntity<Schedule> insert(@RequestBody Schedule schedule){
		Schedule newSchedule = service.save(schedule);
        return newSchedule != null ? ResponseEntity.ok(newSchedule) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable Integer id ,@RequestBody Schedule schedule){
    	schedule.setId(id);
    	schedule = service.update(schedule);
        return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Schedule>>listAll(){
        List<Schedule> lista = service.listAll();
        return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> findById(@PathVariable Integer id){
    	Schedule schedule = service.findById(id);
        return schedule!=null ? ResponseEntity.ok(schedule) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/data/{date}")
    public ResponseEntity<List<Schedule>> findByDate(@PathVariable ZonedDateTime date){
        return ResponseEntity.ok(service.findByDate(date));
    }

    @GetMapping("/data-entre/{initialDate}/{finalDate}/")
    public ResponseEntity<List<Schedule>> findByDateBetween(@PathVariable ZonedDateTime initialDate, ZonedDateTime finalDate){
        return ResponseEntity.ok(service.findByDateBetween(initialDate, finalDate));
    }
    
    @GetMapping("/motivo/{reason}")
    public ResponseEntity<List<Schedule>> findByReason(@PathVariable String reason){
        return ResponseEntity.ok(service.findByReason(reason));
    }
    
    @GetMapping("/tipo-agendamento/{scheduleType}")
    public ResponseEntity<List<Schedule>> findByScheduleType(@PathVariable ScheduleType scheduleType){
        return ResponseEntity.ok(service.findByScheduleType(scheduleType));
    }
    
    @GetMapping("/especialidade/{scheduleType}")
    public ResponseEntity<List<Schedule>> findBySpeciality(@PathVariable Speciality speciality){
        return ResponseEntity.ok(service.findBySpeciality(speciality));
    }

}
