package com.springApaLearning.monster_trainer;

import com.springApaLearning.monster_trainer.Entity.Monster;
import com.springApaLearning.monster_trainer.Entity.Trainer;
import com.springApaLearning.monster_trainer.Repository.MonsterRepository;
import com.springApaLearning.monster_trainer.Repository.TrainerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class MonsterTrainerApplication implements CommandLineRunner {

	private MonsterRepository monsterRepository;
	private TrainerRepository trainerRepository;

	public MonsterTrainerApplication(MonsterRepository monsterRepository, TrainerRepository trainerRepository){
		this.monsterRepository=monsterRepository;
		this.trainerRepository=trainerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MonsterTrainerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		monsterRepository.saveAll(List.of(
				new Monster(0L,"SkellyFace", "Skeleton", 80.00, 5.9, 50.00, 10L, 5L, null),
				new Monster(0L, "Impy", "Imp", 50.00, 2.75, 25.00, 5L, 5L, null),
				new Monster(0L, "Jeff", "Minotar", 500.00, 9.5, 500.00, 45L, 35L, null)
		));

		Trainer trainer = trainerRepository.save(new Trainer(0L, "Ash Ketchum", 25, 100, 50, new ArrayList<>()));
		Monster monster = monsterRepository.save(new Monster(0L, "Pikachu", "Electric Mouse", 15.00, 2.25, 100000.00, 2500L, 3500L, trainer));
		trainer.getMonsterList().add(monster);
		trainer = trainerRepository.save(trainer);

		log.info(monsterRepository.findBySpecies("Skeleton").toString());
		log.info(monsterRepository.findByPriceGreaterThan(40.00).toString());
		log.info(trainer.toString());
	}
}
