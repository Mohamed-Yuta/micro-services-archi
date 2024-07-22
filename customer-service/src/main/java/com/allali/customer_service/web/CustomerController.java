package com.allali.customer_service.web;

import com.allali.customer_service.dtos.CustomerRequestDTO;
import com.allali.customer_service.dtos.CustomerResponseDTO;
import com.allali.customer_service.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService ;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customers")
    public List<CustomerResponseDTO> getCustomers(){
        return customerService.listCustomres();
    }
    @PostMapping("/addCustomer")
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
       return customerService.save(customerRequestDTO);
    }
    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id ){
         return customerService.getCustomer(id);
    }
}
