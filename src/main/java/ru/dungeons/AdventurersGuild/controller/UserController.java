package ru.dungeons.AdventurersGuild.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dungeons.AdventurersGuild.serverEntities.User;
import ru.dungeons.AdventurersGuild.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private UserService service;

    @PostMapping("/register")
    public String createUser(@RequestBody User user){
        service.createUser(user);
        return "success";
    }

    @GetMapping
    public List<User> getUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        return service.verifyUser(user);
    }

}
