package com.andrew.demo;


import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final  UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all(){
        return repository.findAll();
    }

    @PostMapping("/user")
    User newUsers(@RequestBody User newUser){
        return repository.save(newUser);
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return repository.findById(id).map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setContactNumber(newUser.getContactNumber());
                    return repository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/employees/{id}")
        void deleteUser (@PathVariable Long id){
            repository.deleteById(id);
        }




}



