package ru.otus.alexandrYurkov.springApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "USERS")
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    @Column(value = "NAME")
    private String username;
    @Column(value = "AGE")
    private String age;

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age ='" + age + '\'' +
                '}';
    }
}
