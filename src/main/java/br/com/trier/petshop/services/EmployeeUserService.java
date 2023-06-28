package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.EmployeeUser;

import java.util.List;

public interface EmployeeUserService {
	EmployeeUser save (EmployeeUser employeeUser);
	EmployeeUser update (EmployeeUser employeeUser);
	EmployeeUser findById(Integer id);
	List<EmployeeUser> listAll();
	List<EmployeeUser> findByName(String name);
	List<EmployeeUser> findByNameStartingWithIgnoreCase(String name);
	void delete (Integer id);
}
