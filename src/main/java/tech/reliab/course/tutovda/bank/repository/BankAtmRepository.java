package tech.reliab.course.tutovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.tutovda.bank.entity.BankAtm;

import java.util.List;

@Repository
public interface BankAtmRepository extends JpaRepository<BankAtm,Long> {
    List<BankAtm> findAllBankAtmsByBankOfficeId(Long id);
}
