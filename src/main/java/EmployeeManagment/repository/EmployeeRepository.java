package EmployeeManagment.repository;

import EmployeeManagment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public void deleteEmployeeById(Long id);
    public Optional<Employee> findEmployeeById(Long id);
}
