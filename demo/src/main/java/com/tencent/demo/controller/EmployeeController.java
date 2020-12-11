package com.tencent.demo.controller;

import com.tencent.demo.dao.DepartmentDao;
import com.tencent.demo.dao.EmployeeDao;
import com.tencent.demo.entities.Department;
import com.tencent.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定,要求请求参数的名字
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //redirect:重定向到一个地址
        //forward:转发到一个地址
        employeeDao.save(employee);
        //System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";

    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        System.out.println("修改的员工数据:" + employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
