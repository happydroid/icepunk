package io.threatrix.app.controllers;

import io.threatrix.app.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
class UserController {
    /**
     * crud - create, read, update, delete
     * */

    //private final UserRepository repository;

    @GetMapping("/users")
    List<User> all() {
        return null;
        //return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return null;
        //return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return null;
        //return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return null;
        /*return repository.findById(id)
                .map(employee -> {
                    employee.setName(newUser.getName());
                    employee.setRole(newUser.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });*/
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        //repository.deleteById(id);
    }
}