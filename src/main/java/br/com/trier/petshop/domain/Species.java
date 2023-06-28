package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "especie")
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_especie")
	@Setter
	private Integer id;
	
	@Column(name = "descricao_especie")
	private String description;
}
