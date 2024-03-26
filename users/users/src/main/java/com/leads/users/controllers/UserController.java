package com.leads.users.controllers;

import com.leads.users.dtos.UserDto;
import com.leads.users.models.User;
import com.leads.users.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository r;

    private UserDto userDto;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto){
        var user = new User();
        BeanUtils.copyProperties(userDto,user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(r.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers (){
        List<User> userList = r.findAll();
        if(!userList.isEmpty()){
            for(User user: userList){
                UUID id = user.getId();
                user.add(linkTo(methodOn(UserController.class).getOneUser(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object>getOneUser(@PathVariable(value="id") UUID id){
        Optional<User> user0 = r.findById(id);
        if(user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user0.get());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value="id")UUID id, @RequestBody @Valid UserDto userDto){
        Optional<User> user0 = r.findById(id);
        if(user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var user = user0.get();
        BeanUtils.copyProperties(userDto,user);
        return  ResponseEntity.status(HttpStatus.OK).body(r.save(user));

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value="id")UUID id){
        Optional<User> user0 = r.findById(id);
        if(user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        r.delete(user0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário Removido com sucesso!");

    }

}
