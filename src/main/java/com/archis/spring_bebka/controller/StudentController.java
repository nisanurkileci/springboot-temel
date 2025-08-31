package com.archis.spring_bebka.controller;

import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.request.StudentRequest;
import com.archis.spring_bebka.response.StudentResponse;
import com.archis.spring_bebka.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        Student savedStudent = studentService.saveStudent(studentRequest);

        // Convert the saved entity to a DTO and return it
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(savedStudent.getId());
        studentResponse.setName(savedStudent.getName());
        studentResponse.setEmail(savedStudent.getEmail());

        return studentResponse;
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<Student>> getAllStudentsPaged(Pageable pageable) {
        // Doğru metot çağrısı:
        Page<Student> students = studentService.getAllStudents(pageable);
        return ResponseEntity.ok(students);
    }
}