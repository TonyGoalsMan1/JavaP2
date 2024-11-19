package tech.reliab.course.tutovda.bank.service.impl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.CreditAccount;
import tech.reliab.course.tutovda.bank.repository.CreditAccountRepository;
=======
import tech.reliab.course.tutovda.bank.entity.CreditAccount;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.CreditAccountService;
import tech.reliab.course.tutovda.bank.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
@Service
public class CreditAccountServiceImpl implements CreditAccountService {
    @Autowired
    private CreditAccountRepository creditAccountRepository;
=======
public class CreditAccountServiceImpl implements CreditAccountService {
    private final Map<Integer, CreditAccount> creditAccountsMap = new HashMap<>();
    private final UserService userService;

    public CreditAccountServiceImpl(UserService userService) {
        this.userService = userService;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public CreditAccount create(CreditAccount creditAccount) {
        if (creditAccount == null) {
            return null;
        }

        if (creditAccount.getMonthsAmount() < 1) {
            System.err.println("[ERROR] | CreditAccount - monthCount must be at least 1");
            return null;
        }

        if (creditAccount.getCreditSum() <= 0) {
            System.err.println("[ERROR] | CreditAccount - creditAmount must be positive");
            return null;
        }

        if (creditAccount.getBank() == null) {
            System.err.println("[ERROR] | CreditAccount - no bank");
            return null;
        }

<<<<<<< HEAD
        return creditAccountRepository.save(creditAccount);
    }

    public CreditAccount getCreditAccountById(Long id) {
        return creditAccountRepository.findById(id).orElse(null);
    }

    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountRepository.findAll();
    }

    public boolean doMonthlyPayment(CreditAccount creditAccount) {
=======
        CreditAccount newAccount = new CreditAccount(creditAccount);
        creditAccountsMap.put(newAccount.getId(), newAccount);
        userService.addCreditAccount(newAccount.getUser().getId(), newAccount);

        return newAccount;
    }

    public CreditAccount getCreditAccountById(int id) {
        CreditAccount account = creditAccountsMap.get(id);
        if (account == null) {
            System.err.println("[ERROR] Credit account with id -> " + id + " is not found");
        }
        return account;
    }

    public List<CreditAccount> getAllCreditAccounts() {
        return new ArrayList<CreditAccount>(creditAccountsMap.values());
    }

    public boolean doMonthlyPayment(int id) {
        CreditAccount creditAccount = creditAccountsMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (creditAccount == null || creditAccount.getPaymentAccount() == null) {
            System.err.println("[ERROR] | CreditAccount - no account to take money from");
            return false;
        }

        final int monthlyPayment = creditAccount.getMonthlyPayment();
        final int paymentAccountBalance = creditAccount.getPaymentAccount().getBalance();

        if (paymentAccountBalance - monthlyPayment < 0) {
            System.err.println("[ERROR] | CreditAccount - not enough balance for monthly payment");
            return false;
        }

        creditAccount.getPaymentAccount().setBalance(paymentAccountBalance - monthlyPayment);
        creditAccount.setCreditSum(creditAccount.getCreditSum() - monthlyPayment);
<<<<<<< HEAD
        creditAccountRepository.save(creditAccount);
=======

>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        return true;
    }
}
