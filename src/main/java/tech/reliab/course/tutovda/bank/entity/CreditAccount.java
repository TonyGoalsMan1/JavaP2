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
=======
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
public class CreditAccount extends Account {
    private LocalDate dateStart = null;
    private LocalDate dateEnd = null;
    private int monthsAmount = 0;
    private int creditSum = 0;
    private int monthlyPayment = 0;
    private int interestRate = 0;
<<<<<<< HEAD
    @ManyToOne
    private Employee employee = null;
    @ManyToOne
    private PaymentAccount paymentAccount = null;

    public CreditAccount(User user, Bank bank, LocalDate dateStart, LocalDate dateEnd,
                         int monthAmount, int creditSum, int monthlyPayment, int interestRate,
                         Employee employee, PaymentAccount paymentAccount) {
        super(user, bank);
=======
    private Employee employee = null;
    private PaymentAccount paymentAccount = null;

    public CreditAccount(CreditAccount creditAccount) {
        super(creditAccount.id, creditAccount.user, creditAccount.bank);
        dateStart = creditAccount.dateStart;
        dateEnd = creditAccount.dateEnd;
        monthsAmount = creditAccount.monthsAmount;
        creditSum = creditAccount.creditSum;
        monthlyPayment = creditAccount.monthlyPayment;
        interestRate = creditAccount.interestRate;
        employee = new Employee(creditAccount.employee);
        paymentAccount = new PaymentAccount(creditAccount.paymentAccount);
    }

    public CreditAccount(int id, User user, Bank bank, LocalDate dateStart, LocalDate dateEnd,
                         int monthAmount, int creditSum, int monthlyPayment, int interestRate,
                         Employee employee, PaymentAccount paymentAccount) {
        super(id, user, bank);
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.monthsAmount = monthAmount;
        this.creditSum = creditSum;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }
}
