package br.com.trier.petshop.services.impl;

import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.repositories.RaceRepository;
import br.com.trier.petshop.services.RaceService;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService {
    @Autowired
    RaceRepository repository;

    private void raceValidation(Race obj){
        if (obj == null) {
            throw new IntegrityViolation("A raça não pode ser nula!");
        }
    }

    @Override
    public Race save(Race race) {
        raceValidation(race);
        return repository.save(race);
    }

    @Override
    public Race update(Race race) {
        raceValidation(race);
        return repository.save(race);
    }

    @Override
    public Race findById(Integer id) {
        Optional<Race> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Nenhuma raça encontrada com esse id %s".formatted(id)));
    }

    @Override
    public List<Race> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Race> findByRaceName(String raceName) {
        return repository.findByRaceName(raceName);
    }

    @Override
    public List<Race> findByRaceNameStartingWithIgnoreCase(String raceName) {
        return repository.findByRaceName(raceName);
    }
    @Override
    public List<Race> findByRaceNameContainsIgnoreCase(String raceName) {
        return repository.findByRaceName(raceName);
    }


    @Override
    public void delete(Integer id) {
        Race race= findById(id);
        repository.delete(race);
    }
}
