package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

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

	@Column(name = "nascimento_pet")
	private ZonedDateTime birthdate;

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
