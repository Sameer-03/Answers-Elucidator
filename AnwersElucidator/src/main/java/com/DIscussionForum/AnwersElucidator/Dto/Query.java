/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name="Query")
public class Query {
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
	
   @Column(name="fk_uname")
   private String username;
   private String title;
   private String description;
   
   //@JsonIgnoreProperties("query")
   @OneToMany(fetch=FetchType.EAGER,
		   cascade= {CascadeType.ALL})
   @JoinColumn(name="fk_qid", referencedColumnName="qid")
   private List<Category> categories;
   

   @Column(name="pdate")
   private Date querydate=(new Date());//queryDate

   private int upvote;
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int qid;
   
}



/***************RELATIONS*****************
   //   @JsonIgnoreProperties("query")
//   @OneToMany(mappedBy="query",fetch=FetchType.EAGER,
//		   cascade= {CascadeType.ALL})
//   private List<Category> categories;
   
   //private String category;
   
//   @JsonIgnoreProperties("query")
//   @OneToMany(fetch=FetchType.EAGER,
//		   cascade= {CascadeType.ALL})
//   @JoinColumn(name="cat",referencedColumnName="qid")
//   private List<Category> categories;
//   

   
   
   
   
   OLD CODE
   
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