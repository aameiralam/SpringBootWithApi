package com.springApaLearning.monster_trainer.Controller;


import com.springApaLearning.monster_trainer.Entity.Monster;
import com.springApaLearning.monster_trainer.Service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


}
