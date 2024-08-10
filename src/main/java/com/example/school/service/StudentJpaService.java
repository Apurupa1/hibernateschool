package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.repository.StudentJpaRepository;
import com.example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentJpaService implements StudentRepository {
    @Autowired
    private StudentJpaRepository studentJpaRepository;
    @Override
    public ArrayList<Student> getStudents() {
        List<Student>slist= studentJpaRepository.findAll();
        ArrayList<Student>list= new ArrayList<>(slist);
        return list;

    }

    @Override
    public Student getStudentById(int studentId) {
        try{
            Student student=studentJpaRepository.findById(studentId).get();
            return student;
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Student addStudent(Student student) {
        studentJpaRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        try{
            Student newStudent=studentJpaRepository.findById(studentId).get();
            if (student.getStudentName()!=null){
                newStudent.setStudentName(student.getStudentName());


            }
            if (student.getGender()!=null){
                newStudent.setGender(student.getGender());


            }
            if (student.getStandard()!=0){
                newStudent.setStandard(student.getStandard());


            }
            studentJpaRepository.save(newStudent);
            return newStudent;

        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteStudent(int studentId) {
      try{
          studentJpaRepository.deleteById(studentId);
      } catch(Exception e){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }
}
