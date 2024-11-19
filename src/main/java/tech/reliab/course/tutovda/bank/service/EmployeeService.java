package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);

<<<<<<< HEAD
    Employee getEmployeeById(Long id);
=======
    Employee getEmployeeById(int id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    List<Employee> getAllEmployees();
}
