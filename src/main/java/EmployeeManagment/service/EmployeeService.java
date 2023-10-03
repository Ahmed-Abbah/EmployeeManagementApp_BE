package EmployeeManagment.service;

import EmployeeManagment.Exception.UserNotFoundException;
import EmployeeManagment.model.Employee;
import EmployeeManagment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return this.employeeRepository
                .findEmployeeById(id)
                .orElseThrow(
                        ()-> new UserNotFoundException("user by id "+id+" was not found")
                );
    }
    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        this.employeeRepository.deleteEmployeeById(id);
    }
}
