package tech.reliab.course.tutovda.bank.service.impl;

import lombok.Setter;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import tech.reliab.course.tutovda.bank.entity.Bank;
import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.repository.BankAtmRepository;
=======
import tech.reliab.course.tutovda.bank.entity.Bank;
import tech.reliab.course.tutovda.bank.entity.BankAtm;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.BankAtmService;
import tech.reliab.course.tutovda.bank.service.BankOfficeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAtmServiceImpl implements BankAtmService {
<<<<<<< HEAD
    @Autowired
    private BankAtmRepository bankAtmRepository;

    public BankAtm create(BankAtm bankAtm) {
        return bankAtmRepository.save(bankAtm);
    }

    public void delete(Long id) {
        bankAtmRepository.deleteById(id);
    }

    public BankAtm getBankAtmById(Long id) {
        return bankAtmRepository.findById(id).orElse(null);
    }

    public List<BankAtm> getAllBankAtms() {
        return bankAtmRepository.findAll();
=======
    private final Map<Integer, BankAtm> BankAtmsMap = new HashMap<>();
    private final BankOfficeService bankOfficeService;

    public BankAtm create(BankAtm bankAtm) {
        if (bankAtm == null) {
            return null;
        }
        if (bankAtm.getTotalMoney() < 0) {
            System.err.println("[ERROR] Can not create BankAtm - totalMoney must be non-negative");
            return null;
        }
        if (bankAtm.getMaintenancePrice() < 0) {
            System.err.println("[ERROR] Can not create BankAtm - maintenancePrice must be non-negative");
            return null;
        }
        if (bankAtm.getBankOffice() == null) {
            System.err.println("[ERROR] Can not create BankAtm - bankOffice can not be null");
            return null;
        }

        BankAtm bankAtmCopy = new BankAtm(bankAtm);
        BankAtmsMap.put(bankAtmCopy.getId(), bankAtmCopy);
        bankOfficeService.installAtm(bankAtmCopy.getBankOffice().getId(), bankAtmCopy);
        return new BankAtm(bankAtm);
    }

    public BankAtmServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    public BankAtm getBankAtmById(int id) {
        BankAtm atm = BankAtmsMap.get(id);
        if (atm == null) {
            System.err.println("Atm with id " + id + " is not found");
        }
        return atm;
    }

    public List<BankAtm> getAllBankAtms() {
        return new ArrayList<>(BankAtmsMap.values());
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    }

    public boolean inputMoney(BankAtm bankAtm, int money) {
        if (bankAtm == null) {
            System.err.println("[ERROR] BankAtm can not deposit money - non existing ATM");
            return false;
        }
        if (money <= 0) {
            System.err.println("[ERROR] BankAtm can not deposit money - amount is not positive");
            return false;
        }
        if (!bankAtm.isCashOutputAvailable()) {
            System.err.println("[ERROR] BankAtm can not deposit money - deposit is not allowed");
            return false;
        }
        bankAtm.setTotalMoney(bankAtm.getTotalMoney() + money);
<<<<<<< HEAD
        bankAtmRepository.save(bankAtm);
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        return true;
    }

    public boolean outputMoney(BankAtm bankAtm, int money) {
        if (bankAtm == null) {
            System.err.println("[ERROR] BankAtm can not withdraw money - non existing ATM");
            return false;
        }
        if (money <= 0) {
            System.err.println("[ERROR] BankAtm can not withdraw money - amount is not positive");
            return false;
        }
        if (!bankAtm.isCashOutputAvailable()) {
            System.err.println("[ERROR] BankAtm can not withdraw money - deposit is not allowed");
            return false;
        }
        if (bankAtm.getTotalMoney() - money < 0) {
            System.err.println("[ERROR] BankAtm can not withdraw money - ATM does not have enough money");
            return false;
        }
        bankAtm.setTotalMoney(bankAtm.getTotalMoney() - money);
<<<<<<< HEAD
        bankAtmRepository.save(bankAtm);
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        return true;
    }
}
