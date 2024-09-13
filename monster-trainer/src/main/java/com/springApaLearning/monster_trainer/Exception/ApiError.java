package com.springApaLearning.monster_trainer.Exception;

import java.time.LocalDateTime;

public record ApiError(
        String message,
        int statusCode,
        String path,
        LocalDateTime timestamp
) {
}
