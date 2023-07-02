package com.test.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.demo.entity.EmployeeEntity;
import com.test.demo.entity.UserEntity;
import com.test.demo.service.UserService;
import com.test.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserService userService;
    @Resource
    private EmployeeService employeeService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("homePage")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("deleteEmployee")
    public String deleteEmployee() {
        return "deleteEmployee";
    }

    @GetMapping("bossIndex")
    public String bossIndex() {
        return "bossIndex";
    }

    @GetMapping("Submit")
    public String Submit() {
        return "Submit";
    }

    @GetMapping("search")
    public String search() {
        return "search";
    }
    @GetMapping("employeeIndex")
    public String employeeIndex() {
        return "employeeIndex";
    }


    @GetMapping("employeeAssessment")
    public String employeeAssessment() { return "employeeAssessment"; }
    @GetMapping("hrAssessment")
    public String hrAssessment() {
        return "hrAssessment";
    }

    @ResponseBody
    @GetMapping("pageUser")
    public String pageUser(long page, long limit) {
        long userTotal = userService.totalUser();
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", userTotal);
        // 判断用户总条数是否大于0
        if (userTotal > 1) {
            List<UserEntity> dataList = userService.userList(page, limit);
            result.put("data", dataList);
        } else {
            result.put("data", Collections.emptyList());
        }
        return result.toJSONString();
    }
    @ResponseBody
    @GetMapping("pageEmployee")
    public String pageEmployee(long page, long limit) {
        long employeeTotal = employeeService.totalEmployee();
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", employeeTotal);
        if (employeeTotal >= 1) {
            List<EmployeeEntity> dataList = employeeService.employeeList(page,limit);
            result.put("data", dataList);
        } else {
            result.put("data", Collections.emptyList());
        }
        return result.toJSONString();
    }

    @ResponseBody
    @GetMapping("pageDeleteEmployee")
    public String pageDeleteEmployee(long page, long limit) {
        long employeeDeleteTotal = employeeService.totalDeleteEmployee();
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", employeeDeleteTotal);
        if (employeeDeleteTotal >= 1) {
            List<EmployeeEntity> dataList = employeeService.deleteEmployeeList(page,limit);
            result.put("data", dataList);
        } else {
            result.put("data", Collections.emptyList());
        }
        return result.toJSONString();
    }

}
