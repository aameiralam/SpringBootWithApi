package com.springApaLearning.monster_trainer.Controller;


import com.springApaLearning.monster_trainer.Entity.Monster;
import com.springApaLearning.monster_trainer.Service.MonsterService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/monster")

public class MonsterController {
    @Autowired
    private MonsterService monsterService;

    @PostMapping("/")
    public ResponseEntity<Monster> postNewMonster(@RequestBody Monster monster) {
//    try{
//        return ResponseEntity.ok(monsterService.saveMonster(monster));      //.ok->returns a status code 200 if success
//    } catch(RuntimeException e){
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
        //}
        return ResponseEntity.ok(monsterService.saveMonster(monster));
    }

    @GetMapping("/")
    public ResponseEntity<List<Monster>> getMonster(){
        return ResponseEntity.ok(monsterService.getAllMonster());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable Long id){
        return ResponseEntity.ok(monsterService.getMonsterById(id));
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<List<Monster>> getMonstersBySpecies(@PathVariable String species){
        return ResponseEntity.ok(monsterService.getMonsterBySpeciesType(species));
    }
    @GetMapping("/price/{price}")
    public ResponseEntity<List<Monster>> getMonstersByGreaterPrice (@PathVariable Double price){
        return ResponseEntity.ok(monsterService.getMonsterWithPriceGreaterThan(price));
    }

    @PutMapping("/update")
    public ResponseEntity<Monster> postUpdateMonster(@RequestBody Monster monster){
        return ResponseEntity.ok(monsterService.updateMonster(monster));
    }

    @DeleteMapping("/delete/{id}") //we have void which is why ? is used
    public ResponseEntity<?> postDeleteMonster(@PathVariable Long id){
         monsterService.deleteMonster(id);
         return  ResponseEntity.ok().body("Monster has been deleted");
    }



}
