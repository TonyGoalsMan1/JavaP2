package tech.reliab.course.tutovda.bank.entity;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
<<<<<<< HEAD
@ToString(includeFieldNames = true)
@Entity
public class User extends Person {
    private String workPlace = "-";
    private int monthlyIncome = (int) (1 + Math.random() * 10000);
    @ManyToOne
=======
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class User extends Person {
    private String workPlace = "-";
    private int monthlyIncome = (int) (1 + Math.random() * 10000);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    private Bank bank;
    private PaymentAccount paymentAccount = null;
    private CreditAccount creditAccount = null;
    private int creditRating = (int) (1 + Math.random() * 1000);

<<<<<<< HEAD
=======
    public User(int id, String name, LocalDate birthdayDate, String workPlace, int monthlyIncome, Bank bank,
                PaymentAccount paymentAccount, CreditAccount creditAccount, int creditRating) {
        super(id, name, birthdayDate);
        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.paymentAccount = paymentAccount;
        this.creditAccount = creditAccount;
        this.creditRating = creditRating;
    }

>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    public User(String name, LocalDate birthdayDate, String workPlace,
                int monthlyIncome, Bank bank, int creditRating) {
        super(name, birthdayDate);
        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditRating = creditRating;
    }

    public User(String name, LocalDate birthdayDate, String workPlace, int monthlyIncome, Bank bank,
                PaymentAccount paymentAccount, CreditAccount creditAccount, int creditRating) {
        super(name, birthdayDate);
        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.paymentAccount = paymentAccount;
        this.creditAccount = creditAccount;
        this.creditRating = creditRating;
    }
<<<<<<< HEAD
=======

    public User(User user) {
        super(user.id, user.name, user.birthdayDate);
        user.workPlace = workPlace;
        user.monthlyIncome = monthlyIncome;
        user.bank = bank;
        user.paymentAccount = paymentAccount;
        user.creditAccount = creditAccount;
        user.creditRating = creditRating;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
