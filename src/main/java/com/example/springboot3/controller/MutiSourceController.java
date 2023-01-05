package com.example.springboot3.controller;

import com.example.springboot3.entity.company.Company;
import com.example.springboot3.entity.employee.Employee;
import com.example.springboot3.repository.company.CompanyRepository;
import com.example.springboot3.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.controller
 * @Author: vergil young
 * @CreateTime: 2023-01-05  19:38
 * @Description: TODO
 */

@RestController
@RequestMapping("/muti/source")
public class MutiSourceController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/save/company")
    public Company saveCompany(@RequestBody Company company){
        companyRepository.save(company);
        return company;
    }

    @PostMapping("/save/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/get/company")
    public List<Company> getCompany(){
        return companyRepository.findAll();
    }

    @GetMapping("/get/employee")
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
}
