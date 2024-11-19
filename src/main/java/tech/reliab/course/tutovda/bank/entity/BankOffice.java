package tech.reliab.course.tutovda.bank.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
import lombok.*;
import tech.reliab.course.tutovda.bank.service.BankOfficeService;


@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
<<<<<<< HEAD
@Entity
public class BankOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = 0L;
    private String name = "-";
    private String address = "-";
    @ManyToOne
=======
public class BankOffice {
    private static int counterId;

    private int id = 0;
    private String name = "-";
    private String address = "-";
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
    private Bank bank = null;
    private boolean isWorking = false;
    private boolean isAtmPlaceable = false;
    private int atmsAmount = 0;
    private boolean isCreditAvailable = false;
    private boolean isCashOutputAvailable = false;
    private boolean isCashInputAvailable = false;
    private long totalMoney = 0;
    private int rentPrice = 0;

<<<<<<< HEAD
    public BankOffice() {}

    public BankOffice(String name, String address) {
=======
    // special initialization with incrementing global counter
    private void initId() {
        id = counterId++;
    }

    public BankOffice() {
        initId();
    }

    public BankOffice(String name, String address) {
        initId();
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.name = name;
        this.address = address;
    }

    public BankOffice(String name, String address, Bank bank, boolean isWorking, boolean isAtmPlaceable,
                      int atmsAmount, boolean isCreditAvailable, boolean isCashOutputAvailable,
                      boolean isCashInputAvailable, long totalMoney, int rentPrice) {
<<<<<<< HEAD
=======
        initId();
>>>>>>> 0fefca05a9a17df98f8e18047ed1b5ec4914e424
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.isWorking = isWorking;
        this.isAtmPlaceable = isAtmPlaceable;
        this.atmsAmount = atmsAmount;
        this.isCreditAvailable = isCreditAvailable;
        this.isCashOutputAvailable = isCashOutputAvailable;
        this.isCashInputAvailable = isCashInputAvailable;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
    }

    public BankOffice(BankOffice bankOffice) {
        this.id = bankOffice.id;
        this.name = bankOffice.name;
        this.address = bankOffice.address;
        this.bank = new Bank(bankOffice.bank);
        this.isWorking = bankOffice.isWorking;
        this.isAtmPlaceable = bankOffice.isAtmPlaceable;
        this.atmsAmount = bankOffice.atmsAmount;
        this.isCreditAvailable = bankOffice.isCreditAvailable;
        this.isCashOutputAvailable = bankOffice.isCashOutputAvailable;
        this.isCashInputAvailable = bankOffice.isCashInputAvailable;
        this.totalMoney = bankOffice.totalMoney;
        this.rentPrice = bankOffice.rentPrice;
    }
}
