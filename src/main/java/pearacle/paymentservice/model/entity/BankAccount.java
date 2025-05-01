package pearacle.paymentservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {

    @Column(name = "number")
    private String number;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "costumerId")
    private Long customerId;

    @Column(name = "currency")
    private String currency;
}
