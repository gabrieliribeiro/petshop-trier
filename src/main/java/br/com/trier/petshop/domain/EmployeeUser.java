package br.com.trier.petshop.domain;

import br.com.trier.petshop.domain.dto.EmployeeUserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "funcionario")
public class EmployeeUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_funcionario")
	@Setter
	private Integer id;
	
	@Column(name = "nome_funcionario")
	private String name;
	
	@Column(name = "email_funcionario", unique = true)
	private String email;
	
	@Column(name = "senha_funcionario")
	private String password;
	
	public EmployeeUser(EmployeeUserDTO dto) {
		 this(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword());
	}
	
	public EmployeeUserDTO toDto() {
		return new EmployeeUserDTO(this.id, this.name, this.email, this.password);
	}
	
}
