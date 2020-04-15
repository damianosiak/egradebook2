package com.damianosiak.egradebook.controllers;

import com.damianosiak.egradebook.model.Lecturers;
import com.damianosiak.egradebook.model.Subjects;
import com.damianosiak.egradebook.repositories.LecturersRepository;
import com.damianosiak.egradebook.repositories.SubjectsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class SubjectsController {
    private SubjectsRepository subjectsRepository;
    private LecturersRepository lecturersRepository;

    public SubjectsController(SubjectsRepository subjectsRepository, LecturersRepository lecturersRepository){
        this.subjectsRepository = subjectsRepository;
        this.lecturersRepository = lecturersRepository;
    }


    @RequestMapping("subjects")
    public String getSubjects(Model model){
        model.addAttribute("subjects", subjectsRepository.findAll());
        return "subjects";
    }


    @GetMapping("/addsubjectpage")
    public String showAddSubjectForm(Subjects subject, Lecturers lecturer, Model model){
        model.addAttribute("lecturers", lecturersRepository.findAll());
        return "add-subject";
    }


    @PostMapping("/addsubject")
    public String addSubject(Subjects subject, Model model){
        subjectsRepository.save(subject);
        model.addAttribute("subjects", subjectsRepository.findAll());
        model.addAttribute("lecturers", lecturersRepository.findAll());
        return "subjects";
    }


    @GetMapping("subjects/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Subjects subject = subjectsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));

        model.addAttribute("subjects", subject);
        return "update-subject";
    }


    @PostMapping("/subjects/update/{id}")
    public String updateSubject(@PathVariable("id") long id, @Valid Subjects subject,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            subject.setId(id);
            return "update-subject";
        }

        subjectsRepository.save(subject);
        model.addAttribute("subjects", subjectsRepository.findAll());
        return "subjects";
    }


    @GetMapping("/subjects/delete/{id}")
    public String deleteSubject(@PathVariable("id") long id, Model model) {
        Subjects subject = subjectsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));
        subjectsRepository.delete(subject);
            model.addAttribute("subjects", subjectsRepository.findAll());
        return "subjects";
    }
}