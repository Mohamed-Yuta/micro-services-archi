package allali.com.billing_service.services;

import allali.com.billing_service.dto.InvoiceRequestDTO;
import allali.com.billing_service.dto.InvoiceResponseDTO;
import allali.com.billing_service.entities.Invoice;
import allali.com.billing_service.repositories.InvoiceRepository;
import allali.com.billing_service.mappers.InvoiceMapper;
import allali.com.billing_service.model.Customer;
import allali.com.billing_service.openfeign.CustomerRestClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository ;
    private final InvoiceMapper invoiceMapper ;
    private final CustomerRestClient customerRestClient ;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomer(String customerId) {
        List<Invoice> invoiceList = invoiceRepository.findByCustomerId(customerId);
        List<InvoiceResponseDTO> invoiceResponseDTOS = invoiceList.stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
        return invoiceResponseDTOS;
    }
}
