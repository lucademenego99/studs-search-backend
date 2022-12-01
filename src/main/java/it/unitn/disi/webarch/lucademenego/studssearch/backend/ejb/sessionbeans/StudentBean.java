package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentCourse;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;

@Stateless
@Local(Student.class)
public class StudentBean implements Student {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public Collection<StudentEntity> getAllStudents() {
        return entityManager.createQuery("SELECT s FROM StudentEntity s", StudentEntity.class).getResultList();
    }

    @Override
    public StudentEntity getStudent(Integer matriculation) {
        return entityManager.createQuery("FROM StudentEntity s WHERE s.matriculation = " + matriculation, StudentEntity.class).getResultStream().findFirst().orElse(null);
    }

    @Override
    public StudentEntity addStudent(StudentInformation student) {
        StudentEntity entity = new StudentEntity(student.getMatriculation(), student.getName(), student.getSurname());
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public StudentCourse enrollToCourse(EnrollmentInformation enrollment) {
        StudentEntity student = getStudent(enrollment.getMatriculation());
        CourseEntity course = entityManager.createQuery("FROM CourseEntity c WHERE c.id = " + enrollment.getCourseId(), CourseEntity.class).getResultStream().findFirst().orElse(null);
        StudentCourse entity = new StudentCourse();
        entity.setCourse(course);
        entity.setStudent(student);
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public StudentCourse setVote(Integer matriculation, Integer courseId, Integer vote) {
        StudentCourse entity = entityManager.createQuery("FROM StudentCourse c WHERE c.id.matriculation = " + matriculation + " AND c.id.id = " + courseId, StudentCourse.class).getResultStream().findFirst().orElse(null);
        if (entity == null) {
            return null;
        }
        entity.setVote(vote);
        entityManager.persist(entity);
        return entity;
    }
}
