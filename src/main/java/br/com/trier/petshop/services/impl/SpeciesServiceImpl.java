package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Species;
import br.com.trier.petshop.repositories.SpeciesRepository;
import br.com.trier.petshop.services.SpeciesService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesServiceImpl  implements SpeciesService {
    @Autowired
    SpeciesRepository repository;

    private void speciesValidation(Species obj){
        if (obj == null) {
            throw new IntegrityViolation("A espécie não pode ser nula!");
        }
    }

    @Override
    public Species save(Species species) {
        speciesValidation(species);
        return repository.save(species);
    }

    @Override
    public Species update(Species species) {
        speciesValidation(species);
        return repository.save(species);
    }

    @Override
    public Species findById(Integer id) {
        Optional<Species> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhuma espécie encontrada com esse id %s".formatted(id)));
    }

    @Override
    public List<Species> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Species> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public List<Species> findByDescriptionStartingWithIgnoreCase(String description) {
        return repository.findByDescriptionStartingWithIgnoreCase(description);
    }


    @Override
    public void delete(Integer id) {
        Species species = findById(id);
        repository.delete(species);
    }
}
