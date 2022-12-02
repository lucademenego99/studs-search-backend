package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.CourseManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.TeacherManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class FillDatabase {
    public static void main(String[] args) {
        StudentManagement studentManagement = null;
        CourseManagement courseManagement = null;
        TeacherManagement teacherManagement = null;
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        try {
            InitialContext ctx = new InitialContext(jndiProperties);
            String studentManagementJndi = "ejb:/studs-search-backend-1.0-SNAPSHOT/StudentManagementBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement";
            studentManagement = (StudentManagement) ctx.lookup(studentManagementJndi);
            String courseManagementJndi = "ejb:/studs-search-backend-1.0-SNAPSHOT/CourseManagementBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.CourseManagement";
            courseManagement = (CourseManagement) ctx.lookup(courseManagementJndi);
            String teacherManagementJndi = "ejb:/studs-search-backend-1.0-SNAPSHOT/TeacherManagementBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.TeacherManagement";
            teacherManagement = (TeacherManagement) ctx.lookup(teacherManagementJndi);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        /**
         * Create some students
         */
        StudentInformation luca = studentManagement.addNewStudent(new StudentInformation(111111, "Luca", "De Menego"));
        StudentInformation mario = studentManagement.addNewStudent(new StudentInformation(111112, "Mario", "Rossi"));
        StudentInformation gianpaolo =  studentManagement.addNewStudent(new StudentInformation(111113, "Gianpaolo", "Volpe"));
        StudentInformation samuele = studentManagement.addNewStudent(new StudentInformation(111114, "Samuele", "De Martin"));
        StudentInformation simone = studentManagement.addNewStudent(new StudentInformation(111115, "Simone", "Diana"));

        /**
         * Create some teachers
         */
        TeacherInformation ronchetti = teacherManagement.addTeacher(new TeacherInformation("Marco", "Ronchetti"));
        TeacherInformation montresor = teacherManagement.addTeacher(new TeacherInformation("Alberto", "Montresor"));
        TeacherInformation marchese = teacherManagement.addTeacher(new TeacherInformation("Maurizio", "Marchese"));
        TeacherInformation yannis = teacherManagement.addTeacher(new TeacherInformation("Yannis", "Velegrakis"));

        /**
         * Create some courses
         */
        CourseInformation ldp = courseManagement.addNewCourse(new CourseInformation("Linguaggi di Programmazione"));
        CourseInformation asd = courseManagement.addNewCourse(new CourseInformation("Algoritmi e Strutture Dati"));
        CourseInformation sde = courseManagement.addNewCourse(new CourseInformation("Service Design and Engineering"));
        CourseInformation db = courseManagement.addNewCourse(new CourseInformation("Basi di Dati"));

        /**
         * Assign teachers to courses
         */
        courseManagement.setTeacher(ldp.getId(), ronchetti.getId());
        courseManagement.setTeacher(asd.getId(), montresor.getId());
        courseManagement.setTeacher(sde.getId(), marchese.getId());
        courseManagement.setTeacher(yannis.getId(), db.getId());

        /**
         * Enroll some students to some courses
         */
        studentManagement.enrollToCourse(new EnrollmentInformation(luca.getMatriculation(), ldp.getId()));
        studentManagement.enrollToCourse(new EnrollmentInformation(luca.getMatriculation(), asd.getId()));
        studentManagement.enrollToCourse(new EnrollmentInformation(luca.getMatriculation(), db.getId()));

        studentManagement.enrollToCourse(new EnrollmentInformation(mario.getMatriculation(), sde.getId()));
        studentManagement.enrollToCourse(new EnrollmentInformation(mario.getMatriculation(), db.getId()));

        studentManagement.enrollToCourse(new EnrollmentInformation(samuele.getMatriculation(), ldp.getId()));
        studentManagement.enrollToCourse(new EnrollmentInformation(samuele.getMatriculation(), sde.getId()));

        studentManagement.enrollToCourse(new EnrollmentInformation(simone.getMatriculation(), ldp.getId()));

        /**
         * Assign some marks to some students
         */
        studentManagement.setVote(luca.getMatriculation(), ldp.getId(), 30);
        studentManagement.setVote(luca.getMatriculation(), asd.getId(), 28);

        studentManagement.setVote(mario.getMatriculation(), db.getId(), 18);

        studentManagement.setVote(samuele.getMatriculation(), ldp.getId(), 27);
        studentManagement.setVote(samuele.getMatriculation(), sde.getId(), 25);
    }
}
