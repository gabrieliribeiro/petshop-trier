package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "cidade")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	@Setter
	private Integer id;
	
	@Column(name = "descricao_cidade")
	private String name;
	
	@Column(name = "uf_cidade")
	private String state;
}
