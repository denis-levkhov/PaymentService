package pearacle.paymentservice.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pearacle.paymentservice.model.enums.PaymentTransactionStatus;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "payment_transaction")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTransaction extends BaseEntity {

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentTransactionStatus paymentTransactionStatus;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount;

    @ManyToOne
    @JoinColumn(name = "destinationBankAccountId")
    private BankAccount destinationBankAccount;

    @Column(name = "errorMessage")
    private String errorMessage;

    @OneToMany(mappedBy = "paymentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;
}
