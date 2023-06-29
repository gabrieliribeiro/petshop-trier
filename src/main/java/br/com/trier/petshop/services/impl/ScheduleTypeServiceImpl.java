package br.com.trier.petshop.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.repositories.ScheduleTypeRepository;
import br.com.trier.petshop.services.ScheduleTypeService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

@Service
public class ScheduleTypeServiceImpl implements ScheduleTypeService{
	
	@Autowired
	ScheduleTypeRepository repository;
	
	

	public void validateScheduleType(ScheduleType obj) {
		List<ScheduleType> existingTypes = repository.findByDescription(obj.getDescription());

		for (ScheduleType existingType : existingTypes) {
			if (existingType != null && existingType.getId() != obj.getId()) {
		        throw new IntegrityViolation("Tipo de agendamento com a descrição '%s' já existe."
		                .formatted(obj.getDescription()));
		    }
		}
		if (obj.getDescription().equalsIgnoreCase("médico") && obj.getDescription() == null) {
			throw new IllegalArgumentException("O motivo deve ser informado para o tipo de atendimento médico.");
		}
	}



	@Override
	public ScheduleType save(ScheduleType scheduleType) {
		validateScheduleType(scheduleType);
		return repository.save(scheduleType);
	}



	@Override
	public ScheduleType update(ScheduleType scheduleType) {
		validateScheduleType(scheduleType);
		return repository.save(scheduleType);
	}


	@Override
	public ScheduleType findById(Integer id) {
		Optional<ScheduleType> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound("Cidade com id %s não encontrada!".formatted(id)));
	}
	
	
	@Override
	public List<ScheduleType> listAll() {
		return repository.findAll();
	}


	@Override
	public List<ScheduleType> findByDescription(String description) {
		return repository.findByDescription(description);
	}



	@Override
	public List<ScheduleType> findByDescriptionStartingWithIgnoreCase(String description) {
		return repository.findByDescriptionStartingWithIgnoreCase(description);
	}



	@Override
	public List<ScheduleType> findByRequerMedicalRecord(Boolean requerMedicalRecord) {
		return repository.findByRequerMedicalRecord(requerMedicalRecord);
	}

	@Override
	public void delete(Integer id) {
		ScheduleType scheduleType = findById(id);
		repository.delete(scheduleType);
		
	}
	
}
