package ru.otus.alexandrYurkov.springApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String age;

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
