package com.driver;


import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceController {
    @Autowired
    StudentRepositoryController studentRepositoryObj;

    public void addStudentFromRepositoryController(Student s)
    {
        studentRepositoryObj.saveStudentFromMap(s);
    }

    public Student getStudentByNameFromService(String x)
    {
        return studentRepositoryObj.findStudentMethod(x);
    }
    public void addTeacherToDatabase(Teacher t)
    {
        studentRepositoryObj.saveTeacherFunction(t);
    }

    public Teacher getTeacherByNameFromService(String x)
    {
        return studentRepositoryObj.findTeacherFromMap(x);
    }

    public List<String> getAllStudentsFromRepository()
    {
        return studentRepositoryObj.findAllStudentsFunction();
    }

    public void pairToRepository(String t , String student)
    {
        studentRepositoryObj.saveStudentTeacherPairFunction(t , student);
    }

    public List<String> getStudentsByTeacherNameFromRepository(String st)
    {
        return studentRepositoryObj.findStudentsFromTeacherMethod(st);
    }

    public void  deleteTeacherByNameFromRepository(String dt)
    {
        studentRepositoryObj.deleteTeacherFunction(dt);
    }

    public void deleteAllTeachersFromRepository()
    {
        studentRepositoryObj.deleteAllTeacherMethod();
    }
}
