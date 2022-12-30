package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryController {
    HashMap<String, Student> studentKaMap = new HashMap<>();
    HashMap<String, Teacher> teacherKaMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentMap = new HashMap<>();


    public void saveStudentFromMap(Student s)
    {
        studentKaMap.put(s.getName() , s);
    }
    public Student findStudentMethod(String x)
    {
        return studentKaMap.get(x);
    }

    public void saveTeacherFunction(Teacher t)
    {
        teacherKaMap.put(t.getName() ,t);
    }
    public Teacher findTeacherFromMap(String x)
    {
        return teacherKaMap.get(x);
    }
    public List<String> findAllStudentsFunction()
    {
        List<String> listOfStudents = new ArrayList<>();
        for(String str : studentKaMap.keySet())
        {
            //ans.add(studentMap.get(str));
            listOfStudents.add(str);
        }
        return listOfStudents;
    }
    public void saveStudentTeacherPairFunction(String t , String student)
    {
        if(teacherStudentMap.containsValue(student)) return;
        if(teacherStudentMap.containsKey(t)) teacherStudentMap.get(t).add(student);
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(student);
            teacherStudentMap.put(t , temp);
        }
    }
    public List<String> findStudentsFromTeacherMethod(String st)
    {
        List<String> group = new ArrayList<>();
        if(teacherStudentMap.containsKey(st)) return teacherStudentMap.get(st);
        return group;

    }

    public void  deleteTeacherFunction(String dt)
    {
        int size = 0;
        if(teacherStudentMap.containsKey(dt)) size = teacherStudentMap.get(dt).size();
        for(int i = 0; i<size; i++)
        {
            if(studentKaMap.containsKey(teacherStudentMap.get(dt).get(i))) studentKaMap.remove(teacherStudentMap.get(dt).get(i));
        }
        if(teacherKaMap.containsKey(dt)) teacherKaMap.remove(dt);
        if(teacherStudentMap.containsKey(dt)) teacherStudentMap.remove(dt);
    }

    public void deleteAllTeacherMethod()
    {
        List<String> result = new ArrayList<>();
        for(String arr: teacherStudentMap.keySet())
        {
            int size = teacherStudentMap.get(arr).size();
            for(int i = 0; i<size; i++)
                result.add(teacherStudentMap.get(arr).get(i));
        }
        //res me sare students sab teachers ke add hogaye

        //studentMap.clear();
        teacherKaMap.clear();
        teacherStudentMap.clear();
        int length = result.size();
        for(int i=0; i<length; i++)
        {
            if(studentKaMap.containsKey(result.get(i))) studentKaMap.remove(result.get(i));
        }
    }

}
