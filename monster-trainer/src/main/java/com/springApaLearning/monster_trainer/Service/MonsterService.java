package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Entity.Monster;

import java.util.List;

public interface MonsterService {

    Monster saveMonster(Monster monster);

    List<Monster> getAllMonster();

    Monster getMonsterById(Long id);

    List <Monster> getMonsterBySpeciesType(String species);

    List<Monster> getMonsterWithPriceGreaterThan(Double price);

    // for testing tdd

    Monster updateMonster(Monster monster);

    //To delete

    void  deleteMonster(Long id);
}
