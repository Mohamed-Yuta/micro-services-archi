package allali.com.billing_service.dto;

import allali.com.billing_service.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResponseDTO {
    private String id ;
    private Date date ;
    private BigDecimal amount ;
    private Customer customer ;
}
