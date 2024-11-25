package ru.dungeons.AdventurersGuild.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dungeons.AdventurersGuild.repository.PlayerRepository;
import ru.dungeons.AdventurersGuild.serverEntities.Player;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    PlayerRepository repo;

    public List<Player> getAllPlayers(){
        return repo.findAll();
    }

    public Player getPlayer(Long id){
        return repo.findById(id).orElse(null);
    }

    public Player savePlayer(Player player){
        return repo.save(player);
    }

    public Player updatePlayer(Player player){
        return repo.save(player);
    }

    public void deletePlayer(Player player){
        repo.delete(player);
    }
}
