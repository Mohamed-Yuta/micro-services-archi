package com.allali.customer_service.services;

import com.allali.customer_service.dtos.CustomerRequestDTO;
import com.allali.customer_service.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    void delete(String id );
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> listCustomres();
}
