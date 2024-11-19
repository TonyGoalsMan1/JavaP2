package tech.reliab.course.tutovda.bank.service.impl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import tech.reliab.course.tutovda.bank.repository.PaymentAccountRepository;
=======
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.PaymentAccountService;
import tech.reliab.course.tutovda.bank.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
@Service
public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Autowired
    private PaymentAccountRepository paymentAccountRepository;
=======
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final Map<Integer, PaymentAccount> paymentAccountsMap = new HashMap<>();
    private final UserService userService;

    public PaymentAccountServiceImpl(UserService userService) {
        this.userService = userService;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public PaymentAccount create(PaymentAccount paymentAccount) {
        if (paymentAccount == null) {
            return null;
        }

        if (paymentAccount.getBalance() < 0) {
            System.err.println("[ERROR] | PaymentAccount -> payment account balance must be non-negative");
            return null;
        }

<<<<<<< HEAD
        return paymentAccountRepository.save(paymentAccount);
    }

    public PaymentAccount getPaymentAccountById(Long id) {
        return paymentAccountRepository.findById(id).orElse(null);
    }

    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll();
    }

    public boolean inputMoney(PaymentAccount paymentAccount, int money) {
=======
        PaymentAccount newAccount = new PaymentAccount(paymentAccount);
        paymentAccountsMap.put(newAccount.getId(), newAccount);
        userService.addPaymentAccount(newAccount.getUser().getId(), newAccount);

        return newAccount;
    }

    public PaymentAccount getPaymentAccountById(int id) {
        PaymentAccount account = paymentAccountsMap.get(id);
        if (account == null) {
            System.err.println("[ERROR] Payment account with id " + id + " is not found");
        }
        return account;
    }

    public List<PaymentAccount> getAllPaymentAccounts() {
        return new ArrayList<PaymentAccount>(paymentAccountsMap.values());
    }

    public boolean inputMoney(int id, int money) {
        PaymentAccount paymentAccount = paymentAccountsMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (paymentAccount == null) {
            System.err.println("[ERROR] | PaymentAccount -> non existing payment account");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] | PaymentAccount -> deposit amount must be positive");
            return false;
        }

        paymentAccount.setBalance(paymentAccount.getBalance() + money);
<<<<<<< HEAD
        paymentAccountRepository.save(paymentAccount);
        return true;
    }

    public boolean outputMoney(PaymentAccount paymentAccount, int money) {
=======
        return true;
    }

    public boolean outputMoney(int id, int money) {
        PaymentAccount paymentAccount = paymentAccountsMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        if (paymentAccount == null) {
            System.err.println("[ERROR] | PaymentAccount -> non existing payment account");
            return false;
        }

        if (money <= 0) {
            System.err
                    .println("[ERROR] | PaymentAccount -> withdrawal amount must be positive");
            return false;
        }

        if (paymentAccount.getBalance() - money < 0) {
            System.err.println("[ERROR] |PaymentAccount -> not enough money");
            return false;
        }

        paymentAccount.setBalance(paymentAccount.getBalance() - money);
<<<<<<< HEAD
        paymentAccountRepository.save(paymentAccount);
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        return true;
    }
}
