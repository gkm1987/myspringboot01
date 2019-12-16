package it.cast.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import it.cast.bean.Department;
import it.cast.bean.Employee;
import it.cast.mapper.DepartmentMapper;
import it.cast.mapper.EmployeeMapper;
import it.cast.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public List<Employee> getEmpList(){
        return employeeMapper.getEmpList();
    }

    @GetMapping("/empList")
    public Page<Employee> empList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(1,1);
        return employeeMapper.getAllEmployee();
    }

    @GetMapping("/cdept/{id}")
    public Department getEmployee(@PathVariable("id") Integer id){
        Department dept = departmentService.getDep(id);
        return dept;
    }
}
