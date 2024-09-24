package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Entity.Trainer;

import java.util.List;


public interface TrainerService {

    Trainer saveTrainer(Trainer trainer);

    List<Trainer> getAllTrainers();

    Trainer getTrainerById(Long id);

    Trainer updateTrainer(Trainer trainer);

    void deleteTrainer(Trainer trainer);


}
