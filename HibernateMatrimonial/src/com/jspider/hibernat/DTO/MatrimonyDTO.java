package com.jspider.hibernat.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "matrimony_table")
public class MatrimonyDTO implements Serializable {
	@Id
	@GenericGenerator(name = "lav", strategy = "increment")
	@GeneratedValue(generator = "lav")
	@Column(name = "p_id")
	private int pId;
	@Column(name = "p_age")
	private int pAge;
	@Column(name = "p_name")
	private String name;
	@Column(name = "p_quali")
	private String qualification;

	public int getpId() {
		return pId;
	}

	public int getpAge() {
		return pAge;
	}

	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
