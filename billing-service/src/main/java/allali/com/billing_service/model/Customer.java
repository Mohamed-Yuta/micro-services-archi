package allali.com.billing_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    private String id ;
    private String name ;
    private String email ;
}
