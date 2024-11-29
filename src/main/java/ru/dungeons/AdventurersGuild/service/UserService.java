package ru.dungeons.AdventurersGuild.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dungeons.AdventurersGuild.repository.UserRepository;
import ru.dungeons.AdventurersGuild.serverEntities.User;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repo;
    private PasswordEncoder encoder;
    private AuthenticationManager manager;
    private JWTService jwtService;

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public User getUser(Long id){
        return repo.findById(id).orElse(null);
    }

    public void createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }

    public User updateUser(User user){
        return repo.save(user);
    }

    public void deleteUser(User user){
        repo.delete(user);
    }

    public String verifyUser(User user){
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getLogin());
        return "suckcock";
    }
}
