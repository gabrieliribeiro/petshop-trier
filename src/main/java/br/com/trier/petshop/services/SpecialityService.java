package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.Speciality;


import java.util.List;

public interface SpecialityService {
    Speciality save (Speciality speciality);
    Speciality update (Speciality speciality);
    Speciality findById(Integer id);
    List<Speciality> listAll();
    List<Speciality> findByDescription(String description);
    List<Speciality> findByDescriptionStartingWithIgnoreCase(String description);
    void delete (Integer id);
}
