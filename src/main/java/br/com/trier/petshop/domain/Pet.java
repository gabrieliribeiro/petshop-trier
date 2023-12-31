package br.com.trier.petshop.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Entity(name = "pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pet")
	@Setter
	private Integer id;
	
	@Column(name = "nome_pet")
	private String name;

	@Column(name = "data_aniversario")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthdate;

	@Column(name = "porte_raca")
	private String petSize;

	@Column(name = "pelagem_raca")
	private String petFurSize;

	@Column(name = "cor_pelagem_raca")
	private String petFurColor;

	@ManyToOne
	private PetOwner petOwner;
	
	@ManyToOne
	private Species species;

	@ManyToOne
	private Race race;
}
