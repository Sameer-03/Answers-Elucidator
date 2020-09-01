/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DIscussionForum.AnwersElucidator.Dto.Solutions;
import com.DIscussionForum.AnwersElucidator.Repository.SolutionsDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SolutionsController {

	@Autowired
	SolutionsDataRepo sol;

	@GetMapping("/solutions")
	public List<Solutions> getAllSolutions() {
		return sol.findAll();
	}

//	@GetMapping("/solutions/{sid}")
//	public Solutions getSingleSolution(@PathVariable int sid) {
//		Solutions s = sol.findById(sid);
//		if (s == null) {
//			throw new ResourceNotFoundException("Solution not available for this sid !");
//		}
//		return s;
//	}

	@PostMapping("/solutions")
	public ResponseEntity<Void> postSolution(@RequestBody Solutions s) {

		Solutions obj = sol.save(s);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
