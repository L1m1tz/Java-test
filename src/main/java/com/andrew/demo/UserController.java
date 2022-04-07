package com.andrew.demo;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {

    private final  UserRepository repository;
    private final UserModelAssembler assembler;

    UserController(UserRepository repository, UserModelAssembler assembler){

        this.repository = repository;
        this.assembler =assembler;
    }

    @GetMapping("/users")
    CollectionModel<EntityModel<User>> all(){

        List<EntityModel<User>> users = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(users,
                        linkTo(methodOn(UserController.class).all()).withSelfRel());
        
    }

    @PostMapping("/user")
    User newUsers(@RequestBody User newUser){
        return repository.save(newUser);
    }

    //single user
    @GetMapping("/users/{id}")
    EntityModel<User> one(@PathVariable Long id) {

        User user = repository.findById(id) //
                .orElseThrow(() -> new UserNotFoundException(id));

        return assembler.toModel(user);
    }

    @PutMapping("/users/{id}")
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



