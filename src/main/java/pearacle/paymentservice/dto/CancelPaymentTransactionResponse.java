package pearacle.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pearacle.paymentservice.enums.CommandResultStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionResponse {
    private Long refundId;
    private CommandResultStatus status;
    private String errorMessage;
}
