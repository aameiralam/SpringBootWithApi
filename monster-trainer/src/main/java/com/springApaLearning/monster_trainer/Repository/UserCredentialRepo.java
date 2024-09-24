package com.springApaLearning.monster_trainer.Repository;

import com.springApaLearning.monster_trainer.Entity.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserCredentialRepo extends ListCrudRepository<UserCredential, Long> {
    Optional<UserCredential> findByEmail(String email);


}
