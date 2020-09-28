package com.libing.springboot.control;

import com.libing.springboot.dao.EmployeeDao;
import com.libing.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author libing
 * @create 2020-09-26 19:42
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;


    @GetMapping("/emps")
    public String Emps(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }
}
