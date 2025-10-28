package pearacle.paymentservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pearacle.paymentservice.enums.PaymentTransactionCommand;
import pearacle.paymentservice.service.handler.CancelPaymentTransactionHandler;
import pearacle.paymentservice.service.handler.CreatePaymentTransactionHandler;
import pearacle.paymentservice.service.handler.PaymentTransactionCommandHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentTransactionCommandConfig {

    @Bean
    public Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers(
            CreatePaymentTransactionHandler createPaymentTransactionHandler,
            CancelPaymentTransactionHandler cancelPaymentTransactionHandler
    ) {
        Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers = new HashMap<>();
        commandHandlers.put(PaymentTransactionCommand.CREATE, createPaymentTransactionHandler);
        commandHandlers.put(PaymentTransactionCommand.REFUND, cancelPaymentTransactionHandler);
        return commandHandlers;
    }
}
