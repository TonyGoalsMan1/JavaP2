package tech.reliab.course.tutovda.bank.entity;


<<<<<<< HEAD
import jakarta.persistence.Entity;
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import lombok.*;

@Getter
@Setter
<<<<<<< HEAD
@ToString(includeFieldNames = true)
@Entity
public class PaymentAccount extends Account {
    private int balance = 0;

    public PaymentAccount(User user, Bank bank, int balance) {
        super(user, bank);
        this.balance = balance;
    }
=======
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class PaymentAccount extends Account {
    private int balance = 0;

    public PaymentAccount(int id, User user, Bank bank, int balance) {
        super(id, user, bank);
        this.balance = balance;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        super(paymentAccount.id, paymentAccount.user, paymentAccount.bank);
        balance = paymentAccount.balance;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
