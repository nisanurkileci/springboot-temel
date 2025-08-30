package com.archis.spring_bebka.service;

import com.archis.spring_bebka.model.Book;
import com.archis.spring_bebka.model.Student;
import com.archis.spring_bebka.repository.StudentRepository;
import com.archis.spring_bebka.request.StudentRequest;
import com.archis.spring_bebka.response.StudentResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @PostConstruct
    public void init() {
        if (studentRepository.count() == 0) {
            Student student1 = new Student();
            student1.setName("Hilal");
            student1.setEmail("h@.com");



            Student student2 = new Student();
            student2.setName("Nihal");
            student2.setEmail("nh@.com");



            Book book1 = new Book("hp1", "jjk");
            book1.setStudent(student1);
            student1.getBooks().add(book1);

            Book book2 = new Book("emma", "w");
            book2.setStudent(student2);
            student2.getBooks().add(book2);

            studentRepository.save(student1);
            studentRepository.save(student2);
        }
    }


    public Student saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        return studentRepository.save(student);
    }


    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::mapToStudentResponse)
                .collect(Collectors.toList());
    }

    private StudentResponse mapToStudentResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        return response;
    }
}