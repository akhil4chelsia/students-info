/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.helper;

import com.cms.model.Student;

/**
 *
 * @author Akhil.Muralidharan
 */
public class QueryBuilder {
    
    public static String buildInsertQuery(Student student){
        return String.format("INSERT INTO STUDENTS VALUES ('%s','%s','%s','%s') ",
                                student.getAdmissionNumber(),
                                student.getName(),
                                student.getGrade(),
                                student.getFess()
                            );
    }

    public static String buildDeleteQuery(String admission_no) {
         return String.format("DELETE FROM STUDENTS WHERE adminssion_no='%s'",admission_no);
    }

    public static String buildUpdateQuery(Student student) {
         return String.format("UPDATE STUDENTS SET adminssion_no = '%s', name = '%s', class = '%s', fees = '%s' where adminssion_no = '%s' ",
                                student.getAdmissionNumber(),
                                student.getName(),
                                student.getGrade(),
                                student.getFess(),
                                student.getAdmissionNumber()
                            );
    }
       
}
