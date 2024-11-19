package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.Bank;
import tech.reliab.course.tutovda.bank.entity.BankAtm;

import java.util.List;

public interface BankAtmService {
    // create bank
    BankAtm create(BankAtm bankAtm);

    void delete(Long id);

    BankAtm getBankAtmById(Long id);

    List<BankAtm> getAllBankAtms();

    // input money
    boolean inputMoney(BankAtm bankAtm, int money);

    // output money
    boolean outputMoney(BankAtm bankAtm, int money);
}
