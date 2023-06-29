package br.com.trier.petshop.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trier.petshop.domain.Schedule;
import br.com.trier.petshop.domain.ScheduleType;
import br.com.trier.petshop.domain.Speciality;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	List<Schedule> findByDate(ZonedDateTime date);
	List<Schedule> findByDateBetween(ZonedDateTime initialDate, ZonedDateTime finalDate);
	List<Schedule> findByReason(String reason);
	List<Schedule> findByScheduleType(ScheduleType scheduleType);
	List<Schedule> findBySpeciality(Speciality speciality);
}
