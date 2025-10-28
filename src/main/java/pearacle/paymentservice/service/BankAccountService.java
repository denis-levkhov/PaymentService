package pearacle.paymentservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pearacle.paymentservice.entity.BankAccount;
import pearacle.paymentservice.repository.BankAccountRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Transactional
    public Optional<BankAccount> findById(Long id) {
        return bankAccountRepository.findById(id);
    }
}
