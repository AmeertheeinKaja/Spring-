/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.task.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author User
 */
@Entity
@Getter
@Setter
@Table(name="employee")
public class Employee {
    @Id
   private int id; 
    @Column(name="emp_id")
    private int emp_id;
    @Column(name="emp_name")
   private String name;
      @Column(name="emp_role")
   private String role;
        @Column(name="emp_branch")
   private String branch;
   
   
}


