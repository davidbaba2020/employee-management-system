package com.davacomint.employeemanagementsystem.controller;

import com.davacomint.employeemanagementsystem.model.Employee;
import com.davacomint.employeemanagementsystem.model.Rank;
import com.davacomint.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Display list of employees
    @GetMapping("/adminPanel")
    public String viewHomePage(Model model,HttpSession session){
        if(session.getAttribute("employee")==null){
            return "redirect:/";
        }else {
            model.addAttribute("listOfEmployees", employeeService.getAllEmployees());
            return "adminPanel";
        }
    }

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("login", new Employee());
        return "index";
    }

    @PostMapping("/login")
    public String loggedIn(@ModelAttribute ("loggedIn") Employee employee, HttpSession session){
        Employee employee1 = employeeService.findByEmailAndPassword
                (employee.getEmail(), employee.getPassword());
        session.setAttribute("employee", employee1);
        if (employee1.getStaffType().equals(Rank.ADMIN)){
            return "redirect:/adminPanel";
        } else
            return "redirect:/employeePanel";
    }

    @GetMapping("/createEmployee")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
        newEmployee.setEmployeeLastName(employee.getEmployeeLastName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setStaffType(employee.getStaffType());

        employeeService.createEmployee(newEmployee);
        return "redirect:/adminPanel";
    }
    @GetMapping("/logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
