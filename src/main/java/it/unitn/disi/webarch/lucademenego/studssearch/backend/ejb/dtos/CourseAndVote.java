package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

public class CourseAndVote implements Serializable {
    private String name;
    private Integer vote;

    public String getName() {
        return name;
    }

    public Integer getVote() {
        return vote;
    }

    public CourseAndVote(String name, Integer vote) {
        this.name = name;
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseAndVote that = (CourseAndVote) o;
        return Objects.equals(name, that.name) && Objects.equals(vote, that.vote);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + vote.hashCode();
    }
}
