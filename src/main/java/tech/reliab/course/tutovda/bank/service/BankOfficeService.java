package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;

import java.util.List;

public interface BankOfficeService {
    BankOffice create(BankOffice bankOffice);

<<<<<<< HEAD
    BankOffice getBankOfficeById(Long id);

    List<BankOffice> getAllBankOffices();

    List<Employee> getAllEmployeesByOfficeId(Long id);

    boolean installAtm(Long id, BankAtm bankAtm);

    boolean removeAtm(BankOffice bankOffice, BankAtm bankAtm);

    boolean inputMoney(BankOffice bankOffice, int money);

    boolean outputMoney(BankOffice bankOffice, int money);

    boolean addEmployee(Long id, Employee employee);

    boolean removeEmployee(BankOffice bankOffice, Employee employee);
=======
    BankOffice getBankOfficeById(int id);

    List<BankOffice> getAllBankOffices();

    List<Employee> getAllEmployeesByOfficeId(int id);

    boolean installAtm(int id, BankAtm bankAtm);

    boolean removeAtm(int id, BankAtm bankAtm);

    boolean inputMoney(int id, int money);

    boolean outputMoney(int id, int money);

    boolean addEmployee(int id, Employee employee);

    boolean removeEmployee(int id, Employee employee);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
