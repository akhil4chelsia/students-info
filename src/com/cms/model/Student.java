/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.model;

/**
 *
 * @author Akhil.Muralidharan
 */
public class Student {
 
    private String admissionNumber;
    
    private String name;
    
    private String grade;
    
    private String fess;

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public void setFess(String fess) {
        this.fess = fess;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public String getFess() {
        return fess;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
   
}

