package br.com.trier.petshop.services;


import br.com.trier.petshop.domain.Race;

import java.util.List;

public interface RaceService {
    Race save (Race race);
    Race update (Race race);
    Race findById(Integer id);
    List<Race> listAll();
    List<Race> findByRaceName (String raceName);
    List<Race> findByRaceNameStartingWithIgnoreCase (String raceName);
    List<Race> findByRaceNameContainsIgnoreCase (String raceName);
    void delete (Integer id);
}
