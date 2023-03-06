package com.dailycodework.excel2database.controller;

import com.dailycodework.excel2database.entity.Customer;
import com.dailycodework.excel2database.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;

    /**
     * http://localhost:8088/customers/upload-customers-data
     * @param file
     * @return
     */
    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file")MultipartFile file) {
        this.customerService.saveCustomersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Customers data uploaded and saved to database successfully"));
    }

    /**
     * http://localhost:8088/customers/get-customers-data
     * @return
     */
    @GetMapping("/get-customers-data")
    public ResponseEntity<List<Customer>> getCustomers() {
        try {
            List<Customer> allCustomers = customerService.getCustomers();
            if(allCustomers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception exp) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }
}
