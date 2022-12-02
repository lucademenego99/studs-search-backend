package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseAndTeacher;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.CourseAndTeacherAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.CourseInformationAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Course;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
@Remote(CourseManagement.class)
public class CourseManagementBean implements CourseManagement {
    @Inject
    Course courseBean;

    @Override
    public CourseInformation addNewCourse(CourseInformation course) {
        return new CourseInformationAssembler().assemble(courseBean.addCourse(course));
    }

    @Override
    public CourseAndTeacher setTeacher(Integer id, Integer teacherId) {
        return new CourseAndTeacherAssembler().assemble(courseBean.setTeacher(id, teacherId));
    }
}
