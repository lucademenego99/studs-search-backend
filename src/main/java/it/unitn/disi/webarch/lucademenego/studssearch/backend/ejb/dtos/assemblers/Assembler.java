package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

public interface Assembler<A, B> {
    B assemble(A entity);
}
