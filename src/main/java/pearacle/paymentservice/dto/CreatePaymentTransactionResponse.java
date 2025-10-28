package pearacle.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pearacle.paymentservice.enums.CommandResultStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentTransactionResponse {
    private Long paymentTransactionId;
    private CommandResultStatus status;
    private String errorMessage;
    private LocalDateTime executedAt;
}
