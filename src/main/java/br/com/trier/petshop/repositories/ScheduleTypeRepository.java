package br.com.trier.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trier.petshop.domain.ScheduleType;

@Repository
public interface ScheduleTypeRepository extends JpaRepository<ScheduleType, Integer>{
	List<ScheduleType> findByDescription(String description);
    List<ScheduleType> findByDescriptionStartingWithIgnoreCase(String description);
    List<ScheduleType> findByRequerMedicalRecord(Boolean requerMedicalRecord);
}
