package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Students",uniqueConstraints= {@UniqueConstraint(columnNames="sname")})
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sname;
	@ManyToOne
	private Classes classes;
	
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	/*
	 * public Classes getClasses() { return classes; } public void
	 * setClasses(Classes classes) { this.classes = classes; }
	 */
	@Override
	public String toString() {
		return "Students [id=" + id + ", sname=" + sname + "]";
	}
	
}
