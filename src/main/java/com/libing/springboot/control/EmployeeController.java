package com.libing.springboot.control;

import com.libing.springboot.dao.DepartmentDao;
import com.libing.springboot.dao.EmployeeDao;
import com.libing.springboot.entities.Department;
import com.libing.springboot.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

/**
 * @author libing
 * @create 2020-09-26 19:42
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工到list页面
    @GetMapping("/emps")
    public String Emps(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    // 添加员工  到添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // post提交  添加页面的表单提交到emp
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 点击编辑按钮，到添加页面
    @GetMapping("/emp/{id}")
    public String addEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee);
        model.addAttribute("depts", departments);
        return "emp/add";
    }


    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

}
