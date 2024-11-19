package tech.reliab.course.tutovda.bank.entity;

<<<<<<< HEAD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
<<<<<<< HEAD
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    protected Long id = 0L;
    protected String name = "-";
    protected LocalDate birthdayDate = null;

    public Person() {}
=======
public class Person {
    private static int counterId;
    protected int id = 0;
    protected String name = "-";
    protected LocalDate birthdayDate = null;

    // special initialization with incrementing global counter
    private void initId() {
        id = counterId++;
    }

    public Person() {
        initId();
    }
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424

    public Person(Person person) {
        id = person.id;
        name = person.name;
        birthdayDate = person.birthdayDate;
    }

    public Person(String name) {
<<<<<<< HEAD
=======
        initId();
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.name = name;
    }

    public Person(String name, LocalDate birthdayDate) {
<<<<<<< HEAD
=======
        initId();
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.name = name;
        this.birthdayDate = birthdayDate;
    }
}
