package ru.otus.alexandrYurkov.springApp.controlliers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.otus.alexandrYurkov.springApp.dtos.UserDto;
import ru.otus.alexandrYurkov.springApp.services.ServiceApp;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {
    private final ServiceApp serviceApp;

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return serviceApp.getAllUsers();
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable Long id) {
        return serviceApp.getUserById(id) != null ? serviceApp.getUserById(id) : "not found";
    }

    @PostMapping("/update/{id}")
    public Object updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        System.out.println("updateUser" + userDto);
        return serviceApp.updateUser(id, userDto) == null ? "not found" : serviceApp.updateUser(Long.valueOf(id), userDto);
    }

    @PostMapping("/save")
    public Object saveUser(@RequestBody UserDto userDto) {
        UserDto newUser = serviceApp.addUser(userDto);
        if(newUser != null) {
            return newUser;
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "user already exists");
        }
    }

    @GetMapping("delete/{id}")
    public Object deleteUser(@PathVariable Long id) {
        if(serviceApp.getUserById(id) != null) {
            serviceApp.deleteUser(id);
            return HttpStatus.ACCEPTED;
        }else
            return HttpStatus.BAD_REQUEST;
    }
}
