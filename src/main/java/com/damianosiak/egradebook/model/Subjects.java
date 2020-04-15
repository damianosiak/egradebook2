package com.damianosiak.egradebook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subjectName;
    private Long lecturer;

    @ManyToMany(mappedBy = "subjects")
    private Set<Grades> grades = new HashSet<>();

    @ManyToMany
    private Set<Lecturers> lecturers = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getLecturer() {
        return lecturer;
    }

    public void setLecturer(Long lecturer) {
        this.lecturer = lecturer;
    }

    public Set<Grades> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grades> grades) {
        this.grades = grades;
    }

    public Set<Lecturers> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturers> lecturers) {
        this.lecturers = lecturers;
    }


    public Subjects(String subjectName, Long lecturer) {
        this.subjectName = subjectName;
        this.lecturer = lecturer;
    }

    public Subjects() {
    }


    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", grades=" + grades +
                ", lecturers=" + lecturers +
                '}';
    }
}