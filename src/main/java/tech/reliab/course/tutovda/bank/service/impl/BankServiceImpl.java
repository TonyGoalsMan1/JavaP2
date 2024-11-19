package tech.reliab.course.tutovda.bank.service.impl;

import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.*;
import tech.reliab.course.tutovda.bank.repository.BankOfficeRepository;
import tech.reliab.course.tutovda.bank.repository.BankRepository;
import tech.reliab.course.tutovda.bank.repository.EmployeeRepository;
import tech.reliab.course.tutovda.bank.repository.UserRepository;
=======
import tech.reliab.course.tutovda.bank.entity.*;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.BankOfficeService;
import tech.reliab.course.tutovda.bank.service.BankService;
import tech.reliab.course.tutovda.bank.service.UserService;

import java.util.*;

<<<<<<< HEAD
@Service
public class BankServiceImpl implements BankService {
    private BankOfficeService bankOfficeService;
    private UserService userService;
    @Autowired
    private BankOfficeRepository bankOfficeRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;
=======
public class BankServiceImpl implements BankService {
    private final Map<Integer, Bank> banksMap = new HashMap<>();
    private final Map<Integer, List<BankOffice>> officesByBankIdMap = new HashMap<>();
    private final Map<Integer, List<User>> usersByBankIdMap = new HashMap<>();

    @Setter
    private BankOfficeService bankOfficeService;
    @Setter
    private UserService userService;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public Bank create(Bank bank) {
        if (bank == null) {
            return null;
        }
<<<<<<< HEAD
        return bankRepository.save(bank);
    }

