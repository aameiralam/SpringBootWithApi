package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Entity.Monster;
import com.springApaLearning.monster_trainer.Repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
