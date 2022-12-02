package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseAndTeacher;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;

public interface CourseManagement {
    CourseInformation addNewCourse(CourseInformation course);

    CourseAndTeacher setTeacher(Integer id, Integer teacherId);
}
