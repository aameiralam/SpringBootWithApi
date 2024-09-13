package com.springApaLearning.monster_trainer.Repository;

import com.springApaLearning.monster_trainer.Entity.Monster;
import org.springframework.data.repository.ListCrudRepository;

public interface MonsterRepository extends ListCrudRepository<Monster, Long> {



}
