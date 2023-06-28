package br.com.trier.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUserDTO {
	private Integer id;
	private String name;
	private String email;
	private String password;
}
