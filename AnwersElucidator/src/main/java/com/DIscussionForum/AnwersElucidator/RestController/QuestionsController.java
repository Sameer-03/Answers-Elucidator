/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DIscussionForum.AnwersElucidator.CustomExceptions.ResourceNotFoundException;
import com.DIscussionForum.AnwersElucidator.Dto.Questions;
import com.DIscussionForum.AnwersElucidator.Repository.QuestionDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class QuestionsController {
    
    @Autowired
    QuestionDataRepo quesData;
    
    @GetMapping(path="/questions")
    public List<Questions> getAllQuestions() 
    {
        return quesData.findAll();
    }
    
    @PostMapping(path="/questions")
    public ResponseEntity<Questions> saveQuestion(@RequestBody Questions ques)
    {
        Questions x=quesData.save(ques);
        return new ResponseEntity<Questions>(x,HttpStatus.OK);
    }
    
    @GetMapping(path="/questions/{qid}")
    public Optional<Questions> getQuestion(@PathVariable int qid)
    {
        Optional<Questions> ques=quesData.findById(qid);
        if(!ques.isPresent())
        {
            throw new ResourceNotFoundException("Question Not Found !");
        }
        return ques;
    }
    
}

/******************FIND BY QID*****************************

    @GetMapping(path="/questions/{qid}")
    public ResponseEntity<Questions> getQuestion(@PathVariable int qid)
    {
        Questions ques=quesData.findById(qid);
        if(ques!=null)
        {
            return new ResponseEntity<Questions>(ques,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

*/
