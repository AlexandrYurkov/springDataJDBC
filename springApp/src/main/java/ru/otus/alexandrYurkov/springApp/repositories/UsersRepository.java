package ru.otus.alexandrYurkov.springApp.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.alexandrYurkov.springApp.dtos.UserDto;
import ru.otus.alexandrYurkov.springApp.entity.User;

import java.util.List;
@Repository
public interface UsersRepository extends ListCrudRepository<User, Long> {
    @Query("SELECT u.name as username, u.age from users u;")
    List<UserDto> allUsers();

    @Modifying
    @Query("update users set name = :username, age = :age where id = :id;")
    void setUserInfoById(@Param("username") String username, @Param("age") String age, @Param("id")Long id);
}
