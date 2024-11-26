package com.fullstack.service;

import com.fullstack.model.Employee;
import com.fullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee signUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag = false;

        Employee employee = employeeRepository.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);

        if (employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Optional<Employee> findById(int empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> findByName(String empName) {
        return employeeRepository.findAll().stream().filter(emp -> emp.getEmpName().equals(empName)).toList();
    }

    @Override
    public List<Employee> findByAnyInput(String input) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return employeeRepository.findAll().stream().filter(emp -> emp.getEmpName().equals(input)
                || emp.getEmpEmailId().equals(input)
                || String.valueOf(emp.getEmpId()).equals(input)
                || String.valueOf(emp.getEmpContactNumber()).equals(input)
                || simpleDateFormat.format(emp.getEmpDOB()).equals(input)).toList();

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int empId) {
        employeeRepository.deleteById(empId);
    }
}
