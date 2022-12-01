package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

public class StudentAssembler implements Assembler<StudentEntity, StudentInformation> {
    @Override
    public StudentInformation assemble(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new StudentInformation(entity.getMatriculation(), entity.getName(), entity.getSurname());
    }
}
