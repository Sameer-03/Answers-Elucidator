/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sameer
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Questions")
public class Questions {
	/* int qid 
	 * int upvote (not required)
	 * 
	 * String username 
	 * String category
	 * String title
	 * String description
	 * Date queryDate
	 * 
	 */
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int qid;
   
   @Column(name="fk_uname")
   private String username;
   
   private String category;
   private String title;
   private String description;
   
   @Column(name="pdate")
   private Date queryDate=(new Date());//queryDate
   private int upvote;
   
}



/***************RELATIONS*****************
   
   @ManyToOne
   @JoinColumn(name="fk_uname")
   private Users uname;


    public Users getUname() {
        return uname;
    }

    public void setUname(Users uname) {
        this.uname = uname;
    } 
*/