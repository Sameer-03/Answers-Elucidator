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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sameer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Solutions")
public class Solutions {
	/*
	 * int sid  (primary key for Solution Table)
	 * int qid	(Foreign Key referencing Question Table)
	 * string username
	 * string description
	 * Date date 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	@JsonProperty("id")
	@Column(name = "fk_qid")
	private int qid;  // rename to id

	@Column(name = "fk_uname")
	private String username;//username

	private String title;
	private String description;

	@Column(name="pdate")
	private Date date;// = (new Date());//queryDate

}
