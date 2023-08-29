/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.task.repository;

import com.example.task.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
