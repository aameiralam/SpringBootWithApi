package com.springApaLearning.monster_trainer.dto;

public record AuthRequest(
        String email,
        String password
) {
}
