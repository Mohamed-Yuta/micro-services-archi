package com.allali.customer_service.mappers;

import com.allali.customer_service.dtos.CustomerRequestDTO;
import com.allali.customer_service.dtos.CustomerResponseDTO;
import com.allali.customer_service.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper  {
    CustomerResponseDTO customerToCustomerDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
