package com.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name="Subjects",uniqueConstraints= {@UniqueConstraint(columnNames="subname")})
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subname;
	@ManyToOne
	//@Column(name="teachers_id") //@Column(s) not allowed on a @ManyToOne property: com.entities.Subjects.teachers
	private Teachers teachers;
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", subname=" + subname + "]";
	}

}
