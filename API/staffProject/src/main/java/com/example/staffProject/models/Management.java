package com.example.staffProject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "management")
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerNumber;

    @Column(name = "Manager_Forename")
    private String forename;

    @Column(name = "Manager_Surname")
    private String surname;

    @Column(name = "Dept_Number")
    private int deptNumber;

    public Management() {

    }

    public Management(String forename, String surname, int deptName) {
        this.forename = forename;
        this.surname = surname;
        this.deptNumber = deptName;
    }

    public int getManagerNumber() {
        return managerNumber;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(int deptNumber) {
        this.deptNumber = deptNumber;
    }
}
