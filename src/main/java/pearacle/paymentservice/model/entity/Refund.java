package pearacle.paymentservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pearacle.paymentservice.model.enums.RefundStatus;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Refund extends BaseEntity {

    private BigDecimal refundedAmount;

    private String reason;

    @Enumerated(EnumType.STRING)
    private RefundStatus status;

    @ManyToOne
    @JoinColumn(name = "PaymentTransactionId", referencedColumnName = "id")
    private PaymentTransaction paymentTransaction;
}
