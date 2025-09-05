package com.archis.spring_bebka.service.impl;

import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.repository.StudentRepository;
import com.archis.spring_bebka.dto.request.StudentRequest;
import com.archis.spring_bebka.dto.response.StudentResponse;
import com.archis.spring_bebka.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional()
    public Student save(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToStudentResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation =  Isolation.READ_COMMITTED,rollbackFor = Exception.class)
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
    @Transactional()
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



}
