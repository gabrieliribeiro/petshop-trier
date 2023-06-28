package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

//FIXME fazer dto

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "endereco")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	@Setter
	private Integer id;
	
	@Column(name = "cep_endereco")
	private String zipCode;
	
	@Column(name = "logradouro_endereco")
	private String streetAddress;
	
	@ManyToOne
		private Neighborhood neighborhood;
	
	@ManyToOne
	private City city;
}
