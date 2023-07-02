package com.test.demo.entity;

import java.sql.Date;

public class EmployeeEntity {

    private Integer id;
    private String name;
    private String sex;
    private Date Date;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;
    private Date birthday;
    private String eName;
    private String eSex;
    private Date eDate;
    private Date eBirthday;

    public String geteAssessment() {
        return eAssessment;
    }

    public void seteAssessment(String eAssessment) {
        this.eAssessment = eAssessment;
    }

    private String eDepartment;
    private String eAssessment;

    public String geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(String eDepartment) {
        this.eDepartment = eDepartment;
    }

    private String employeeName;
    private Integer employeeId;
    private Date employeeBirthday;

    private String employeeSex;

    private Date employeeDate;
    private String employeeDepartment;
    private String assessment;

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public java.sql.Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(java.sql.Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public java.sql.Date getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(java.sql.Date employeeDate) {
        this.employeeDate = employeeDate;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public Date geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(Date eBirthday) {
        this.eBirthday = eBirthday;
    }
}
