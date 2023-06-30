package br.com.trier.petshop.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.repositories.MedicalRecordRepository;
import br.com.trier.petshop.services.MedicalRecordService;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

@Service
public class MedicalRecordImpl implements MedicalRecordService{
	@Autowired
	MedicalRecordRepository repository;

	@Override
	public MedicalRecord save(MedicalRecord medicalRecord) {
		return repository.save(medicalRecord);
	}

	@Override
	public MedicalRecord update(MedicalRecord medicalRecord) {
		return repository.save(medicalRecord);
	}

	@Override
	public MedicalRecord findById(Integer id) {
		Optional<MedicalRecord> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFound("Nenhum prontuário encontrado com id %s".formatted(id)));
	}

	@Override
	public List<MedicalRecord> listAll() {
		return repository.findAll();
	}

	@Override
	public List<MedicalRecord> findByEvolution(String evolution) {
		return repository.findByEvolution(evolution);
	}

	@Override
	public List<MedicalRecord> findByTreatment(String treatment) {
		return repository.findByTreatment(treatment);
	}

	@Override
	public List<MedicalRecord> findBySpeciality(Speciality speciality) {
		return repository.findBySpeciality(speciality);
	}

	@Override
	public void delete(Integer id) {
		MedicalRecord medicalRecord = findById(id);
		repository.delete(medicalRecord);
	}
	
}
