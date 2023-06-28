package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "raca")
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_raca")
	@Setter
	private Integer id;
	
	@Column(name = "nome_raca")
	private String raceName;
}
