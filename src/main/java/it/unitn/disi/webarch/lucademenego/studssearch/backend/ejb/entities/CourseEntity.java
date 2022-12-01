package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "COURSE")
public class CourseEntity implements Serializable {
    private Integer id;
    private String name;
    // private Integer teacherId;
    private TeacherEntity teacher;
    private Collection<StudentCourse> courseStudents;

    public CourseEntity() {}

    public CourseEntity(String name) {
        this.name = name;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    public TeacherEntity getTeacher() {
        return teacher;
    }
    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "course")
    public Collection<StudentCourse> getStudentCourses() {
        return this.courseStudents;
    }
    public void setStudentCourses(Collection<StudentCourse> courseStudents) {
        this.courseStudents = courseStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
