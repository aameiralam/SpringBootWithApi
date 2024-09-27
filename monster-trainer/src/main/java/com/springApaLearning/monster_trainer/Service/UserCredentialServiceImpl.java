package com.springApaLearning.monster_trainer.Service;

import com.springApaLearning.monster_trainer.Config.JwtService;
import com.springApaLearning.monster_trainer.Entity.UserCredential;
import com.springApaLearning.monster_trainer.Repository.UserCredentialRepo;
import com.springApaLearning.monster_trainer.dto.AuthRequest;
import com.springApaLearning.monster_trainer.dto.PostNewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {
    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void createUser(PostNewUser postNewUser) { //saves credentials

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail(postNewUser.email());
        userCredential.setPassword(passwordEncoder.encode(postNewUser.password()));
        userCredential.setRoles(postNewUser.role());
        userCredentialRepo.save(userCredential);
    }

    @Override
    public String login(AuthRequest authRequest) { //verifies the credentials
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.email(),
                authRequest.password()
        );
        authenticationManager.authenticate(authenticationToken);
        String jwt = jwtService.generateToken(authRequest.email());
        return jwt;
    }
}
