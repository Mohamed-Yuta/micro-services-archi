package com.allali.customer_service.services;

import com.allali.customer_service.dtos.CustomerRequestDTO;
import com.allali.customer_service.dtos.CustomerResponseDTO;
import com.allali.customer_service.entities.Customer;
import com.allali.customer_service.mappers.CustomerMapper;
import com.allali.customer_service.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository ;
    private CustomerMapper customerMapper ;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer saveCustomer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerDTO(saveCustomer);
        return customerResponseDTO;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer getCustomer = customerRepository.findById(id).get();
        CustomerResponseDTO getCustomerResponse = customerMapper.customerToCustomerDTO(getCustomer);
        return getCustomerResponse;
    }

    @Override
    public List<CustomerResponseDTO> listCustomres() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS = customerList.stream()
                .map(customer -> customerMapper.customerToCustomerDTO(customer))
                .collect(Collectors.toList());

        return customerResponseDTOS;
    }
}
