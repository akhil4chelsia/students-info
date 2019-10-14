/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.helper.DBHelper;
import com.cms.helper.QueryBuilder;
import com.cms.helper.SqliteDBHelper;
import com.cms.model.Student;
import java.util.List;

/**
 *
 * @author Akhil.Muralidharan
 */
public class StudentService {

    private DBHelper dbhelper = new SqliteDBHelper("students-info.sqlite");

    public List<Student> getStudents() {
        return dbhelper.query("select * from students", Student.class);
    }

    public boolean addStudent(Student student) {
        String query = QueryBuilder.buildInsertQuery(student);
        return dbhelper.execute(query);
    }

    public boolean deleteStudent(String admission_no) {
        String query = QueryBuilder.buildDeleteQuery(admission_no);
        return dbhelper.execute(query);
    }

    public boolean updateStudent(Student input) {
        String query = QueryBuilder.buildUpdateQuery(input);
        return dbhelper.execute(query);
    }

    public List<Student> searchStudents(String text) {
        return dbhelper.query("select * from students where "
                + "name like '%" + text + "%' or "
                + "adminssion_no like '%" + text + "%' or "
                + "class like '%" + text + "%' ",
                Student.class);
    }

}
