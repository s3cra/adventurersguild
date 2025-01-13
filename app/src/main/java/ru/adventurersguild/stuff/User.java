package ru.adventurersguild.stuff;

import lombok.Data;

@Data
public class User {
    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
