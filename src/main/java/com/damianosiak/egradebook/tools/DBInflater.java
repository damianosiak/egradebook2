package com.damianosiak.egradebook.tools;

import com.damianosiak.egradebook.model.Grades;
import com.damianosiak.egradebook.model.Lecturers;
import com.damianosiak.egradebook.model.Pupils;
import com.damianosiak.egradebook.model.Subjects;
import com.damianosiak.egradebook.repositories.GradesRepository;
import com.damianosiak.egradebook.repositories.LecturersRepository;
import com.damianosiak.egradebook.repositories.PupilsRepository;
import com.damianosiak.egradebook.repositories.SubjectsRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {
    public DBInflater(LecturersRepository lecturersRepository, SubjectsRepository subjectsRepository, GradesRepository gradesRepository, PupilsRepository pupilsRepository){
        this.lecturersRepository = lecturersRepository;
        this.subjectsRepository = subjectsRepository;
        this.gradesRepository = gradesRepository;
        this.pupilsRepository = pupilsRepository;
    }

    private LecturersRepository lecturersRepository;
    private SubjectsRepository subjectsRepository;
    private GradesRepository gradesRepository;
    private PupilsRepository pupilsRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){
        Lecturers lecturer0 = new Lecturers("Mark", "Miller");
        Lecturers lecturer1 = new Lecturers("Tamara", "Cline");
        Lecturers lecturer2 = new Lecturers("Isa", "Munro");
        Lecturers lecturer3 = new Lecturers("Jack", "Chamberlain");
        Lecturers lecturer4 = new Lecturers("Kevin", "Sweet");

        Pupils pupil0 = new Pupils("Zoe", "Nash");
        Pupils pupil1 = new Pupils("Louis", "Nichols");
        Pupils pupil2 = new Pupils("Lester", "Stone");
        Pupils pupil3 = new Pupils("Leon", "Webster");
        Pupils pupil4 = new Pupils("Gina", "Carlson");
        Pupils pupil5 = new Pupils("Victoria", "Graves");
        Pupils pupil6 = new Pupils("Pamela", "Bass");
        Pupils pupil7 = new Pupils("Pat", "Ruiz");
        Pupils pupil8 = new Pupils("Violet", "Pierce");
        Pupils pupil9 = new Pupils("Shawn", "Bridges");

        Subjects subject0 = new Subjects("Biology", (long)1);
        Subjects subject1 = new Subjects("Mathematics", (long)2);
        Subjects subject2 = new Subjects("Physics", (long)3);
        Subjects subject3 = new Subjects("Astronomy", (long)4);
        Subjects subject4 = new Subjects("Philosophy", (long)5);

        Grades grade0 = new Grades(3, (long)6, (long)16);
        Grades grade1 = new Grades(4, (long)7, (long)17);
        Grades grade2 = new Grades(5, (long)8, (long)18);
        Grades grade3 = new Grades(3, (long)9, (long)19);
        Grades grade4 = new Grades(4, (long)10, (long)20);
        Grades grade5 = new Grades(2, (long)11, (long)16);
        Grades grade6 = new Grades(5, (long)12, (long)17);
        Grades grade7 = new Grades(4, (long)13, (long)19);
        Grades grade8 = new Grades(3, (long)14, (long)19);
        Grades grade9 = new Grades(2, (long)15, (long)20);

        lecturersRepository.save(lecturer0);
        lecturersRepository.save(lecturer1);
        lecturersRepository.save(lecturer2);
        lecturersRepository.save(lecturer3);
        lecturersRepository.save(lecturer4);

        pupilsRepository.save(pupil0);
        pupilsRepository.save(pupil1);
        pupilsRepository.save(pupil2);
        pupilsRepository.save(pupil3);
        pupilsRepository.save(pupil4);
        pupilsRepository.save(pupil5);
        pupilsRepository.save(pupil6);
        pupilsRepository.save(pupil7);
        pupilsRepository.save(pupil8);
        pupilsRepository.save(pupil9);

        subjectsRepository.save(subject0);
        subjectsRepository.save(subject1);
        subjectsRepository.save(subject2);
        subjectsRepository.save(subject3);
        subjectsRepository.save(subject4);

        gradesRepository.save(grade0);
        gradesRepository.save(grade1);
        gradesRepository.save(grade2);
        gradesRepository.save(grade3);
        gradesRepository.save(grade4);
        gradesRepository.save(grade5);
        gradesRepository.save(grade6);
        gradesRepository.save(grade7);
        gradesRepository.save(grade8);
        gradesRepository.save(grade9);
    }
}
