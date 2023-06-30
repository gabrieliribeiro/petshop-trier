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

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.Neighborhood;
import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.services.MedicalRecordService;

@RestController
@RequestMapping(value = "/prontuário")
public class MedicalRecordResource {
	
	@Autowired
	private MedicalRecordService service;
	
	@PostMapping
	public ResponseEntity<MedicalRecord> insert(@RequestBody MedicalRecord medicalRecord){
		MedicalRecord newMedicalRecord = service.save(medicalRecord);
		return newMedicalRecord != null ? ResponseEntity.ok(newMedicalRecord) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicalRecord> update(@PathVariable Integer id ,@RequestBody MedicalRecord medicalRecord){
		medicalRecord.setId(id);
		medicalRecord = service.update(medicalRecord);
		return medicalRecord != null ? ResponseEntity.ok(medicalRecord) : ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<MedicalRecord>>listAll(){
		List<MedicalRecord> lista = service.listAll();
		return lista.size()>0 ? ResponseEntity.ok(lista) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicalRecord> findById(@PathVariable Integer id){
		MedicalRecord medicalRecord = service.findById(id);
		return medicalRecord!=null ? ResponseEntity.ok(medicalRecord) : ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/evolucao/{evolution}")
	public ResponseEntity<List<MedicalRecord>> findByEvolution(@PathVariable String evolution){
		return ResponseEntity.ok(service.findByEvolution(evolution));
	}
	
	@GetMapping("/tratamento/{treatment}")
	public ResponseEntity<List<MedicalRecord>> findByTreatment(@PathVariable String treatment){
		return ResponseEntity.ok(service.findByTreatment(treatment));
	}
	
	@GetMapping("/especialidade/{speciality}")
	public ResponseEntity<List<MedicalRecord>> findBySpeciality(@PathVariable Speciality speciality){
		return ResponseEntity.ok(service.findBySpeciality(speciality));
	}

}
