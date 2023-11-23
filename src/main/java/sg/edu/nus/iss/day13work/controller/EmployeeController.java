package sg.edu.nus.iss.day13work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.day13work.model.Employee;
import sg.edu.nus.iss.day13work.repo.EmployeeRepo;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepo empRepo;

    @GetMapping("/list")
    public String employeeList(Model model) {
        List<Employee> employees = empRepo.findAll();

        model.addAttribute("employees", employees);

        return "employeelist";
        
    }

    @GetMapping("/addnew")
    public String employeeAdd(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);

        return "employeeadd";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employeeForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "employeeadd";
        }

        return "";
    }
}
