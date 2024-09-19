package com.springApaLearning.monster_trainer.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //it has to be wrapper class as generics are used in the repository
    private String name;
    private Integer noOfYears;
    private Integer wins;
    private Integer losses;

    @OneToMany(fetch = FetchType.EAGER) //it will grab all the data for monster list before sending it back
    private List<Monster> monsterList;

}
