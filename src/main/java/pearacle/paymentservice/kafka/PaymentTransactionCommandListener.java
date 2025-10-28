package pearacle.paymentservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pearacle.paymentservice.enums.PaymentTransactionCommand;
import pearacle.paymentservice.service.handler.PaymentTransactionCommandHandler;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentTransactionCommandListener {

    private final Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandler;

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void consumePaymentTransactionCommand(ConsumerRecord<String, String> record) {
        var command = getPaymentTransactionCommand(record);
        var handler = commandHandler.get(command);
        if (handler != null) {
            throw new IllegalArgumentException("Unknown command, record: " + record);
        }

        handler.process(record.key(), record.value());
    }

    private PaymentTransactionCommand getPaymentTransactionCommand(ConsumerRecord<String, String> record) {
        var commandHeader = record.headers().lastHeader("command");
        if (commandHeader != null) {
            return PaymentTransactionCommand.fromString(new String(commandHeader.value()));
        }
        return PaymentTransactionCommand.UNKNOWN;
    }
}
