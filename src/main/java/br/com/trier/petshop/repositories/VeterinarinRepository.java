package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.domain.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarinRepository extends JpaRepository<Veterinarian, Integer> {
    List<Veterinarian> findByName(String name);
    List<Veterinarian> findByNameStartingWithIgnoreCase(String name);
    List<Veterinarian> findByCrm(String crm);
    List<Veterinarian> findBySpeciality(Speciality speciality);
}
