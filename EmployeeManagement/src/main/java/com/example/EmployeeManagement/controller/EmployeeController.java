package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // 1. Display home page with list of employees
    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Employee> list;
        if (keyword != null && !keyword.isEmpty()) {
            list = service.search(keyword);
            model.addAttribute("keyword", keyword); // retain input text
        } else {
            list = service.getBy();
        }
        model.addAttribute("listEmployees", list);
        return "index";
    }


    // 2. Show form to add a new employee
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee"; // add_employee.html
    }

    // 3. Save or update employee (Create or Edit)
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/";
    }

    // 4. Show update form for an existing employee
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = service.getById(id);
        model.addAttribute("employee", employee);
        return "edit_employee"; // edit_employee.html
    }

    // 5. Delete an employee by ID
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        service.deleteById(id);
        return "redirect:/";
    }


}

