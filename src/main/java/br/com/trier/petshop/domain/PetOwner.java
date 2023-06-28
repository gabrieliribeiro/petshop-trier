package br.com.trier.petshop.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "cliente")
public class PetOwner{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	@Setter
	private Integer id;
	
	@Column(name = "cpf_cliente")
	private String cpf;
	
	@Column(name = "rg_cliente")
	private String rg;
	
	@Column(name = "data_cliente")
	private ZonedDateTime birthdate;
	
	@Column(name = "nome_cliente")
	private String name;
	
	@Column(name = "fone_cliente")
	private String fone;
	
	@Column(name = "email_cliente")
	private String email;
	
	@Column(name = "complemento_endereco")
	private String addressComplement;
	
	@ManyToOne
	private Address address;
	
}
