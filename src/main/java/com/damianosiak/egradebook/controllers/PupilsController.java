package com.damianosiak.egradebook.controllers;

import com.damianosiak.egradebook.model.Pupils;
import com.damianosiak.egradebook.repositories.PupilsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class PupilsController {
    private PupilsRepository pupilsRepository;

    public PupilsController(PupilsRepository pupilsRepository){
        this.pupilsRepository = pupilsRepository;
    }


    @RequestMapping("pupils")
    public String getPupils(Model model){
        model.addAttribute("pupils", pupilsRepository.findAll());
        return "pupils";
    }


    @GetMapping("/addpupilpage")
    public String showAddPupilForm(Pupils pupil){
        return "add-pupil";
    }


    @PostMapping("/addpupil")
    public String addPupil(Pupils pupil, Model model){
        pupilsRepository.save(pupil);
        model.addAttribute("pupils", pupilsRepository.findAll());
        return "pupils";
    }


    @GetMapping("pupils/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pupils pupil = pupilsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pupil Id:" + id));

        model.addAttribute("pupils", pupil);
        return "update-pupil";
    }


    @PostMapping("/pupils/update/{id}")
    public String updatePupil(@PathVariable("id") long id, @Valid Pupils pupil,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            pupil.setId(id);
            return "update-pupil";
        }

        pupilsRepository.save(pupil);
        model.addAttribute("pupils", pupilsRepository.findAll());
        return "pupils";
    }


    @GetMapping("/pupils/delete/{id}")
    public String deletePupil(@PathVariable("id") long id, Model model) {
        Pupils pupil = pupilsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pupil Id:" + id));
        pupilsRepository.delete(pupil);
        model.addAttribute("pupils", pupilsRepository.findAll());
        return "pupils";
    }
}