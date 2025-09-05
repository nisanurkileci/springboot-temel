package com.archis.spring_bebka.controller;

import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.dto.request.StudentRequest;
import com.archis.spring_bebka.dto.response.StudentResponse;
import com.archis.spring_bebka.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {

        Student savedStudent = studentService.save(studentRequest);

        // Convert the saved entity to a DTO and return it
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(savedStudent.getId());
        studentResponse.setName(savedStudent.getName());
        studentResponse.setEmail(savedStudent.getEmail());

        return studentResponse;
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.findAll();
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<Student>> getAllStudentsPaged(Pageable pageable) {

        Page<Student> students = studentService.findAll(pageable);
        return ResponseEntity.ok(students);
    }
}