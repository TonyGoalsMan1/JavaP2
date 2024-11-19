package tech.reliab.course.tutovda.bank.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class PaymentAccount extends Account {
    private int balance = 0;

    public PaymentAccount(User user, Bank bank, int balance) {
        super(user, bank);
        this.balance = balance;
    }
}
