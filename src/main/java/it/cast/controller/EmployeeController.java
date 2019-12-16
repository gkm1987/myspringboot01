package it.cast.controller;


import it.cast.bean.Employee;
import it.cast.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/cemp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/cemp")
    public Employee update(Employee employee){
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;
    }

    @GetMapping("/cdelemp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
}
