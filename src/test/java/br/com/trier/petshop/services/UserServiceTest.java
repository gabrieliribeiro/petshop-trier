package br.com.trier.petshop.services;

import br.com.trier.petshop.BaseTests;
import br.com.trier.petshop.domain.EmployeeUser;
import br.com.trier.petshop.services.EmployeeUserService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class UserServiceTest extends BaseTests{
	
	@Autowired
	EmployeeUserService employeeUserService;
	
	@Test
	@DisplayName("Teste busca por ID")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void findByIdTest() {
		var user = employeeUserService.findById(1);
		assertNotEquals(user, null);
		assertEquals(1, user.getId());
		assertEquals("Usuario teste 1", user.getName());
		assertEquals("teste1@teste.com", user.getEmail());
		assertEquals("1234", user.getPassword());		
	}
	
	@Test
	@DisplayName("Teste busca por ID inválido")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void findNotValidIdTest() {
		var exception = assertThrows(ObjectNotFound.class,	() -> employeeUserService.findById(10));
		assertEquals("Usuário 10 não encontrado", exception.getMessage());
	}
	
	@Test
	@DisplayName("Teste listar todos")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void listAllTest() {
		List<EmployeeUser> lista = employeeUserService.listAll();
		assertEquals(2, lista.size());
		assertEquals(1, lista.get(0).getId());
	}
	
	@Test
	@DisplayName("Teste incluir usuário")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	void insertUserTest() {
		var user = new EmployeeUser(null, "nome", "email", "senha");
		employeeUserService.save(user);
		user = employeeUserService.findById(1);
		assertNotEquals(user, null);
		assertEquals(1, user.getId());
		assertEquals("nome", user.getName());
		assertEquals("email", user.getEmail());
		assertEquals("senha", user.getPassword());
		
	}
	
	@Test
	@DisplayName("Teste alterar usuário")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void updateUserTest() {
		var user = new EmployeeUser(1, "altera", "altera", "altera");
		employeeUserService.update(user);
		var alteredUser = employeeUserService.findById(1);
		assertNotEquals(user, null);
		assertEquals(1, user.getId());
		assertEquals("altera", user.getName());
		assertEquals("altera", user.getEmail());
		assertEquals("altera", user.getPassword());
	}
	
	@Test
	@DisplayName("Teste deleta usuário")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void deleteUserTest() {
		employeeUserService.delete(1);
		List<EmployeeUser> lista  = employeeUserService.listAll();
		assertEquals(1, lista.size());
		assertEquals(2, lista.get(0).getId());
	}
	
	@Test
	@DisplayName("Busca nome do usuário que inicia com ")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void startWithTest() {
		List<EmployeeUser> lista = employeeUserService.findByNameStartingWithIgnoreCase("U");
		assertEquals(2, lista.size());
		lista = employeeUserService.findByNameStartingWithIgnoreCase("Usuario");
		assertEquals(2, lista.size());
	}
	
	@Test
	@DisplayName("Cadastro com email repetido")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void insertNewUserWithDuplicateEmailTest() {
		var user = new EmployeeUser(null, "Gabrieli", "teste1@teste.com", "1234");
		var exception = assertThrows(IntegrityViolation.class, ()-> employeeUserService.save(user));
		assertEquals("E-mail já cadastrado: teste1@teste.com", exception.getMessage());
	}
	
	@Test
	@DisplayName("Alterar usuário inexistente")
	@Sql(scripts = "classpath:sql/funcionario.sql")
	void updateNonexistentUser() {
		var user = new EmployeeUser(5, "Gabrieli", "teste5@teste.com", "1234");
		var exception = assertThrows(ObjectNotFound.class,	() -> employeeUserService.findById(5));
		assertEquals("Usuário 5 não encontrado", exception.getMessage());
	}
	
}
