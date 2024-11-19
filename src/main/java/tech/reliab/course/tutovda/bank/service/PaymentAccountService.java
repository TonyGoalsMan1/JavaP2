package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import java.util.List;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount paymentAccount);

<<<<<<< HEAD
    PaymentAccount getPaymentAccountById(Long id);

    List<PaymentAccount> getAllPaymentAccounts();

    boolean inputMoney(PaymentAccount paymentAccount, int money);

    boolean outputMoney(PaymentAccount paymentAccount, int money);
=======
    PaymentAccount getPaymentAccountById(int id);

    List<PaymentAccount> getAllPaymentAccounts();

    boolean inputMoney(int id, int money);

    boolean outputMoney(int id, int money);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
