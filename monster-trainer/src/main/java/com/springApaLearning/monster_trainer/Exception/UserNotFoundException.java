package com.springApaLearning.monster_trainer.Exception;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String message){
        super(message);
    }
}
