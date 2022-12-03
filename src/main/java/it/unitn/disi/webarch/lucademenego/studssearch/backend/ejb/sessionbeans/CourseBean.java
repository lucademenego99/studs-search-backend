package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.TeacherEntity;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Stateless local bean used to manage courses
 */
@Stateless
@Local(Course.class)
public class CourseBean implements Course {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public CourseEntity getCourse(Integer id) {
        return entityManager.createQuery("FROM CourseEntity c WHERE c.id = " + id, CourseEntity.class).getResultStream().findFirst().orElse(null);
    }

    @Override
    public CourseEntity addCourse(CourseInformation course) {
        CourseEntity entity = new CourseEntity(course.getName());
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public CourseEntity removeCourse(Integer id) {
        CourseEntity toRemove = entityManager.createQuery("FROM CourseEntity c WHERE c.id = " + id, CourseEntity.class).getResultStream().findFirst().orElse(null);
        if (toRemove == null) {
            return null;
        }
        entityManager.remove(toRemove);
        return toRemove;
    }

    @Override
    public CourseEntity setTeacher(Integer id, Integer teacherId) {
        CourseEntity toUpdate = getCourse(id);
        if (toUpdate == null) {
            return null;
        }
        TeacherEntity teacher = entityManager.createQuery("FROM TeacherEntity c WHERE c.id = " + teacherId, TeacherEntity.class).getResultStream().findFirst().orElse(null);
        if (teacher == null) {
            return null;
        }
        toUpdate.setTeacher(teacher);
        entityManager.persist(toUpdate);
        return toUpdate;
    }
}
