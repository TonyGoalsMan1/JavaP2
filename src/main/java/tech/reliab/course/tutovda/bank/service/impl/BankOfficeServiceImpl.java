package tech.reliab.course.tutovda.bank.service.impl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;
import tech.reliab.course.tutovda.bank.repository.BankAtmRepository;
import tech.reliab.course.tutovda.bank.repository.BankOfficeRepository;
import tech.reliab.course.tutovda.bank.repository.EmployeeRepository;
=======
import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.BankOfficeService;
import tech.reliab.course.tutovda.bank.service.BankService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
@Service
public class BankOfficeServiceImpl implements BankOfficeService {
    @Autowired
    private BankOfficeRepository bankOfficeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BankAtmRepository bankAtmRepository;
=======
public class BankOfficeServiceImpl implements BankOfficeService {
    private final Map<Integer, BankOffice> bankOfficesMap = new HashMap<>();
    private final Map<Integer, List<Employee>> employeesByBankOfficeIdMap = new HashMap<>();
    private final Map<Integer, List<BankAtm>> BankAtmsByBankOfficeIdMap = new HashMap<>();
    private final BankService bankService;

    public BankOfficeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public BankOffice create(BankOffice bankOffice) {
        if (bankOffice == null) {
            return null;
        }

        if (bankOffice.getTotalMoney() < 0) {
            System.err.println("[ERROR] | BankOffice -> total money must be non-negative");
            return null;
        }

        if (bankOffice.getBank() == null) {
            System.err.println("[ERROR] | BankOffice -> must have bank");
            return null;
        }

        if (bankOffice.getRentPrice() < 0) {
            System.err.println("[ERROR] | BankOffice -> rentPrice must be non-negative");
            return null;
        }

<<<<<<< HEAD
        return bankOfficeRepository.save(bankOffice);
    }

    public BankOffice getBankOfficeById(Long id) {
        return bankOfficeRepository.findById(id).orElse(null);
    }

    public List<BankOffice> getAllBankOffices() {
        return bankOfficeRepository.findAll();
    }

    public List<Employee> getAllEmployeesByOfficeId(Long id) {
        return employeeRepository.findAllByBankOfficeId(id);
    }

    public boolean inputMoney(BankOffice bankOffice, int money) {
=======
        BankOffice newOffice = new BankOffice(bankOffice);
        bankOfficesMap.put(bankOffice.getId(), newOffice);
        employeesByBankOfficeIdMap.put(newOffice.getId(), new ArrayList<>());
        BankAtmsByBankOfficeIdMap.put(newOffice.getId(), new ArrayList<>());
        bankService.addOffice(newOffice.getBank().getId(), newOffice);

        return newOffice;
    }

    public BankOffice getBankOfficeById(int id) {
        BankOffice office = bankOfficesMap.get(id);
        if (office == null) {
            System.err.println("[ERROR] Office with id -> " + id + " is not found");
        }
        return office;
    }

    public List<BankOffice> getAllBankOffices() {
        return new ArrayList<BankOffice>(bankOfficesMap.values());
    }

    public List<Employee> getAllEmployeesByOfficeId(int id) {
        return employeesByBankOfficeIdMap.get(id);
    }

    public boolean inputMoney(int id, int money) {
        BankOffice bankOffice = bankOfficesMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (bankOffice == null) {
            System.err.println("[ERROR] | BankOffice -> can not deposit money to not existing office");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] | BankOffice -> can not deposit money -> deposit amount must be positive");
            return false;
        }

        if (!bankOffice.isCashOutputAvailable()) {
            System.err.println("[ERROR] | BankOffice -> can not deposit money -> office can not accept deposit");
            return false;
        }

        bankOffice.setTotalMoney(bankOffice.getTotalMoney() + money);
<<<<<<< HEAD
        bankOfficeRepository.save(bankOffice);
        return true;
    }

    public boolean outputMoney(BankOffice bankOffice, int money) {
=======
        return true;
    }

    public boolean outputMoney(int id, int money) {
        BankOffice bankOffice = bankOfficesMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (bankOffice == null) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money from not existing office");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money -> withdraw amount must be positive");
            return false;
        }

        if (!bankOffice.isCashOutputAvailable()) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money -> office can not give withdrawal");
            return false;
        }

        if (bankOffice.getTotalMoney() - money < 0) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money -> office does not have enough money");
            return false;
        }

        bankOffice.setTotalMoney(bankOffice.getTotalMoney() - money);
<<<<<<< HEAD
        bankOfficeRepository.save(bankOffice);
        return true;
    }

    public boolean installAtm(Long id, BankAtm bankAtm) {
        BankOffice bankOffice = getBankOfficeById(id);
=======
        return true;
    }

    public boolean installAtm(int id, BankAtm bankAtm) {
        BankOffice bankOffice = bankOfficesMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (bankOffice != null && bankAtm != null) {
            if (!bankOffice.isAtmPlaceable()) {
                System.err.println("[ERROR] | BankOffice -> can not install atm");
                return false;
            }

            bankOffice.setAtmsAmount(bankOffice.getAtmsAmount() + 1);
            bankOffice.getBank().setAtmsAmount(bankOffice.getBank().getAtmsAmount() + 1);
            bankAtm.setBankOffice(bankOffice);
            bankAtm.setAddress(bankOffice.getAddress());
            bankAtm.setBank(bankOffice.getBank());
<<<<<<< HEAD
            bankAtmRepository.save(bankAtm);
            bankOfficeRepository.save(bankOffice);
=======
            List<BankAtm> bankAtms = BankAtmsByBankOfficeIdMap.get(bankOffice.getId());
            bankAtms.add(bankAtm);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean removeAtm(BankOffice bankOffice, BankAtm bankAtm) {
=======
    public boolean removeAtm(int id, BankAtm bankAtm) {
        BankOffice bankOffice = bankOfficesMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (bankOffice != null && bankAtm != null) {
            if (bankOffice.getAtmsAmount() - 1 < 0) {
                System.err.println("[ERROR] | BankOffice -> can not remove ATM, no ATMs");
                return false;
            }

            bankOffice.setAtmsAmount(bankOffice.getAtmsAmount() - 1);
<<<<<<< HEAD
            bankAtmRepository.deleteById(bankAtm.getId());
            bankOfficeRepository.save(bankOffice);
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean addEmployee(Long id, Employee employee) {
        BankOffice bankOffice = getBankOfficeById(id);
        if (bankOffice != null && employee != null) {
            employee.setBankOffice(bankOffice);
            employee.setBank(bankOffice.getBank());
            employeeRepository.save(employee);
=======
    public boolean addEmployee(int id, Employee employee) {
        BankOffice bankOffice = bankOfficesMap.get(id);
        if (bankOffice != null && employee != null) {
            employee.setBankOffice(bankOffice);
            employee.setBank(bankOffice.getBank());
            List<Employee> officeEmployees = employeesByBankOfficeIdMap.get(bankOffice.getId());
            officeEmployees.add(employee);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean removeEmployee(BankOffice bankOffice, Employee employee) {
        if (bankOffice != null && employee != null){
            employeeRepository.deleteById(employee.getId());
=======
    public boolean removeEmployee(int id, Employee employee) {
        BankOffice bankOffice = bankOfficesMap.get(id);
        if (bankOffice != null && employee != null) {
            List<Employee> officeEmployees = employeesByBankOfficeIdMap.get(bankOffice.getId());
            officeEmployees.remove(employee);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }
}
