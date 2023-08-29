/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.task.controller;

import com.example.task.model.Employee;
import com.example.task.services.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RestController
@RequestMapping("api/visnet/employee")
public class EmployeeController {
 
 @Autowired   
 private EmployeeService employeeService; 
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.retrieve();
    }
    
    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee ){
        Optional<Employee> emp=employeeService.createEmployee(employee);
        return "employee Saved";
        
    }
    
    @GetMapping("/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id){
    
    Optional<Employee> employee=employeeService.retrieveOne(id);
    
    if(employee.isPresent()){
return new ResponseEntity<>(employee.get(),HttpStatus.OK);
}
    else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}}
