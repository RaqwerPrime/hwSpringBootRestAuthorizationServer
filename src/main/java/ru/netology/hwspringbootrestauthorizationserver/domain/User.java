package ru.netology.hwspringbootrestauthorizationserver.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {
    @NotBlank(message = "Логин не может быть пустым!")
    @Size(min = 3, max = 15, message = "Логин должен быть не менее 3 и небольше 15 символов!")
    private String login;
    @NotBlank(message = "Пароль не может быть пустым!")
    @Size(min = 4, max = 20, message = "Пароль должен быть не менее 4 и небольше 20 символов!" )
    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
