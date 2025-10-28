package pearacle.paymentservice.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pearacle.paymentservice.util.JsonConverter;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatePaymentTransactionHandler implements PaymentTransactionCommandHandler {

    @Override
    public void process(String requestId, String message) {
        var request = JsonConverter.toObject(message, CreatePaymentTransactionHandler.class);

    }
}
