package allali.com.billing_service.entities;

import allali.com.billing_service.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Invoice {
    @Id
    private String id ;
    private Date date ;
    private BigDecimal amount ;
    private String customerId ;
    @Transient
    private Customer customer ;
}
