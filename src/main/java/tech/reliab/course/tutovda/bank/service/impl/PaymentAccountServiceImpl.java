package tech.reliab.course.tutovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import tech.reliab.course.tutovda.bank.repository.PaymentAccountRepository;
import tech.reliab.course.tutovda.bank.service.PaymentAccountService;
import tech.reliab.course.tutovda.bank.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final PaymentAccountRepository paymentAccountRepository;

    public PaymentAccountServiceImpl(PaymentAccountRepository paymentAccountRepository) {
        this.paymentAccountRepository = paymentAccountRepository;
    }

    public PaymentAccount create(PaymentAccount paymentAccount) {
        if (paymentAccount == null) {
            return null;
        }

        if (paymentAccount.getBalance() < 0) {
            System.err.println("[ERROR] | PaymentAccount -> payment account balance must be non-negative");
            return null;
        }

        return paymentAccountRepository.save(paymentAccount);
    }

    public PaymentAccount getPaymentAccountById(Long id) {
        return paymentAccountRepository.findById(id).orElse(null);
    }

    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll();
    }

    public boolean inputMoney(PaymentAccount paymentAccount, int money) {
        if (paymentAccount == null) {
            System.err.println("[ERROR] | PaymentAccount -> non existing payment account");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] | PaymentAccount -> deposit amount must be positive");
            return false;
        }

        paymentAccount.setBalance(paymentAccount.getBalance() + money);
        paymentAccountRepository.save(paymentAccount);
        return true;
    }

    public boolean outputMoney(PaymentAccount paymentAccount, int money) {
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
        paymentAccountRepository.save(paymentAccount);
        return true;
    }
}
