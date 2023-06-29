package br.com.trier.petshop.services;

import java.time.ZonedDateTime;
import java.util.List;

import br.com.trier.petshop.domain.Schedule;
import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.domain.Speciality;

public interface ScheduleService {
	Schedule save (Schedule schedule);
	Schedule update (Schedule schedule);
	Schedule findById(Integer id);
	List<Schedule> listAll();
	List<Schedule> findByDate(ZonedDateTime date);
	List<Schedule> findByDateBetween(ZonedDateTime initialDate, ZonedDateTime finalDate);
	List<Schedule> findByReason(String reason);
	List<Schedule> findByScheduleType(ScheduleType scheduleType);
	List<Schedule> findBySpeciality(Speciality speciality);
	void delete (Integer id);
}
