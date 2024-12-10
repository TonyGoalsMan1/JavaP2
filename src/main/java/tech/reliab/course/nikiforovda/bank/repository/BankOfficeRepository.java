package tech.reliab.course.nikiforovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.nikiforovda.bank.entity.BankOffice;

import java.util.List;

@Repository
public interface BankOfficeRepository extends JpaRepository<BankOffice,Long> {
    List<BankOffice> findAllBankOfficesByBankId(Long id);
}
