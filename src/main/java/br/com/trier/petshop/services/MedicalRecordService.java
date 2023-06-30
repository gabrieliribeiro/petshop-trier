package br.com.trier.petshop.services;

import java.util.List;

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.Schedule;
import br.com.trier.petshop.domain.Speciality;

public interface MedicalRecordService {
	
	MedicalRecord save(MedicalRecord medicalRecord);

	MedicalRecord update(MedicalRecord medicalRecord);

	MedicalRecord findById(Integer id);

	List<MedicalRecord> listAll();

	List<MedicalRecord> findByEvolution(String evolution);

	List<MedicalRecord> findByTreatment(String treatment);

	List<MedicalRecord> findBySpeciality(Speciality speciality);

	void delete(Integer id);
}
