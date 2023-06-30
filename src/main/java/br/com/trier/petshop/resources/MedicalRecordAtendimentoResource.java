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

import br.com.trier.petshop.domain.MedicalRecordAtendimento;
import br.com.trier.petshop.domain.dto.MedicalRecordAtendimentoDTO;
import br.com.trier.petshop.services.MedicalRecordAtendimentoService;
import br.com.trier.petshop.services.MedicalRecordService;
import br.com.trier.petshop.services.ScheduleService;

@RestController
@RequestMapping(value = "/prontuario-atendimento")
public class MedicalRecordAtendimentoResource {
	
	@Autowired
	MedicalRecordAtendimentoService service;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	MedicalRecordService medicalRecordService;
	

	@PostMapping
	public ResponseEntity<MedicalRecordAtendimento> insert(@RequestBody MedicalRecordAtendimentoDTO medicalRecordAtendimentoDTO){
		return ResponseEntity.ok(service.save(new MedicalRecordAtendimento(
				medicalRecordAtendimentoDTO,
				scheduleService.findById(medicalRecordAtendimentoDTO.getIdAtendimento()),
				medicalRecordService.findById(medicalRecordAtendimentoDTO.getIdProntuario())
				)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicalRecordAtendimento> update(@PathVariable Integer id ,@RequestBody MedicalRecordAtendimento medicalRecordAtendimento){
		medicalRecordAtendimento.setId(id);
		medicalRecordAtendimento = service.update(medicalRecordAtendimento);
		return medicalRecordAtendimento != null ? ResponseEntity.ok(medicalRecordAtendimento) : ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<MedicalRecordAtendimento>>listAll(){
		List<MedicalRecordAtendimento> lista = service.listAll();
		return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicalRecordAtendimento> findById(@PathVariable Integer id){
		MedicalRecordAtendimento medicalRecord = service.findById(id);
		return medicalRecord!=null ? ResponseEntity.ok(medicalRecord) : ResponseEntity.badRequest().build();
	}
}
