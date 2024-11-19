package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.*;

import java.util.List;

public interface BankService {
    // create bank
    Bank create(Bank bank);

<<<<<<< HEAD
    Bank getBankById(Long id);

    List<Bank> getAllBanks();

    List<BankOffice> getAllBankOfficesByBankId(Long id);

    // add office
    boolean addOffice(Long id, BankOffice bankOffice);

    // delete office from bank
    boolean deleteOffice(Long id, BankOffice bankOffice);

    // add user
    boolean addUser(Long id, User user);

    // delete user from bank
    boolean deleteUser(Long id, User user);
=======
    Bank getBankById(int id);

    List<Bank> getAllBanks();

    void setBankOfficeService(BankOfficeService bankOfficeService);

    List<BankOffice> getAllBankOfficesByBankId(int id);

    void setUserService(UserService userService);

    // add office
    boolean addOffice(int id, BankOffice bankOffice);

    // delete office from bank
    boolean deleteOffice(int id, BankOffice bankOffice);

//    // add atm
//    boolean addAtm(int id, BankAtm bankAtm);
//
//    // delete atm from bank
//    boolean deleteAtm(int id, BankAtm bankAtm);
//
//    // add employee
//    boolean addEmployee(int id, Employee employee);
//
//    // delete employee
//    boolean deleteEmployee(int id, Employee employee);

    // add user
    boolean addUser(int id, User user);

    // delete user from bank
    boolean deleteUser(int id, User user);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    // calculate interest rate
    double calculateInterestRate(Bank bank);

    // input money
<<<<<<< HEAD
    boolean inputMoney(Long id, long money);

    // output money
    boolean outputMoney(Long id, long money);
=======
    boolean inputMoney(int id, long money);

    // output money
    boolean outputMoney(int id, long money);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
