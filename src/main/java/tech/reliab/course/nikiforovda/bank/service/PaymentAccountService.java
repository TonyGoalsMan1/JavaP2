package tech.reliab.course.nikiforovda.bank.service;

import tech.reliab.course.nikiforovda.bank.entity.PaymentAccount;
import java.util.List;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount paymentAccount);

    PaymentAccount getPaymentAccountById(Long id);

    List<PaymentAccount> getAllPaymentAccounts();

    boolean inputMoney(PaymentAccount paymentAccount, int money);

    boolean outputMoney(PaymentAccount paymentAccount, int money);
}
