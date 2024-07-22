package allali.com.billing_service.services;

import allali.com.billing_service.dto.InvoiceRequestDTO;
import allali.com.billing_service.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoicesByCustomer(String customerId);
}
