package tech.reliab.course.tutovda.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class CreditAccount extends Account {
    private LocalDate dateStart = null;
    private LocalDate dateEnd = null;
    private int monthsAmount = 0;
    private int creditSum = 0;
    private int monthlyPayment = 0;
    private int interestRate = 0;
    @ManyToOne
    private Employee employee = null;
    @ManyToOne
    private PaymentAccount paymentAccount = null;

    public CreditAccount(User user, Bank bank, LocalDate dateStart, LocalDate dateEnd,
                         int monthAmount, int creditSum, int monthlyPayment, int interestRate,
                         Employee employee, PaymentAccount paymentAccount) {
        super(user, bank);
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
