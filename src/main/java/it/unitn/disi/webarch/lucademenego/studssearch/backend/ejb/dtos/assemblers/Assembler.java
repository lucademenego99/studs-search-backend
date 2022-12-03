package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

/**
 * Basic interface for DTO assemblers.
 * Every DTO must have a corresponding DTO assembler implementing this interface
 * @param <A> Type of the starting entity
 * @param <B> Type of the resulting DTO constructed from the entity
 */
public interface Assembler<A, B> {
    /**
     * Generate a DTO `B` given an entity `A`
     * @param entity entity from which the DTO will be created
     * @return DTO of type `B`
     */
    B assemble(A entity);
}
