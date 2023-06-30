package br.com.trier.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trier.petshop.domain.MedicalRecord;
import br.com.trier.petshop.domain.Speciality;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer>{
	List<MedicalRecord> findByEvolution(String evolution);
	List<MedicalRecord> findByTreatment(String treatment);
	List<MedicalRecord> findBySpeciality(Speciality speciality);
}