    public Bank getBankById(Long id) {
        return bankRepository.findById(id).orElse(null);
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public List<BankOffice> getAllBankOfficesByBankId(Long id) {
        Bank bank = getBankById(id);
        if (bank != null) {
            return bankOfficeRepository.findAllBankOfficesByBankId(id);
        }
        return null;
    }

    public boolean addOffice(Long id, BankOffice bankOffice) {
=======

        Bank createdBank = new Bank(bank.getId(), bank.getName());

        createdBank.setRating((byte) (1 + Math.random() * 100));
        createdBank.setTotalMoney((byte) (1 + Math.random() * 1000000));
        calculateInterestRate(createdBank);

        banksMap.put(createdBank.getId(), createdBank);
        officesByBankIdMap.put(createdBank.getId(), new ArrayList<>());
        usersByBankIdMap.put(createdBank.getId(), new ArrayList<>());

        return createdBank;
    }

    public Bank getBankById(int id) {
        Bank bank = banksMap.get(id);
        if (bank == null) {
            System.err.println("[ERROR] Bank with id -> " + id + " is not found");
        }
        return bank;
    }

    public List<Bank> getAllBanks() {
        return new ArrayList<>(banksMap.values());
    }

    public List<BankOffice> getAllBankOfficesByBankId(int id) {
        Bank bank = getBankById(id);
        if (bank != null) {
            return officesByBankIdMap.get(id);
        }
        return new ArrayList<>();
    }

    public boolean addOffice(int id, BankOffice bankOffice) {
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        Bank bank = getBankById(id);
        if (bank != null && bankOffice != null) {
            bankOffice.setBank(bank);
            bank.setOfficesAmount(bank.getOfficesAmount() + 1);
            bank.setAtmsAmount(bank.getAtmsAmount() + bankOffice.getAtmsAmount());
            inputMoney(id, bankOffice.getTotalMoney());
<<<<<<< HEAD
            bankRepository.save(bank);
            bankOfficeRepository.save(bankOffice);
=======
            List<BankOffice> bankOffices = getAllBankOfficesByBankId(id);
            bankOffices.add(bankOffice);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean deleteOffice(Long id, BankOffice bankOffice) {
        Bank bank = getBankById(id);
        int officeId = bankOfficeRepository.findAllBankOfficesByBankId(id).indexOf(bankOffice);
=======
    public boolean deleteOffice(int id, BankOffice bankOffice) {
        Bank bank = getBankById(id);
        int officeId = officesByBankIdMap.get(id).indexOf(bankOffice);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (bank != null && bankOffice != null) {
            if (bank.getOfficesAmount() - 1 < 0) {
                System.err.println("[ERROR] Bank " + bank.getName() + " | Can't delete office. Already zero");
                return false;
            }

            bank.setOfficesAmount(bank.getOfficesAmount() - 1);
<<<<<<< HEAD
            bankOfficeRepository.deleteById(bankOffice.getId());
            bankRepository.save(bank);
=======
            bank.setAtmsAmount(bank.getAtmsAmount() - officesByBankIdMap.get(id).get(officeId).getAtmsAmount());
            officesByBankIdMap.get(id).remove(officeId);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean addUser(Long id, User user) {
=======
//    public boolean addAtm(int id, BankAtm bankAtm) {
//        Bank bank = getBankById(id);
//        if (bank != null && bankAtm != null) {
//            bankAtm.setBank(bank);
//            bank.setAtmsAmount(bank.getAtmsAmount() + 1);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean deleteAtm(int id, BankAtm bankAtm) {
//        Bank bank = getBankById(id);
//        if (bank != null && bankAtm != null) {
//            if (bank.getAtmsAmount() - 1 < 0) {
//                System.err.println("[ERROR] Bank " + bank.getName() + " | Can't delete atm. Already zero");
//                return false;
//            }
//
//            bank.setAtmsAmount(bank.getAtmsAmount() - 1);
//            return true;
//        }
//        return false;
//    }

//    public boolean addEmployee(int id, Employee employee) {
//        Bank bank = getBankById(id);
//        if (bank != null && employee != null) {
//            employee.setBank(bank);
//            bank.setEmployeesAmount(bank.getEmployeesAmount() + 1);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean deleteEmployee(int id, Employee employee) {
//        Bank bank = getBankById(id);
//        if (bank != null && employee != null) {
//            if (bank.getEmployeesAmount() - 1 < 0) {
//                System.err.println("[ERROR] Bank " + bank.getName() + " | Can't delete employee. Already zero");
//                return false;
//            }
//
//            bank.setEmployeesAmount(bank.getEmployeesAmount() - 1);
//            return true;
//        }
//        return false;
//    }

    public boolean addUser(int id, User user) {
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        Bank bank = getBankById(id);
        if (bank != null && user != null) {
            user.setBank(bank);
            bank.setClientsAmount(bank.getClientsAmount() + 1);
<<<<<<< HEAD
            userRepository.save(user);
            bankRepository.save(bank);
=======
            List<User> users = usersByBankIdMap.get(id);
            users.add(user);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean deleteUser(Long id, User user) {
=======
    public boolean deleteUser(int id, User user) {
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        Bank bank = getBankById(id);
        if (bank != null && user != null) {
            if (bank.getClientsAmount() - 1 < 0) {
                System.err.println("[ERROR] Bank " + bank.getName() + " | Can't delete clients. Already zero");
                return false;
            }

            bank.setClientsAmount(bank.getClientsAmount() - 1);
<<<<<<< HEAD
            userRepository.deleteById(user.getId());
            bankRepository.save(bank);
=======
            List<User> users = usersByBankIdMap.get(id);
            users.remove(user);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

    public double calculateInterestRate(Bank bank) {
        if (bank != null) {
            double reductionFactor = (bank.MAX_BANK_RATING - bank.getRating() + 1) / (double) bank.MAX_BANK_RATING;

            Random random = new Random();
            double baseRate = random.nextDouble() * bank.MAX_INTEREST_RATE;
            double interestRate = baseRate * reductionFactor;

            return Math.round(interestRate * 100.0) / 100.0;
<<<<<<< HEAD
=======

>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        }

        return 0.0;
    }

<<<<<<< HEAD
    public boolean inputMoney(Long id, long money) {
=======
    public boolean inputMoney(int id, long money) {
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        Bank bank = getBankById(id);
        if (bank == null) {
            System.err.println("[ERROR] Bank | Can not deposit money to uninitialized bank");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] Bank | Can not deposit money. Deposit amount must be positive");
            return false;
        }

        bank.setTotalMoney(bank.getTotalMoney() + money);
<<<<<<< HEAD
        bankRepository.save(bank);
        return true;
    }

    public boolean outputMoney(Long id, long money) {
=======
        return true;
    }

    public boolean outputMoney(int id, long money) {
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        Bank bank = getBankById(id);
        if (bank == null) {
            System.err.println("[ERROR] Bank | Can not withdraw money from uninitialized bank");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] Bank | Can not withdraw money. Withdraw amount must be positive");
            return false;
        }

        if (bank.getTotalMoney() - money < 0) {
            System.err.println("[ERROR] Bank | Can not withdraw money. Bank does not have enough money");
            return false;
        }

        bank.setTotalMoney(bank.getTotalMoney() - money);
<<<<<<< HEAD
        bankRepository.save(bank);
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        return true;
    }

}
