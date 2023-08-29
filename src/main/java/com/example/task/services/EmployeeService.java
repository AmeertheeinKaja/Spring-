/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.task.services;

import com.example.task.model.Employee;
import com.example.task.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
   
     public Optional<Employee> createEmployee(Employee employee){
         return Optional.of(employeeRepository.save(employee));
     }
    public List<Employee> retrieve(){
        return employeeRepository.findAll();
    }
    
   public Optional<Employee> retrieveOne(int empid){
        return employeeRepository.findById(empid); 
}
//    public Optional<Employee> retrieveByBranch(String empBranch){
//        return employeeRepository; 
//}
}
