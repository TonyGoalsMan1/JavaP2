package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import java.util.List;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount paymentAccount);

    PaymentAccount getPaymentAccountById(Long id);

    List<PaymentAccount> getAllPaymentAccounts();

    boolean inputMoney(PaymentAccount paymentAccount, int money);

    boolean outputMoney(PaymentAccount paymentAccount, int money);
}
