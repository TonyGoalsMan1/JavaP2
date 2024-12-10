//package tech.reliab.course.nikiforovda.bank;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import tech.reliab.course.nikiforovda.bank.entity.Bank;
//import tech.reliab.course.nikiforovda.bank.entity.BankAtm;
//import tech.reliab.course.nikiforovda.bank.entity.BankOffice;
//import tech.reliab.course.nikiforovda.bank.entity.User;
//import tech.reliab.course.nikiforovda.bank.entity.CreditAccount;
//import tech.reliab.course.nikiforovda.bank.entity.Employee;
//import tech.reliab.course.nikiforovda.bank.entity.PaymentAccount;
//import tech.reliab.course.nikiforovda.bank.repository.BankAtmRepository;
//import tech.reliab.course.nikiforovda.bank.repository.BankOfficeRepository;
//import tech.reliab.course.nikiforovda.bank.service.BankAtmService;
//import tech.reliab.course.nikiforovda.bank.service.BankOfficeService;
//import tech.reliab.course.nikiforovda.bank.service.BankService;
//import tech.reliab.course.nikiforovda.bank.service.CreditAccountService;
//import tech.reliab.course.nikiforovda.bank.service.EmployeeService;
//import tech.reliab.course.nikiforovda.bank.service.UserService;
//import tech.reliab.course.nikiforovda.bank.service.PaymentAccountService;
//import tech.reliab.course.nikiforovda.bank.service.impl.BankAtmServiceImpl;
//import tech.reliab.course.nikiforovda.bank.service.impl.BankOfficeServiceImpl;
//import tech.reliab.course.nikiforovda.bank.service.impl.BankServiceImpl;
//import tech.reliab.course.nikiforovda.bank.service.impl.CreditAccountServiceImpl;
//import tech.reliab.course.nikiforovda.bank.service.impl.EmployeeServiceImpl;
//import tech.reliab.course.nikiforovda.bank.service.impl.PaymentAccountServiceImpl;
//import tech.reliab.course.nikiforovda.bank.service.impl.UserServiceImpl;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//
//public class Main {
//    public static void main(String[] args) {
//        BankAtmRepository bankAtmRepository = new BankAtmRepository() {
//            @Override
//            public List<BankAtm> findAllBankAtmsByBankOfficeId(Long id) {
//                return List.of();
//            }
//
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends BankAtm> S saveAndFlush(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends BankAtm> List<S> saveAllAndFlush(Iterable<S> entities) {
//                return List.of();
//            }
//
//            @Override
//            public void deleteAllInBatch(Iterable<BankAtm> entities) {
//
//            }
//
//            @Override
//            public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public BankAtm getOne(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public BankAtm getById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public BankAtm getReferenceById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public <S extends BankAtm> List<S> findAll(Example<S> example) {
//                return List.of();
//            }
//
//            @Override
//            public <S extends BankAtm> List<S> findAll(Example<S> example, Sort sort) {
//                return List.of();
//            }
//
//            @Override
//            public <S extends BankAtm> List<S> saveAll(Iterable<S> entities) {
//                return List.of();
//            }
//
//            @Override
//            public List<BankAtm> findAll() {
//                return List.of();
//            }
//
//            @Override
//            public List<BankAtm> findAllById(Iterable<Long> longs) {
//                return List.of();
//            }
//
//            @Override
//            public <S extends BankAtm> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public Optional<BankAtm> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(BankAtm entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends BankAtm> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public List<BankAtm> findAll(Sort sort) {
//                return List.of();
//            }
//
//            @Override
//            public Page<BankAtm> findAll(Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends BankAtm> Optional<S> findOne(Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends BankAtm> Page<S> findAll(Example<S> example, Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends BankAtm> long count(Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends BankAtm> boolean exists(Example<S> example) {
//                return false;
//            }
//
//            @Override
//            public <S extends BankAtm, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//                return null;
//            }
//        };
//
//        BankService bankService = new BankServiceImpl();
//        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
//        EmployeeService employeeService = new EmployeeServiceImpl();
//        BankAtmService bankAtmService = new BankAtmServiceImpl(bankAtmRepository);
//        UserService userService = new UserServiceImpl();
//        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
//        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
//
//        for (int i = 1; i < 6; i++) {
//            String name = "Blatnoy Bank #" + i;
//            bankService.create(new Bank(name));
//        }
//
//        List<Bank> bankList = bankService.getAllBanks();
//        for (Bank bank: bankList) {
//            for (int i = 1; i < 3; i++) {
//                bankOfficeService.create(new BankOffice(
//                "Office #" + i + " of " + bank.getName(),
//                "street Pushkina, house Kolotyshkina #" + i,
//                bank,
//                true,
//                true,
//                0,
//                true,
//                true,
//                true,
//                14000,
//                100 * i
//                ));
//            }
//        }
//
//        List<BankOffice> officeList = bankOfficeService.getAllBankOffices();
//        for (BankOffice office: officeList) {
//            for (int i = 1; i < 4; i++) {
//                employeeService.create(new Employee(
//                        "Ruslan Polivaniy Version #" + i,
//                        LocalDate.of(2003, 12, 9),
//                        "Cleaner",
//                        office.getBank(),
//                        false,
//                        office,
//                        false,
//                        7000));
//            }
//        }
//
//        // adding Atms
//        for (BankOffice office: officeList) {
//            for (int i = 1; i < 4; i++) {
//                bankAtmService.create(new BankAtm(
//                        "Super ATM #" + i + " of 'Blatnoy bank'",
//                        office.getAddress(),
//                        BankAtm.Status.WORKING,
//                        office.getBank(),
//                        office,
//                        bankOfficeService.getAllEmployeesByOfficeId(office.getId())
//                                .getFirst(),
//                        true,
//                        true,
//                        0,
//                        17));
//            }
//        }
//
//        for (Bank bank: bankList) {
//            System.out.println(bank.toString());
//        }
//
//        System.out.print('\n');
//
//        for (BankOffice office: officeList) {
//            System.out.println(office.toString());
//        }
//    }
//}