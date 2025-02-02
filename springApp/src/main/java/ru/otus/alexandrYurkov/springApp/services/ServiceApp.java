package ru.otus.alexandrYurkov.springApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.alexandrYurkov.springApp.dtos.UserDto;
import ru.otus.alexandrYurkov.springApp.entity.User;
import ru.otus.alexandrYurkov.springApp.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ServiceApp {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final UsersRepository usersRepository;

//    public ServiceApp(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }

    public List<UserDto> getAllUsers() {
        return usersRepository.allUsers();
    }

    public UserDto getUserById(Long id) {
        Optional<User> user = usersRepository.findById(id);
        logger.info(user.toString());
        return user.map(value -> new UserDto(value.getUsername(), value.getAge())).orElse(null);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        if(getUserById(id) == null) {
            return null;
        }
        usersRepository.setUserInfoById(userDto.getUsername(), userDto.getAge(), id);
        return getUserById(id);
    }

    public UserDto addUser(UserDto userDto) {
        User user = new User(null, userDto.getUsername(), userDto.getAge());
        usersRepository.save(user);
        return getUserById(user.getId());
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
