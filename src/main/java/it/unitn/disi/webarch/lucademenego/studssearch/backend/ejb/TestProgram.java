package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServices;;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.stream.Collectors;

public class TestProgram {
    public static void main(String[] args) {
        Context ctx = null;
        StudentInfoServices studentInfoServices = null;
        StudentManagement studentManagement = null;
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        try {
//            ctx = new InitialContext(jndiProperties);
//            String name = "ejb:/studs-search-backend-1.0-SNAPSHOT/StudentBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Student";
//            studentBean = (Student) ctx.lookup(name);
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

//        StudentEntity information = studentBean.getStudent(202400);
//        System.out.println(information.getName());

        // StudentCourse enrollment = studentBean.enrollToCourse(new EnrollmentInformation(202400, 1));
        // System.out.println(enrollment.getCourse().getName());

        // studentBean.setVote(202400, 1, 30);

        // StudentEntity addedStudent = studentBean.addStudent(new StudentInformation(123456, "Andrea", "De Menego"));
        // System.out.println("Add student " + addedStudent.getName());

//        Course courseBean = null;
//        try {
//            ctx = new InitialContext(jndiProperties);
//            String name = "ejb:/studs-search-backend-1.0-SNAPSHOT/CourseBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Course";
//            courseBean = (Course) ctx.lookup(name);
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

        //CourseEntity addedCourse = courseBean.addCourse(new CourseInformation("Algoritmi e strutture dati"));
        //System.out.println("Add course " + addedCourse.getName());

        // CourseEntity course = courseBean.getCourse(1);
        // System.out.println("COURSE " + course.getName());

        // CourseEntity removedCourse = courseBean.removeCourse(2);
        // System.out.println("Remove course " + removedCourse.getName());

//        Teacher teacherBean = null;
//        try {
//            ctx = new InitialContext(jndiProperties);
//            String name = "ejb:/studs-search-backend-1.0-SNAPSHOT/TeacherBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Teacher";
//            teacherBean = (Teacher) ctx.lookup(name);
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

        // TeacherEntity addedTeacher = teacherBean.addTeacher(new TeacherInformation("Alberto", "Montresor"));
        // System.out.println("Add teacher " + addedTeacher.getName());

        // courseBean.setTeacher(1, 1);

        try {
            ctx = new InitialContext(jndiProperties);
            String name = "ejb:/studs-search-backend-1.0-SNAPSHOT/StudentInfoServicesBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServices";
            studentInfoServices = (StudentInfoServices) ctx.lookup(name);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        Collection<StudentInformation> students = studentInfoServices.getStudents();
        ArrayList<StudentInformation> list = new ArrayList<>(students);

        System.out.println(list.get(0).getName());

        StudentAndCourses stud = studentInfoServices.getStudent(202400);
        System.out.println(stud.getName());
        System.out.println(stud.getCourses().get(0).getName());


        try {
            ctx = new InitialContext(jndiProperties);
            String name = "ejb:/studs-search-backend-1.0-SNAPSHOT/StudentManagementBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement";
            studentManagement = (StudentManagement) ctx.lookup(name);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        // StudentInformation addedStudent = studentManagement.addNewStudent(new StudentInformation(654123, "Vincenzo", "Insalaca"));
        // System.out.println("Add student " + addedStudent.getName());

        StudentAdvisorChoices choices = studentInfoServices.getStudentAdvisorChoices(202400);
        System.out.println(choices.getTeachers().stream().map(c ->
            c.getName().toString() + " " + c.getSurname().toString()
        ).collect(Collectors.toList()));

    }
}
