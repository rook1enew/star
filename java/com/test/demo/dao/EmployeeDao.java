package com.test.demo.dao;


import com.test.demo.dto.AddDto;
import com.test.demo.dto.EmployeeDto;
import com.test.demo.dto.UserModifyDto;
import com.test.demo.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Param;


import java.sql.Date;
import java.util.List;

public interface EmployeeDao {

    long totalEmployee();
    long totalDeleteEmployee();

    String getAssessmentByEmployeeId();

    List<EmployeeEntity> employeeList(long offset, long limit);
    List<EmployeeEntity> deleteEmployeeList(long offset, long limit);

    void updateEmployee(UserModifyDto userModifyDto);

    //通过id删除员工信息
    void deleteUserByEmployeeId(@Param(value = "employeeId") Integer employeeId);
    void deleteEmployeeByEmployeeId(@Param(value = "employeeId") Integer employeeId);

    EmployeeEntity getByEmployeeId(@Param(value = "employeeId") Integer employeeId);
    EmployeeEntity getByDeleteEmployeeId(@Param(value = "employeeId") Integer employeeId);

    List<EmployeeEntity> getByEId(@Param(value = "employeeId") Integer employeeId);

    //更新员工评价
    void updateAssessment(EmployeeDto employeeDto);
    void employeeAssessment(EmployeeDto employeeDto);


    List<EmployeeEntity> getByEmployeeName(@Param(value = "employeeName") String employeeName);
    List<EmployeeEntity> getByEmployeeSex(@Param(value = "employeeSex") String employeeSex);
    List<EmployeeEntity> getByEmployeeDate(@Param(value = "employeeDate") Date employeeDate);
    List<EmployeeEntity> getByEmployeeBirthday(@Param(value = "employeeBirthday") Date employeeBirthday);
    List<EmployeeEntity> getByEmployeeDepartment(@Param(value = "employeeDepartment") String employeeDepartment);

    void insertEmployee(EmployeeEntity employeeEntity);

    void insertBossDeleteEmployee(EmployeeEntity employeeEntity);
    void getBackBossDeleteEmployee(EmployeeEntity employeeEntity);
}

