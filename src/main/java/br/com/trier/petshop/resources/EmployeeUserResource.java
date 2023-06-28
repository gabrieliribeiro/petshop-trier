package br.com.trier.petshop.resources;

import br.com.trier.petshop.domain.EmployeeUser;
import br.com.trier.petshop.domain.dto.EmployeeUserDTO;
import br.com.trier.petshop.services.EmployeeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class EmployeeUserResource {
	
	@Autowired
	private EmployeeUserService services;
	
	@PostMapping
	public ResponseEntity<EmployeeUserDTO> insert(@RequestBody EmployeeUserDTO user){
		EmployeeUser newUser = services.save(new EmployeeUser(user));
		return newUser!=null ? ResponseEntity.ok(newUser.toDto()) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeUserDTO> update(@PathVariable Integer id, @RequestBody EmployeeUserDTO employeeUserDTO) {
		EmployeeUser employeeUser = new EmployeeUser(employeeUserDTO);
		employeeUser.setId(id);
		employeeUser = services.update(employeeUser);

		return employeeUser != null ? ResponseEntity.ok(employeeUser.toDto()) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeUserDTO> findById(@PathVariable Integer id) {
		EmployeeUser employeeUser = services.findById(id);
		return ResponseEntity.ok(employeeUser.toDto());
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeUserDTO>> listAll(){
		return ResponseEntity.ok(services.listAll().stream()
				.map((user) -> user.toDto())
				.toList());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<EmployeeUserDTO>> findByNameStartingWithIgnoreCase(@PathVariable String name){
		return ResponseEntity.ok(services.findByNameStartingWithIgnoreCase(name).stream()
				.map((user) -> user.toDto())
				.toList());
	}
}
