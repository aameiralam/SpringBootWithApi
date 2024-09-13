package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Entity.Monster;

import java.util.List;

public interface MonsterService {

    Monster saveMonster(Monster monster);

    List<Monster> getAllMonster();

    Monster getMonsterById(Long id);

}
