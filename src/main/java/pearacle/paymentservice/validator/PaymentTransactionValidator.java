package pearacle.paymentservice.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pearacle.paymentservice.dto.CreatePaymentTransactionRequest;
import pearacle.paymentservice.service.BankAccountService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentTransactionValidator {

    private final Validator validator;
    private final BankAccountService bankAccountService;

    public void validateCreatePaymentTransactionRequest(CreatePaymentTransactionRequest request) {

        var violations = validator.validate(request);
        List<String> errors = new ArrayList<>(
                violations.stream()
                        .map(ConstraintViolation::getMessage)
                        .toList());


        var sourceBank = bankAccountService.findById(request.getSourceBankAccountId());



    }
}
