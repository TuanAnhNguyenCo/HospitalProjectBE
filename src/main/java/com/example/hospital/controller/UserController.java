package com.example.hospital.controller;

import com.example.hospital.entity.Account;
import com.example.hospital.entity.Role;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private IUserService iUserService;


    @GetMapping()
    public ResponseEntity<?> GetUser(Authentication authentication) {
        String username = authentication.getName();
        Account account = iUserService.GetAccountByName(username);
        if(account==null)
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(account, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<?> Save(@RequestBody Account account) {

        Account myAccount = iUserService.SaveAccount(account);
        if(myAccount==null)
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(myAccount, HttpStatus.OK);

    }

    @PostMapping(path = "/role/save",consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> Save( Role role) {
        Role myRole = iUserService.AddRole(role);
        if(myRole==null)
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(myRole, HttpStatus.OK);

    }



}
