package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.EmployeeDao;
import com.example.springbootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class EmpController {


  @GetMapping(value = "/emps")
  public String list(Model model, HttpSession s){
    Collection<Employee> employees = employeeDao.getAll();
    model.addAttribute("list",employees);
    return "emp/list";
  }

  @Autowired
  EmployeeDao employeeDao;

}
