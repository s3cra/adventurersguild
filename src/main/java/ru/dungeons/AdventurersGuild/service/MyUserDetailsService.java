package ru.dungeons.AdventurersGuild.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dungeons.AdventurersGuild.config.MyUserDetails;
import ru.dungeons.AdventurersGuild.repository.UserRepository;
import ru.dungeons.AdventurersGuild.serverEntities.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repo.findByLogin(username);
        return user.map(MyUserDetails::new).
                orElseThrow(() -> new UsernameNotFoundException(username + "not found."));
    }


}
