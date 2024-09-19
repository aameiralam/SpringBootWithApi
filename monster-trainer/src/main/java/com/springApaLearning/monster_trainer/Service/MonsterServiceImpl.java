package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Entity.Monster;
import com.springApaLearning.monster_trainer.Repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {


    @Autowired
    private MonsterRepository monsterRepository;


    @Override
    public Monster saveMonster(Monster monster) {

        return monsterRepository.save(monster);
    }

    @Override
    public List<Monster> getAllMonster() {

        return monsterRepository.findAll();
    }

    @Override
    public Monster getMonsterById(Long id) {
        return monsterRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Monster with id of" + id + "has not been found"));
    }

    @Override
    public List <Monster> getMonsterBySpeciesType(String species) {

        return monsterRepository.findBySpecies(species);
    }

    @Override
    public List<Monster> getMonsterWithPriceGreaterThan(Double price) {
        return monsterRepository.findByPriceGreaterThan(price);
    }


    // UPDATING METHOD WITH TDD
    @Override
    public Monster updateMonster(Monster monster) {
        Monster oldMonsterData = monsterRepository.findById(monster.getId()).orElseThrow(()->
                new EntityNotFoundException("Id not found"));
        return monsterRepository.save(monster);

    }

    @Override
    public void deleteMonster(Long id) {


        if(!monsterRepository.existsById(id)) throw new EntityNotFoundException("Monster with ID" + id
        + "has not been found"); //if exception thrown it goes to the next line
        monsterRepository.deleteById(id);
    }
}
