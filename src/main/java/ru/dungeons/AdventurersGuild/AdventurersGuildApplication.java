package ru.dungeons.AdventurersGuild;

import characterData.statGrid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import characterData.Character;

@SpringBootApplication
public class AdventurersGuildApplication {

	public static void main(String[] args) {
		new Character("bro", "Elf", "Wizard", new statGrid(
				15,15,15,15,15,15
		), "","","","");
		SpringApplication.run(AdventurersGuildApplication.class, args);
	}

}
