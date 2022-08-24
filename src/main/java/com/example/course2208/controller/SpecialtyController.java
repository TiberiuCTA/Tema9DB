package com.example.course2208.controller;

import com.example.course2208.exception.NoGradesException;
import com.example.course2208.exception.SpecialtyNotFoundException;
import com.example.course2208.model.Specialty;
import com.example.course2208.model.Student;
import com.example.course2208.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("all/{specialtyId}")
    public List<Student> getAllStudentBySpecialty(@PathVariable Integer specialtyId)
            throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentBySpecialty(specialtyId);
    }
    @GetMapping("SpecialtyMax")
    public Specialty getSpecialtyWithMaxStudents(){
        return specialtyService.getSpecialtyWithMaxStudents();
    }

    @GetMapping("AverageAll/{specialtyId}")
    public Integer AverageAll(@PathVariable Integer specialtyId) throws NoGradesException {
        return specialtyService.AverageAll(specialtyId);
    }
    @PostMapping
    public void save(@RequestBody Specialty specialty){
        specialtyService.save(specialty);
    }
}
