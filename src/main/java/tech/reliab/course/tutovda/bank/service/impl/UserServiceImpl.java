package tech.reliab.course.tutovda.bank.service.impl;

<<<<<<< HEAD
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.tutovda.bank.entity.CreditAccount;
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import tech.reliab.course.tutovda.bank.entity.User;
import tech.reliab.course.tutovda.bank.repository.CreditAccountRepository;
import tech.reliab.course.tutovda.bank.repository.PaymentAccountRepository;
import tech.reliab.course.tutovda.bank.repository.UserRepository;
=======
import tech.reliab.course.tutovda.bank.entity.CreditAccount;
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import tech.reliab.course.tutovda.bank.entity.User;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import tech.reliab.course.tutovda.bank.service.BankService;
import tech.reliab.course.tutovda.bank.service.UserService;

import java.util.*;

<<<<<<< HEAD
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditAccountRepository creditAccountRepository;
    @Autowired
    private PaymentAccountRepository paymentAccountRepository;
=======
public class UserServiceImpl implements UserService {
    private final Map<Integer, User> usersMap = new HashMap<>();
    private final Map<Integer, List<PaymentAccount>> paymentAccountsByUserIdMap = new HashMap<>();
    private final Map<Integer, List<CreditAccount>> creditAccountsByUserIdMap = new HashMap<>();
    private final BankService bankService;

    public UserServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public User create(User user) {
        if (user == null) {
            return null;
        }

        if (user.getBank() == null) {
            System.err.println("[ERROR] User must have bank");
            return null;
<<<<<<< HEAD
        }


        Random random = new Random();
        final int monthlyIncome = random.nextInt() * 10000;
        user.setMonthlyIncome(monthlyIncome);
        calculateCreditRating(user);

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            System.err.println("[ERROR] User with id -> " + id + " is not found");
=======
        } else {
            User newUser = new User(user);

            Random random = new Random();
            final int monthlyIncome = random.nextInt() * 10000;
            newUser.setMonthlyIncome(monthlyIncome);
            calculateCreditRating(newUser);

            usersMap.put(newUser.getId(), newUser);
            paymentAccountsByUserIdMap.put(newUser.getId(), new ArrayList<>());
            creditAccountsByUserIdMap.put(newUser.getId(), new ArrayList<>());
            bankService.addUser(newUser.getBank().getId(), newUser);

            return newUser;
        }
    }

    public User getUserById(int id) {
        User user = usersMap.get(id);
        if (user == null) {
            System.err.println("[ERROR] Client with id -> " + id + " is not found");
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        }
        return user;
    }

    public List<User> getAllUsers() {
<<<<<<< HEAD
        return userRepository.findAll();
    }

    public boolean addPaymentAccount(Long id, PaymentAccount account) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            account.setUser(user);
            paymentAccountRepository.save(account);
=======
        return new ArrayList<>(usersMap.values());
    }

    public boolean addPaymentAccount(int id, PaymentAccount account) {
        User client = usersMap.get(id);
        if (client != null) {
            List<PaymentAccount> userCreditAccounts = paymentAccountsByUserIdMap.get(id);
            userCreditAccounts.add(account);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean addCreditAccount(Long id, CreditAccount account) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            account.setUser(user);
            creditAccountRepository.save(account);
=======
    public boolean addCreditAccount(int id, CreditAccount account) {
        User user = usersMap.get(id);
        if (user != null) {
            List<CreditAccount> userCreditAccounts = creditAccountsByUserIdMap.get(id);
            userCreditAccounts.add(account);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public List<PaymentAccount> getAllPaymentAccountsByUserId(Long id) {
        return paymentAccountRepository.findAllPaymentAccountsByUserId(id);
    }

    public List<CreditAccount> getAllCreditAccountsByUserId(Long id) {
        return creditAccountRepository.findAllCreditAccountsByUserId(id);
=======
    public List<PaymentAccount> getAllPaymentAccountsByUserId(int id) {
        return paymentAccountsByUserIdMap.get(id);
    }

    public List<CreditAccount> getAllCreditAccountsByUserId(int id) {
        return creditAccountsByUserIdMap.get(id);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    }

    public int calculateCreditRating(User user) {
        user.setCreditRating(user.getMonthlyIncome() / 10);
<<<<<<< HEAD
        userRepository.save(user);
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        return user.getCreditRating();
    }

}
