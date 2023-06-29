package br.com.trier.petshop.repositories;

import br.com.trier.petshop.domain.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

    List<Race> findByRaceName (String raceName);
    List<Race> findByRaceNameStartingWithIgnoreCase (String raceName);
    List<Race> findByRaceNameContainsIgnoreCase (String raceName);
}
