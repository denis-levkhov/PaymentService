package pearacle.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pearacle.paymentservice.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
