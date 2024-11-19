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
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
<<<<<<< HEAD
@Entity
public class Employee extends Person {
    private String jobTitle = "-";
    @ManyToOne
    private Bank bank = null;
    private boolean isRemoteWork = false;
    @ManyToOne
=======
public class Employee extends Person {
    private String jobTitle = "-";
    private Bank bank = null;
    private boolean isRemoteWork = false;
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    private BankOffice bankOffice = null;
    private boolean isGiveCreditAvailable = false;
    private int salary = 0;

    public Employee(String name, LocalDate birthdayDate, String jobTitle, Bank bank, boolean isRemoteWork, BankOffice bankOffice,
                    boolean isGiveCreditAvailable, int salary) {
        super(name, birthdayDate);
        this.jobTitle = jobTitle;
        this.bank = bank;
        this.isRemoteWork = isRemoteWork;
        this.bankOffice = bankOffice;
        this.isGiveCreditAvailable = isGiveCreditAvailable;
        this.salary = salary;
    }

    public Employee(Employee employee) {
        super(employee.id, employee.name, employee.birthdayDate);
        jobTitle = employee.jobTitle;
        bank = new Bank(employee.bank);
        isRemoteWork = employee.isRemoteWork;
        bankOffice = new BankOffice(employee.bankOffice);
        isGiveCreditAvailable = employee.isGiveCreditAvailable;
        salary = employee.salary;
    }
<<<<<<< HEAD
=======

    public Employee(int id, String name, LocalDate birthdayDate, String jobTitle, Bank bank,
                    boolean isRemoteWork, BankOffice bankOffice, boolean isGiveCreditAvailable, int salary) {
        super(id, name, birthdayDate);
        this.jobTitle = jobTitle;
        this.bank = bank;
        this.isRemoteWork = isRemoteWork;
        this.bankOffice = bankOffice;
        this.isGiveCreditAvailable = isGiveCreditAvailable;
        this.salary = salary;
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
}
