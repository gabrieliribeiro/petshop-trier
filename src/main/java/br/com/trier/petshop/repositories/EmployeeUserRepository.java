package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Integer>{
	List<EmployeeUser> findByName (String name);
	List<EmployeeUser> findByNameStartingWithIgnoreCase(String name);
	Optional<EmployeeUser>  findByEmail (String email);
}
