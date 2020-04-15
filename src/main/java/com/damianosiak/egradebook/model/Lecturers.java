package com.damianosiak.egradebook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lecturers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "lecturers")
    private Set<Subjects> subjects = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }


    public Lecturers(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Lecturers() {
    }


    @Override
    public String toString() {
        return "Lecturers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}