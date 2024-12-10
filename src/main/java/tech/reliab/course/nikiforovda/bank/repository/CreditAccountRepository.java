package tech.reliab.course.nikiforovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.nikiforovda.bank.entity.CreditAccount;

import java.util.List;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount,Long> {
    List<CreditAccount> findAllCreditAccountsByUserId(Long id);
}
