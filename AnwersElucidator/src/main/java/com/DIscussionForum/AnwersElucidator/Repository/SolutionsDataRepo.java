/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Repository;

import com.DIscussionForum.AnwersElucidator.Dto.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sameer
 */
public interface SolutionsDataRepo extends JpaRepository<Solutions,Integer> {
    Solutions findById(int sid);
}
