package br.com.trier.petshop.services.impl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trier.petshop.domain.Schedule;
import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.repositories.ScheduleRepository;
import br.com.trier.petshop.services.ScheduleService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	ScheduleRepository repository;
	
	private void validateSchedule(Schedule schedule) {
		if (schedule == null) {
			throw new IntegrityViolation("Agenda (null)");
		}if (schedule.getReason() == null || schedule.getReason().equals(" ")) {
			throw new IntegrityViolation("Descrição obrigatória!");
		}
		validateDate(schedule);
	}
	
	private void validateDate(Schedule schedule) {
		int anoAtual = LocalDate.now().getYear();
		if (schedule.getDate() == null) {
			throw new IntegrityViolation("Data inválida!");
		}
		//FIXME arruma condicional de data
		/*
		 * if (schedule.getDate().getYear() >= anoAtual+1) { throw new
		 * IntegrityViolation("O ano do agendamento não pode ser menor!"); }
		 */
	}

	@Override
	public Schedule save(Schedule schedule) {
		validateSchedule(schedule);		
		return repository.save(schedule);
	}

	@Override
	public Schedule update(Schedule schedule) {
		validateSchedule(schedule);		
		return repository.save(schedule);
	}

	@Override
	public Schedule findById(Integer id) {
		return repository.findById(id).orElseThrow(()-> new ObjectNotFound("Nenhum agendamento encontrado com id %s".formatted(id)));
	}

	@Override
	public List<Schedule> listAll() {
		List<Schedule> lista = repository.findAll();
		if (lista.size() == 0) {
			throw new ObjectNotFound("Nenhum agendamento encontrado");
		}
		return lista;
	}

	@Override
	public List<Schedule> findByDate(ZonedDateTime date) {
		return repository.findByDate(date);
	}

	@Override
	public List<Schedule> findByDateBetween(ZonedDateTime initialDate, ZonedDateTime finalDate) {
		return repository.findByDateBetween(initialDate, finalDate);
	}

	@Override
	public List<Schedule> findByReason(String reason) {
		return repository.findByReason(reason);
	}

	@Override
	public List<Schedule> findByScheduleType(ScheduleType scheduleType) {
		return repository.findByScheduleType(scheduleType);
	}

	@Override
	public List<Schedule> findBySpeciality(Speciality speciality) {
		return repository.findBySpeciality(speciality);
	}

	@Override
	public void delete(Integer id) {
		Schedule schedule = findById(id);
		repository.delete(schedule);
	}
}
