package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
    List<Speciality> findByDescription(String description);
    List<Speciality> findByDescriptionStartingWithIgnoreCase(String description);
}
