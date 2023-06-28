package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.Speciality;
import br.com.trier.petshop.domain.Veterinarian;

import java.util.List;

public interface VeterinarianService {
    Veterinarian save (Veterinarian veterinarian);
    Veterinarian update (Veterinarian veterinarian);
    Veterinarian findById(Integer id);
    List<Veterinarian> listAll();
    List<Veterinarian> findByName(String name);
    List<Veterinarian> findByNameStartingWithIgnoreCase(String name);
    List<Veterinarian> findByCrm(String crm);
    List<Veterinarian> findBySpeciality(Speciality speciality);
    void delete(Integer id);
}
