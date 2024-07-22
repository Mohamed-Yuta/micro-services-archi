package allali.com.billing_service.web;

import allali.com.billing_service.dto.InvoiceRequestDTO;
import allali.com.billing_service.dto.InvoiceResponseDTO;
import allali.com.billing_service.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    private final InvoiceService invoiceService ;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @GetMapping("/invoices/{invoiceId}")
    public InvoiceResponseDTO getInvoice(@PathVariable String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }
    @PostMapping("/invoices")
    public InvoiceResponseDTO saveInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }
    @GetMapping("/invoices/{customerId}")
    public List<InvoiceResponseDTO> listsInvoicesByCustomer(@PathVariable String customerId){
        return invoiceService.invoicesByCustomer(customerId);
    }
}
