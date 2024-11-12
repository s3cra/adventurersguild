package ru.dungeons.AdventurersGuild;

import characterData.statGrid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import characterData.Character;
import ru.dungeons.AdventurersGuild.controller.CharacterController;

@SpringBootApplication
public class AdventurersGuildApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdventurersGuildApplication.class, args);

	}

}
