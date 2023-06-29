package br.com.trier.petshop.services;

import java.util.List;

import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.domain.Speciality;

public interface ScheduleTypeService {
	ScheduleType save (ScheduleType scheduleType);
	ScheduleType update (ScheduleType scheduleType);
	ScheduleType findById(Integer id);
	List<ScheduleType> listAll();
	List<ScheduleType> findByDescription(String description);
    List<ScheduleType> findByDescriptionStartingWithIgnoreCase(String description);
    List<ScheduleType> findByRequerMedicalRecord(Boolean requerMedicalRecord);
    void delete (Integer id);
	
}
