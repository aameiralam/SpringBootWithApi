package com.springApaLearning.monster_trainer.dto;

public record PostNewUser(
        String email,
        String password,
        String role
) {
}
