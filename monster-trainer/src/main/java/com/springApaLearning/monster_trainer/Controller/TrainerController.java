package com.springApaLearning.monster_trainer.Controller;

import com.springApaLearning.monster_trainer.Entity.Trainer;
import com.springApaLearning.monster_trainer.Service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/trainer")
public class TrainerController {

    @Autowired
    @Qualifier("ADMIN") //helps you find the ADMIN username
    private TrainerService trainerService;

    @PostMapping("/")

    public ResponseEntity<Trainer> postNewTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.saveTrainer(trainer));
    }

    @GetMapping("/")

    public ResponseEntity<List<Trainer>> getTrainer() {
        return ResponseEntity.ok(trainerService.getAllTrainers());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getTrainerById(id));


    }

    @PutMapping("/update")
    public ResponseEntity<Trainer> putUpdateTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.saveTrainer(trainer));
    }

    @DeleteMapping("/delete") //? if you dont want to return anything, body
    public ResponseEntity<?> deleteTrainer(@RequestBody Trainer trainer){
        trainerService.deleteTrainer(trainer);
        return ResponseEntity.ok().build();
    }

}




