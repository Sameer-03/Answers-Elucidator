/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DIscussionForum.AnwersElucidator.CustomExceptions.ResourceAlreadyExistsException;
import com.DIscussionForum.AnwersElucidator.CustomExceptions.ResourceNotFoundException;
import com.DIscussionForum.AnwersElucidator.Dto.Users;
import com.DIscussionForum.AnwersElucidator.Repository.UsersDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginRegisterController {
    
    @Autowired
    UsersDataRepo userData;
    
    @PostMapping(path="/login")
    public ResponseEntity<Void> checkAndLogin(@RequestBody Users user)
    {
        boolean present = userData.existsByUnameAndPassword(user.getUname(), user.getPassword());
        if(!present)
        {
            throw new ResourceNotFoundException("Incorrect Credentials !");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(path="/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user)
    {
        boolean present=userData.existsById(user.getUname());
        if(present)
        {
            throw new ResourceAlreadyExistsException("Username Taken !");
        }
        userData.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}    
/************* SENDING RESPONSE IN STRING FORMAT *******************
    
    @PostMapping(path="/login")
    public ResponseEntity<String> checkAndLogin(@RequestBody Users user)
    {
        boolean present = userData.existsByUnameAndPassword(user.getUname(), user.getPassword());
        if(present)
        {
            return new ResponseEntity<>("Success !",HttpStatus.OK);
        }
        return new ResponseEntity<>("Incorrect Credentials ! ",HttpStatus.NOT_FOUND);
    }
    
    @PostMapping(path="/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user)
    {
        boolean present=userData.existsById(user.getUname());
        if(present)
        {
            return new ResponseEntity<String>("User Already Exists !",HttpStatus.SEE_OTHER);
        }
        userData.save(user);
        return new ResponseEntity<String>("Success !", HttpStatus.CREATED);
    }
*/    
