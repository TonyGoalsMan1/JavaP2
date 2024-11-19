package tech.reliab.course.tutovda.bank.entity;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
=======

>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
<<<<<<< HEAD
@Entity
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
public class Bank {
    public final double MAX_INTEREST_RATE = 20.0;
    public final int MAX_BANK_RATING = 100;

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = 0L;
=======
    private static int counterId;

    private int id = 0;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    private String name = "-";
    private int officesAmount = 0;
    private int atmsAmount = 0;
    private int employeesAmount = 0;
    private int clientsAmount = 0;
    private byte rating = (byte) (1 + Math.random() * 100);
    private long totalMoney = 0;
    private double interestRate = 0;

<<<<<<< HEAD
    public Bank() {}
=======
    // special initialization with incrementing global counter
    private void initId() {
        id = counterId++;
    }

    public Bank() {
        initId();
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public Bank(Bank bank) {
        id = bank.id;
        name = bank.name;
        officesAmount = bank.officesAmount;
        atmsAmount = bank.atmsAmount;
        employeesAmount = bank.employeesAmount;
        clientsAmount = bank.clientsAmount;
        rating = bank.rating;
        totalMoney = bank.totalMoney;
        interestRate = bank.interestRate;
    }

<<<<<<< HEAD
    public Bank(String name) {
=======
    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bank(String name) {
        initId();
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.name = name;
    }
}
