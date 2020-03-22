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
//@Table("Solutions")
public class Solutions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	@Column(name = "fk_qid")
	private int qid;

	@Column(name = "fk_uname")
	private String uname;

	private String title;
	private String description;

	private Date pdate = (new Date());

}
