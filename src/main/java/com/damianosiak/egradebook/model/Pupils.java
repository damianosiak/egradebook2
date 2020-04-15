package com.damianosiak.egradebook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pupils {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany
    private Set<Grades> grades = new HashSet<>();


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

    public Set<Grades> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grades> grades) {
        this.grades = grades;
    }

    public Pupils(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Pupils() {
    }


    @Override
    public String toString() {
        return "Pupils{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", grades=" + grades +
                '}';
    }
}