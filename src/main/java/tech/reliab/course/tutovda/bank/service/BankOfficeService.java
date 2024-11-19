package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;

import java.util.List;

public interface BankOfficeService {
    BankOffice create(BankOffice bankOffice);

    BankOffice getBankOfficeById(Long id);

    List<BankOffice> getAllBankOffices();

    List<Employee> getAllEmployeesByOfficeId(Long id);

    boolean installAtm(Long id, BankAtm bankAtm);

    boolean removeAtm(BankOffice bankOffice, BankAtm bankAtm);

    boolean inputMoney(BankOffice bankOffice, int money);

    boolean outputMoney(BankOffice bankOffice, int money);

    boolean addEmployee(Long id, Employee employee);

    boolean removeEmployee(BankOffice bankOffice, Employee employee);
}
