package com.archis.spring_bebka.service.impl;

import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.repository.StudentRepository;
import com.archis.spring_bebka.request.StudentRequest;
import com.archis.spring_bebka.response.StudentResponse;
import com.archis.spring_bebka.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToStudentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student update(Long id, StudentRequest studentRequest) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentRequest.getName());
                    student.setEmail(studentRequest.getEmail());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentResponse mapToStudentResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        return response;
    }

    @Override
    public Student saveStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return List.of();
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return null;
    }
}
