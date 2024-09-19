package com.springApaLearning.monster_trainer.Repository;

import com.springApaLearning.monster_trainer.Entity.Monster;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface MonsterRepository extends ListCrudRepository<Monster, Long> {


    List<Monster> findBySpecies(String species);
//    Can use Optionalg<Monster> findBySpecies(String species); nc
    List<Monster> findByPriceGreaterThan(Double price);

}
