package com.damianosiak.egradebook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer grade;
    private Long pupil;
    private Long subject;

    @ManyToMany(mappedBy = "grades")
    private Set<Pupils> pupils = new HashSet<>();

    @ManyToMany
    private Set<Subjects> subjects = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getPupil() {
        return pupil;
    }

    public void setPupil(Long pupil) {
        this.pupil = pupil;
    }

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public Set<Pupils> getPupils() {
        return pupils;
    }

    public void setPupils(Set<Pupils> pupils) {
        this.pupils = pupils;
    }

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }


    public Grades(Integer grade, Long pupil, Long subject) {
        this.grade = grade;
        this.pupil = pupil;
        this.subject = subject;
    }

    public Grades() {
    }

    public void save(Grades grades){

    }


    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", grade=" + grade +
                ", pupil=" + pupil +
                ", subject=" + subject +
                ", pupils=" + pupils +
                ", subjects=" + subjects +
                '}';
    }
}