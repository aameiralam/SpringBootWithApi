package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Entity.Trainer;
import com.springApaLearning.monster_trainer.Repository.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainerServiceImpl implements TrainerService {


    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public Trainer saveTrainer(Trainer trainer) {
       return trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long id) {
         return trainerRepository.findById(id).orElseThrow(()->
                 new EntityNotFoundException("Trainer with the ID" + id + "has not been found"));
    }
}
