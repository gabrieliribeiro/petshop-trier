package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "bairro")
public class Neighborhood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bairro")
	@Setter
	private Integer id;
	
	@Column(name = "descricao_bairro")
	private String description;

}
