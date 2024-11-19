package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();
}
