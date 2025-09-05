package com.archis.spring_bebka.service;

import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.dto.request.StudentRequest;
import com.archis.spring_bebka.dto.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(StudentRequest studentRequest);
    Optional<Student> findById(Long id);
    List<StudentResponse> findAll();
    Page<Student> findAll(Pageable pageable);
    Student update(Long id, StudentRequest studentRequest);
    void deleteById(Long id);
}
