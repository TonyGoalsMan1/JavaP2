package tech.reliab.course.tutovda.bank;

import tech.reliab.course.tutovda.bank.entity.Bank;
import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.User;
import tech.reliab.course.tutovda.bank.entity.CreditAccount;
import tech.reliab.course.tutovda.bank.entity.Employee;
import tech.reliab.course.tutovda.bank.entity.PaymentAccount;
import tech.reliab.course.tutovda.bank.service.BankAtmService;
import tech.reliab.course.tutovda.bank.service.BankOfficeService;
import tech.reliab.course.tutovda.bank.service.BankService;
import tech.reliab.course.tutovda.bank.service.CreditAccountService;
import tech.reliab.course.tutovda.bank.service.EmployeeService;
import tech.reliab.course.tutovda.bank.service.UserService;
import tech.reliab.course.tutovda.bank.service.PaymentAccountService;
import tech.reliab.course.tutovda.bank.service.impl.BankAtmServiceImpl;
import tech.reliab.course.tutovda.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.tutovda.bank.service.impl.BankServiceImpl;
import tech.reliab.course.tutovda.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.course.tutovda.bank.service.impl.EmployeeServiceImpl;
import tech.reliab.course.tutovda.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.course.tutovda.bank.service.impl.UserServiceImpl;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        bankService.setBankOfficeService(bankOfficeService);
        EmployeeService employeeService = new EmployeeServiceImpl(bankOfficeService);
        BankAtmService bankAtmService = new BankAtmServiceImpl(bankOfficeService);
        UserService userService = new UserServiceImpl(bankService);
        bankService.setUserService(userService);
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(userService);
        CreditAccountService creditAccountService = new CreditAccountServiceImpl(userService);

        for (int i = 1; i < 6; i++) {
            String name = "Blatnoy Bank #" + i;
            bankService.create(new Bank(name));
        }

        List<Bank> bankList = bankService.getAllBanks();
        for (Bank bank: bankList) {
            for (int i = 1; i < 3; i++) {
                bankOfficeService.create(new BankOffice(
                "Office #" + i + " of " + bank.getName(),
                "street Pushkina, house Kolotyshkina #" + i,
                bank,
                true,
                true,
                0,
                true,
                true,
                true,
                14000,
                100 * i
                ));
            }
        }

        List<BankOffice> officeList = bankOfficeService.getAllBankOffices();
        for (BankOffice office: officeList) {
            for (int i = 1; i < 4; i++) {
                employeeService.create(new Employee(
                        "Ruslan Polivaniy Version #" + i,
                        LocalDate.of(2003, 12, 9),
                        "Cleaner",
                        office.getBank(),
                        false,
                        office,
                        false,
                        7000));
            }
        }

        // adding Atms
        for (BankOffice office: officeList) {
            for (int i = 1; i < 4; i++) {
                bankAtmService.create(new BankAtm(
                        "Super ATM #" + i + " of 'Blatnoy bank'",
                        office.getAddress(),
                        BankAtm.Status.WORKING,
                        office.getBank(),
                        office,
                        bankOfficeService.getAllEmployeesByOfficeId(office.getId())
                                .getFirst(),
                        true,
                        true,
                        0,
                        17));
            }
        }

        for (Bank bank: bankList) {
            System.out.println(bank.toString());
        }

        System.out.print('\n');

        for (BankOffice office: officeList) {
            System.out.println(office.toString());
        }
    }
}