package br.com.trier.petshop.domain;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "agenda")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agenda")
	@Setter
	private Integer id;
	
	@Column(name = "data_agendada")
	private ZonedDateTime date;
	
	@Column(name = "motivo_agendamento")
	private String reason;
	
	@ManyToOne
	private ScheduleType scheduleType;
	
	@ManyToOne
	private Speciality speciality;
}
