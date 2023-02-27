package com.hello.demo.student.service;

import com.hello.demo.student.dto.Student;
import com.hello.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));

        //LocalDate.of(year:2000, Month.JANUARY));
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        //studentRepository.findById(studentId);
        //
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("student with id" + studentId +" doesnt exist");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student= studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + "doesn't exists"
        ));
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email != null && email.length()> 0 && !Objects.equals(student.getEmail(),email))
        {
            //Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            student.setEmail(email);
        }
    }
}
