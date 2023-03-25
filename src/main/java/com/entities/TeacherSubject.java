package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//@Entity
//@Table(name="teacher_subjects")
public class TeacherSubject {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    //@OneToOne
	    private Teachers teacher;
	    //@OneToOne
	    private Subjects subject;
	    @Column(name = "classroom_id")
	    private Long classroomId;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Teachers getTeacher() {
	        return teacher;
	    }

	    public void setTeacher(Teachers teacher) {
	        this.teacher = teacher;
	    }

	    public Subjects getSubject() {
	        return subject;
	    }

	    public void setSubject(Subjects subject) {
	        this.subject = subject;
	    }

	    public Long getClassroomId() {
	        return classroomId;
	    }

	    public void setClassroomId(Long classroomId) {
	        this.classroomId = classroomId;
	    }

	    @Override
	    public String toString() {
	        return "TeacherSubject{" +
	                "id=" + id +
	                ", teacher=" + teacher +
	                ", subject=" + subject +
	                ", classroom=" + classroomId +
	                '}';
	    }

}
