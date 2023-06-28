package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.EmployeeUser;
import br.com.trier.petshop.repositories.EmployeeUserRepository;
import br.com.trier.petshop.services.EmployeeUserService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUserServiceImpl implements EmployeeUserService{
	
	@Autowired
    EmployeeUserRepository repository;
	
	private void findByEmail(EmployeeUser obj) {
		Optional<EmployeeUser> employeeUserOptional = repository.findByEmail(obj.getEmail());
		if (employeeUserOptional.isPresent()) {
			EmployeeUser employeeUser = employeeUserOptional.get();
			if (employeeUser.getId() != obj.getId()) {
				throw new IntegrityViolation("E-mail já cadastrado: %s".formatted(obj.getEmail()));
			}
		}
	}
	
	@Override
	public List<EmployeeUser> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<EmployeeUser> findByNameStartingWithIgnoreCase(String name) {
		return repository.findByNameStartingWithIgnoreCase(name);
	}

	@Override
	public EmployeeUser findById(Integer id) {
		Optional<EmployeeUser> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound("Usuário %s não encontrado".formatted(id)));
	}

	@Override
	public List<EmployeeUser> listAll() {
		return repository.findAll();
	}

	@Override
	public EmployeeUser save(EmployeeUser employeeUser) {
		findByEmail(employeeUser);
		return repository.save(employeeUser);
	}
	
	@Override
	public EmployeeUser update(EmployeeUser employeeUser) {
		findByEmail(employeeUser);
		return repository.save(employeeUser);
	}
	
	@Override
	public void delete(Integer id) {
		EmployeeUser employeeUser = findById(id);
		repository.delete(employeeUser);
	}
	
}
