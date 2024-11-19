package tech.reliab.course.tutovda.bank.service.impl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.Employee;
import tech.reliab.course.tutovda.bank.repository.EmployeeRepository;
=======
import tech.reliab.course.tutovda.bank.entity.Employee;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.BankOfficeService;
import tech.reliab.course.tutovda.bank.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
=======
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> employeesMap = new HashMap<>();
    private final BankOfficeService bankOfficeService;

    public EmployeeServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public Employee create(Employee employee) {
        if (employee == null) {
            return null;
        }

        if (employee.getSalary() < 0) {
            System.err.println("[ERROR] | Employee -> salary must be non-negative");
            return null;
        }

<<<<<<< HEAD
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
=======
        Employee newEmployee = new Employee(employee);
        employeesMap.put(newEmployee.getId(), newEmployee);
        bankOfficeService.addEmployee(newEmployee.getBankOffice().getId(), newEmployee);

        return newEmployee;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeesMap.get(id);
        if (employee == null) {
            System.err.println("[ERROR] Employee with id ->" + id + " is not found");
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employeesMap.values());
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    }
}
