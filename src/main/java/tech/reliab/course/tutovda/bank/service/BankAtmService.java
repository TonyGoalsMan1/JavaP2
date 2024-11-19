package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.Bank;
import tech.reliab.course.tutovda.bank.entity.BankAtm;

import java.util.List;

public interface BankAtmService {
    // create bank
    BankAtm create(BankAtm bankAtm);

<<<<<<< HEAD
    void delete(Long id);

    BankAtm getBankAtmById(Long id);
=======
    BankAtm getBankAtmById(int id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    List<BankAtm> getAllBankAtms();

    // input money
    boolean inputMoney(BankAtm bankAtm, int money);

    // output money
    boolean outputMoney(BankAtm bankAtm, int money);
}
