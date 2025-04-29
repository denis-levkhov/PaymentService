package pearacle.paymentservice.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pearacle.paymentservice.model.enums.PaymentTransactionStatus;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTransaction extends BaseEntity {

    private BigDecimal amount;

    private String currency;

    @Enumerated(EnumType.STRING)
    private PaymentTransactionStatus paymentTransactionStatus;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount destinationBankAccount;

    private String errorMessage;

    @OneToMany(mappedBy = "paymentTransation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;
}
