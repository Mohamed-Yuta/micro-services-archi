package allali.com.billing_service.mappers;

import allali.com.billing_service.dto.InvoiceRequestDTO;
import allali.com.billing_service.dto.InvoiceResponseDTO;
import allali.com.billing_service.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
