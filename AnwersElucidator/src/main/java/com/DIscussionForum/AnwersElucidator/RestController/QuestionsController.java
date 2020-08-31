/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DIscussionForum.AnwersElucidator.CustomExceptions.ResourceNotFoundException;
import com.DIscussionForum.AnwersElucidator.Dto.Questions;
import com.DIscussionForum.AnwersElucidator.Repository.QuestionDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class QuestionsController {
    
    @Autowired
    QuestionDataRepo quesData;
    
    // Find all questions
    @GetMapping(path="/questions")
    public List<Questions> getAllQuestions() 
    {
        return quesData.findAll();
    }
    
    

    
/*
 * Get By username
 */
    @GetMapping(path="users/{username}/queries")
    public List<Questions> getAllQuestions(@PathVariable String username) 
    {
    	System.out.println("Entered");
        return quesData.findByUsername(username);
    }
/*
 * get by qid and uname
 */

    @GetMapping(path="users/{username}/queries/{qid}")
    public Questions getQuestionsByNameAndId(@PathVariable String username,@PathVariable int qid) 
    {	
    	
        return quesData.findByUsernameAndQid(username,qid);
    }
    
/*
 * Put Mapping 
 */
    @PutMapping(path="users/{username}/queries/{id}")
	public ResponseEntity<Questions>  updateQuestions(@PathVariable String username,@PathVariable int qid,@RequestBody Questions query){
		Optional<Questions> _query = quesData.findById(qid);
		if(_query.isPresent())
		{
			Questions q=_query.get();
			q.setCategory(query.getCategory());
			q.setDescription(query.getDescription());
			q.setTitle(query.getTitle());
			return new ResponseEntity<Questions>(query,HttpStatus.OK);
		}
		return new ResponseEntity<Questions>(query,HttpStatus.NOT_FOUND);
	}
	
/*
 * Post Mapping
 */
    @PostMapping(path="/users/{username}/queries")
    public ResponseEntity<Questions> saveQuestionByUsername(@RequestBody Questions ques)
    {
        Questions x=quesData.save(ques);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(x.getQid()).toUri();
        return ResponseEntity.created(uri).build();
    }
/*
 * Delete Mapping By qid
 */
    @DeleteMapping("/users/{username}/queries/{id}")
	public ResponseEntity<Void> deleteQuestions(@PathVariable String username,@PathVariable int qid ){
		try {
			quesData.deleteById(qid);
			return ResponseEntity.noContent().build();
		}
    	catch(Exception ex)
		{
    		return ResponseEntity.notFound().build();
		}
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


Post Question

@PostMapping(path="/questions")
public ResponseEntity<Questions> saveQuestion(@RequestBody Questions ques)
{
    Questions x=quesData.save(ques);
    return new ResponseEntity<Questions>(x,HttpStatus.OK);
}

Get Mapping WIth Excepton Handling

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
*/    

