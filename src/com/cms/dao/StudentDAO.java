/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.helper.DBHelper;
import com.cms.helper.SqliteDBHelper;
import com.cms.model.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Akhil.Muralidharan
 */
public class StudentDAO {

    //DBHelper dbhelper = new SqliteDBHelper("students_info.db");
    List<Student> mockDb = new ArrayList<>();

    public void addStudent(Student student) {
        mockDb.add(student);
    }

    public void deleteStudent(Student student) {
        Iterator i = mockDb.iterator();
        while (i.hasNext()) {
            Student stu = (Student) i.next();
            if (stu.getAdmissionNumber().equals(student.getAdmissionNumber())) {
                i.remove();
                break;
            }
        }
    }

    public List<Student> getStudents() {
        return mockDb;
    }
}
