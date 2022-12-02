package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.TeacherInformationAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Teacher;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
@Remote(TeacherManagement.class)
public class TeacherManagementBean implements TeacherManagement {
    @Inject
    Teacher teacherBean;

    @Override
    public TeacherInformation addTeacher(TeacherInformation teacher) {
        return new TeacherInformationAssembler().assemble(teacherBean.addTeacher(teacher));
    }
}
