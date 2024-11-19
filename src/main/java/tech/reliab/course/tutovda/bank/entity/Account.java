package tech.reliab.course.tutovda.bank.entity;

import lombok.*;
<<<<<<< HEAD
import jakarta.persistence.*;

@Setter
@Getter
@MappedSuperclass
@ToString(includeFieldNames = true)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    protected Long id;
    @ManyToOne
    protected User user = null;
    @ManyToOne
    protected Bank bank = null;

    public Account(User user, Bank bank) {
=======

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class Account {
    private static int counterId;
    protected int id = 0;
    protected User user = null;
    protected Bank bank = null;

    // special initialization with incrementing global counter
    private void initId() {
        id = counterId++;
    }

    public Account() {
        initId();
    }

    public Account(Account account) {
        id = account.id;
        user = new User(account.user);
        bank = new Bank(account.bank);
    }

    public Account(User user, Bank bank) {
        initId();
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.user = user;
        this.bank = bank;
    }
}
