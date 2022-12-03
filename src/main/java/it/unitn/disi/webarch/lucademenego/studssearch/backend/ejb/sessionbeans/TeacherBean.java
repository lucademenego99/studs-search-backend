package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.TeacherEntity;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Stateless local bean used to manage teachers
 */
@Stateless
@Local(Teacher.class)
public class TeacherBean implements Teacher {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public TeacherEntity getTeacher(Integer id) {
        return entityManager.createQuery("FROM TeacherEntity c WHERE c.id = " + id, TeacherEntity.class).getResultStream().findFirst().orElse(null);
    }

    @Override
    public TeacherEntity addTeacher(TeacherInformation teacher) {
        TeacherEntity entity = new TeacherEntity(teacher.getName(), teacher.getSurname());
        entityManager.persist(entity);
        return entity;
    }
}
