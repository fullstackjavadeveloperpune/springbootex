package com.fullstack.service;

import com.fullstack.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Employee signUp(Employee employee);

    boolean signIn(String empEmailId, String empPassword);

    Optional<Employee> findById(int empId);

    List<Employee> findByName(String empName);

    List<Employee> findByAnyInput(String input);

    List<Employee> findAll();

    Employee update(Employee employee);

    void deleteById(int empId);


}
