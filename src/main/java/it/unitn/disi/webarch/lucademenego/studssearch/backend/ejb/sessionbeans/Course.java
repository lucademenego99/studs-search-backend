package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;

public interface Course {
    CourseEntity getCourse(Integer id);

    CourseEntity addCourse(CourseInformation course);

    CourseEntity removeCourse(Integer id);

    CourseEntity setTeacher(Integer id, Integer teacherId);
}
