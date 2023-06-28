package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "veterinario")
public class Veterinarian {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veterinario")
	@Setter
	private Integer id;
	
	@Column(name = "crm_veterinario")
	private String crm;
	
	@Column(name = "nome_veterinario")
	private String name;
	
	@Column(name = "contato_veterinario")
	private String fone;

	@ManyToOne
	private Speciality speciality;
}
