package tech.reliab.course.tutovda.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.reliab.course.tutovda.bank.entity.Bank;
import tech.reliab.course.tutovda.bank.entity.BankAtm;
import tech.reliab.course.tutovda.bank.entity.BankOffice;
import tech.reliab.course.tutovda.bank.entity.Employee;
import tech.reliab.course.tutovda.bank.service.*;
import tech.reliab.course.tutovda.bank.service.impl.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	public void run(String... args) throws Exception {
		BankService bankService = new BankServiceImpl();
		BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
		EmployeeService employeeService = new EmployeeServiceImpl();
		BankAtmService bankAtmService = new BankAtmServiceImpl();
		UserService userService = new UserServiceImpl();
		PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
		CreditAccountService creditAccountService = new CreditAccountServiceImpl();

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
