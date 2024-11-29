package ru.dungeons.AdventurersGuild.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dungeons.AdventurersGuild.serverEntities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
