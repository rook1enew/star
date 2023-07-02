package com.test.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.demo.dto.*;
import com.test.demo.entity.EmployeeEntity;
import com.test.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

//开除员工
    @ResponseBody
    @PostMapping("fire")
    public String fire(@RequestBody FireDto fireDto, HttpServletRequest request) {
        System.out.println("用户填写的信息:" + JSONObject.toJSONString(fireDto));
        JSONObject result = new JSONObject();

        result.put("code", 0);
        EmployeeEntity employeeEntity = employeeService.getByEmployeeId(fireDto.getEmployeeId());
        if (employeeEntity == null) {
            result.put("success", false);
            result.put("msg", "该员工不存在或已被开除，请重新输入!");
            return result.toJSONString();
        }
        result.put("success", true);
        employeeService.insertBossDeleteEmployee(employeeEntity);
        employeeService.deleteUserByEmployeeId(fireDto.getEmployeeId());
        result.put("msg", "开除成功");
        return result.toJSONString();
    }
    @ResponseBody
    @PostMapping("back")
    public String back(@RequestBody FireDto fireDto, HttpServletRequest request) {
        System.out.println("用户填写的信息:" + JSONObject.toJSONString(fireDto));
        JSONObject result = new JSONObject();
        result.put("code", 0);
        EmployeeEntity employeeEntity = employeeService.getByDeleteEmployeeId(fireDto.getEmployeeId());
        if (employeeEntity == null) {
            result.put("success", false);
            result.put("msg", "该员工不存在或已被开除，请重新输入!");
            return result.toJSONString();
        }
        result.put("success", true);
        employeeService.getBackBossDeleteEmployee(employeeEntity);
        employeeService.deleteEmployeeByEmployeeId(fireDto.getEmployeeId());
        result.put("msg", "开除成功");
        return result.toJSONString();
    }
    @ResponseBody
    @PostMapping("fire2")
    public String fire2(@RequestBody FireDto fireDto, HttpServletRequest request) {
        System.out.println("用户填写的信息:" + JSONObject.toJSONString(fireDto));
        JSONObject result = new JSONObject();

        result.put("code", 0);
        EmployeeEntity employeeEntity = employeeService.getByDeleteEmployeeId(fireDto.getEmployeeId());
        if (employeeEntity == null) {
            result.put("success", false);
            result.put("msg", "该员工不存在或已彻底被开除，请重新输入!");
            return result.toJSONString();
        }
        result.put("success", true);
        employeeService.deleteEmployeeByEmployeeId(fireDto.getEmployeeId());
        result.put("msg", "开除成功");
        return result.toJSONString();
    }

    @ResponseBody
    @PostMapping("submitEmployee")
    public String submitEmployee(@RequestBody AddDto addDto) {
        List<EmployeeEntity> employeeEntityList = employeeService.getByEId(addDto.getEmployeeId());
        JSONObject result = new JSONObject();
        result.put("code", 0);
        //检测id是否存在，若存在则提示重新输入
        if (!CollectionUtils.isEmpty(employeeEntityList)) {
            result.put("msg", "该id已经存在，请重新输入!");
            return result.toJSONString();
        }
        employeeService.insertEmployee(addDto);
        result.put("success", true);
        return result.toJSONString();
    }
    // 提交员工信息

    @PostMapping("updateAssessment")
    public String updateAssessment(EmployeeDto employeeDto) {
        employeeService.updateAssessment(employeeDto);
        return "hrAssessment";
    }
    //更新HR对员工的评价

    @GetMapping("employeeInfo")
    @ResponseBody
    public String employeeInfo(Integer employeeId) {
        EmployeeEntity employeeEntity = employeeService.getByEmployeeId(employeeId);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("success", true);
        result.put("userInfo", employeeEntity);
        return result.toJSONString();
    }
    @PostMapping("employeeAssessment")
    public String employeeAssessment(EmployeeDto employeeDto) {
        employeeService.employeeAssessment(employeeDto);
        return "employeeAssessment";
    }

    @GetMapping("employeeInformation")
    @ResponseBody
    public String employeeInformation(Integer employeeId) {
        EmployeeEntity employeeEntity = employeeService.getByEmployeeId(employeeId);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("success", true);
        result.put("userInfo", employeeEntity);
        return result.toJSONString();
    }


}
