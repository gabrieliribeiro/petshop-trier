package br.com.trier.petshop.services;

import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.domain.Species;

import java.util.List;

public interface SpeciesService {
    Species save (Species species);
    Species update (Species species);
    Species findById(Integer id);
    List<Species> listAll();
    List<Species> findByDescription (String description);
    List<Species> findByDescriptionStartingWithIgnoreCase (String description);
    void delete (Integer id);
}
