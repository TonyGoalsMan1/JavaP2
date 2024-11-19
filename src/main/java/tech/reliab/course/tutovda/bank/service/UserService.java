package tech.reliab.course.tutovda.bank.service;

import tech.reliab.course.tutovda.bank.entity.CreditAccount;
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import tech.reliab.course.tutovda.bank.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

<<<<<<< HEAD
    User getUserById(Long id);

    List<User> getAllUsers();

    boolean addPaymentAccount(Long id, PaymentAccount account);

    boolean addCreditAccount(Long id, CreditAccount account);

    List<PaymentAccount> getAllPaymentAccountsByUserId(Long id);

    List<CreditAccount> getAllCreditAccountsByUserId(Long id);
=======
    User getUserById(int id);

    List<User> getAllUsers();

    boolean addPaymentAccount(int id, PaymentAccount account);

    boolean addCreditAccount(int id, CreditAccount account);

    List<PaymentAccount> getAllPaymentAccountsByUserId(int id);

    List<CreditAccount> getAllCreditAccountsByUserId(int id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    int calculateCreditRating(User user);
}
