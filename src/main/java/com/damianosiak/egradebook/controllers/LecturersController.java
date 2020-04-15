package com.damianosiak.egradebook.controllers;

import com.damianosiak.egradebook.model.Lecturers;
import com.damianosiak.egradebook.repositories.LecturersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LecturersController {
    private LecturersRepository lecturersRepository;

    public LecturersController(LecturersRepository lecturersRepository){
        this.lecturersRepository = lecturersRepository;
    }


    @RequestMapping("/lecturers")
    public String getLecturers(Model model){
        model.addAttribute("lecturers", lecturersRepository.findAll());
        return "lecturers";
    }


    @GetMapping("/addlecturerpage")
    public String showAddLecturerForm(Lecturers lecturer){
        return "add-lecturer";
    }


    @PostMapping("/addlecturer")
    public String addLecturer(Lecturers lecturer, Model model){
        lecturersRepository.save(lecturer);
        model.addAttribute("lecturers", lecturersRepository.findAll());
        return "lecturers";
    }


    @GetMapping("lecturers/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Lecturers lecturer = lecturersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id:" + id));

        model.addAttribute("lecturers", lecturer);
        return "update-lecturer";
    }


    @PostMapping("/lecturers/update/{id}")
    public String updateLecturer(@PathVariable("id") long id, @Valid Lecturers lecturer,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            lecturer.setId(id);
            return "update-lecturer";
        }

        lecturersRepository.save(lecturer);
        model.addAttribute("lecturers", lecturersRepository.findAll());
        return "lecturers";
    }


    @GetMapping("/lecturers/delete/{id}")
    public String deleteLecturer(@PathVariable("id") long id, Model model) {
        Lecturers lecturer = lecturersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id:" + id));
        lecturersRepository.delete(lecturer);
        model.addAttribute("lecturers", lecturersRepository.findAll());
        return "lecturers";
    }
}