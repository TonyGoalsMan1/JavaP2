package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.CreditAccount;

import java.util.List;

public interface CreditAccountService {
    CreditAccount create(CreditAccount creditAccount);

<<<<<<< HEAD
    CreditAccount getCreditAccountById(Long id);

    List<CreditAccount> getAllCreditAccounts();

    boolean doMonthlyPayment(CreditAccount creditAccount);
=======
    CreditAccount getCreditAccountById(int id);

    List<CreditAccount> getAllCreditAccounts();

    boolean doMonthlyPayment(int id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
