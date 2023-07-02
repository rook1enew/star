package com.test.demo.service;


import com.test.demo.dao.EmployeeDao;
import com.test.demo.dto.AddDto;
import com.test.demo.dto.EmployeeDto;
import com.test.demo.dto.FireDto;
import com.test.demo.dto.UserModifyDto;
import com.test.demo.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service

public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    public long totalEmployee() {
        return employeeDao.totalEmployee();
    }
    public long totalDeleteEmployee() {
        return employeeDao.totalDeleteEmployee();
    }

    public String getAssessmentByEmployeeId(){
        return employeeDao.getAssessmentByEmployeeId();
    }


    //公司现存员工列表
   public List<EmployeeEntity> employeeList(long pageNum, long limit) {
        long offset = (pageNum - 1)*limit;
        return employeeDao.employeeList(offset, limit);
    }

    //已删除员工列表
    public List<EmployeeEntity> deleteEmployeeList(long pageNum, long limit) {
        long offset = (pageNum - 1)*limit;
        return employeeDao.deleteEmployeeList(offset, limit);
    }

    public void deleteUserByEmployeeId(Integer employeeId) {
        employeeDao.deleteUserByEmployeeId(employeeId);
    }
    public void deleteEmployeeByEmployeeId(Integer employeeId) {
        employeeDao.deleteEmployeeByEmployeeId(employeeId);
    }
    public EmployeeEntity getByDeleteEmployeeId(Integer employeeId) {
        return employeeDao.getByDeleteEmployeeId(employeeId);
    }


    public EmployeeEntity getByEmployeeId(Integer employeeId) {
        return employeeDao.getByEmployeeId(employeeId);
    }


    public List<EmployeeEntity> getByEId(Integer employeeId) {
        return employeeDao.getByEId(employeeId);
    }

    public void insertEmployee(AddDto addDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(addDto, employeeEntity);
        employeeDao.insertEmployee(employeeEntity);

    }
    public void insertBossDeleteEmployee(EmployeeEntity employeeEntity) {
        employeeDao.insertBossDeleteEmployee(employeeEntity);

    }
    public void getBackBossDeleteEmployee(EmployeeEntity employeeEntity) {
        employeeDao.getBackBossDeleteEmployee(employeeEntity);

    }
    public void updateAssessment(EmployeeDto employeeDto) {
        employeeDao.updateAssessment(employeeDto);
    }
    public void employeeAssessment(EmployeeDto employeeDto) {
        employeeDao.employeeAssessment(employeeDto);
    }
}
