package com.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classes {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
		private String cname;
	    @OneToMany(mappedBy="classroom_id")
	    private List<TeacherSubject> teacherSubject;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public List<TeacherSubject> getTeacherSubject() {
			return teacherSubject;
		}
		public void setTeacherSubject(List<TeacherSubject> teacherSubject) {
			this.teacherSubject = teacherSubject;
		}
		@Override
		public String toString() {
			return "Classes [id=" + id + ", cname=" + cname + ", teacherSubject=" + teacherSubject + "]";
		}


}
