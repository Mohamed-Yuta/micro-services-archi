package allali.com.billing_service.dto;

import allali.com.billing_service.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceRequestDTO {
    private BigDecimal amount ;
    private Customer customer ;
}
