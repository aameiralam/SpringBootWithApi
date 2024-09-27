package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.dto.AuthRequest;
import com.springApaLearning.monster_trainer.dto.PostNewUser;

public interface UserCredentialService {

    void createUser(PostNewUser postNewUser);

    String login (AuthRequest authRequest);

}
