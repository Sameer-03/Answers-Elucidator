/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DIscussionForum.AnwersElucidator.Dto.Users;

/**
 *
 * @author Sameer
 */
public interface UsersDataRepo extends JpaRepository<Users,String>{
    boolean existsByUsernameAndPassword(String username, String password);
    @Query("select username from Users")
    ArrayList<String> findUsername();

}
