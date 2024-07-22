package allali.com.billing_service.openfeign;

import allali.com.billing_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomer(@PathVariable String id );
    @GetMapping("/api/customers")
    List<Customer> allCustomers();
}
