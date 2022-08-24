package com.example.course2208.service;

import com.example.course2208.exception.NoGradesException;
import com.example.course2208.exception.SpecialtyNotFoundException;
import com.example.course2208.model.Specialty;
import com.example.course2208.model.Student;
import com.example.course2208.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudentBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException {
        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if (tmpOptionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        } else {
            return tmpOptionalSpecialty.get().getStudents();
        }
    }
    public Specialty getSpecialtyWithMaxStudents(){
        List<Specialty> specialties= specialtyRepository.findAll();
        Integer max = specialties.get(0).getStudents().size();
        Specialty specialty = specialties.get(0);
        for(int i = 1; i < specialties.size(); i++){
            if(specialties.get(i).getStudents().size() > max) {
                max = specialties.get(i).getStudents().size();
                specialty = specialties.get(i);
            }
        }
        return specialty;
    }

    public Integer AverageAll(Integer specialtyId) throws NoGradesException {
        List<Student> students = specialtyRepository.findById(specialtyId).get().getStudents();
        Integer average = 0;
        for (Student student : students){
            average += student.getAnnualAverageGrade();
        }
        return average / students.size();
    }

    public void save(Specialty specialty){
        specialtyRepository.save(specialty);
    }
}
