package ru.dungeons.AdventurersGuild.repository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import ru.dungeons.AdventurersGuild.characterData.Character;
import ru.dungeons.AdventurersGuild.config.MyUserDetails;
import ru.dungeons.AdventurersGuild.serverEntities.User;

import java.util.List;

@Repository
@Primary
public class CharacterUsersRepository implements CharacterRepositoryI{
    private User user;
    @Autowired
    private UserRepository repo;

    @Override
    public List<Character> getCharacters() {
        updateContext();
        return user.getCharacters();
    }

    @Override
    public Character saveCharacter(Character character) {
        updateContext();
        user.addCharacter(character);
        repo.save(user);
        return character;
    }

    @Override
    public Character getCharacter(String name) {
        updateContext();
        return user.getCharacters().stream().filter(character -> character.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Character updateCharacter(Character character) {
        updateContext();
        user.updateCharacter(character);
        return character;
    }

    @Override
    public void deleteCharacter(String name) {
        updateContext();
        user.removeCharacter(name);
    }

    private void updateContext(){
        user = ((MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}
