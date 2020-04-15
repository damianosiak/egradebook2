package com.damianosiak.egradebook.controllers;

import com.damianosiak.egradebook.model.Grades;
import com.damianosiak.egradebook.repositories.GradesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class GradesController {
    private GradesRepository gradesRepository;

    public GradesController(GradesRepository gradesRepository){
        this.gradesRepository = gradesRepository;
    }

    @RequestMapping("grades")
    public String getGrades(Model model){
        model.addAttribute("grades", gradesRepository.findAll());
        return "grades";
    }


    @GetMapping("/addgradepage")
    public String showAddGradeForm(Grades grade){
        return "add-grade";
    }


    @PostMapping("/addgrade")
    public String addGrade(Grades grade, Model model){
        gradesRepository.save(grade);
        model.addAttribute("grades", gradesRepository.findAll());
        return "grades";
    }


    @GetMapping("grades/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Grades grade = gradesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid grade Id:" + id));

        model.addAttribute("grades", grade);
        return "update-grade";
    }


    @PostMapping("/grades/update/{id}")
    public String updateGrade(@PathVariable("id") long id, @Valid Grades grade,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            grade.setId(id);
            return "update-grade";
        }

        gradesRepository.save(grade);
        model.addAttribute("grades", gradesRepository.findAll());
        return "grades";
    }


    @GetMapping("/grades/delete/{id}")
    public String deleteGrade(@PathVariable("id") long id, Model model) {
        Grades grade = gradesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid grade Id:" + id));
        gradesRepository.delete(grade);
        model.addAttribute("grades", gradesRepository.findAll());
        return "grades";
    }
}