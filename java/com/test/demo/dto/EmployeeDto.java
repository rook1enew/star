package com.test.demo.dto;

import java.sql.Date;

public class EmployeeDto {

    private String eName;
    private String eSex;
    private Date eDate;

    private Date eBirthday;
    private String eDepartment;
    private String hrAssessment;
    private String employeeAssessment;

    public String getEmployeeAssessment() {
        return employeeAssessment;
    }

    public void setEmployeeAssessment(String employeeAssessment) {
        this.employeeAssessment = employeeAssessment;
    }

    private String userId;
    private Integer employeeId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHrAssessment() {
        return hrAssessment;
    }

    public void setHrAssessment(String hrAssessment) {
        this.hrAssessment = hrAssessment;
    }

    public String geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(String eDepartment) {
        this.eDepartment = eDepartment;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public void seteBirthday(Date eBirthday) {
        this.eBirthday = eBirthday;
    }

    public String geteName() {
        return eName;
    }

    public String geteSex() {
        return eSex;
    }

    public Date geteDate() {
        return eDate;
    }

    public Date geteBirthday() {
        return eBirthday;
    }
}
