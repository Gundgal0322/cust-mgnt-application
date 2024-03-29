package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")

public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<String> saveData(@RequestBody Customer customer) {
        customerServiceImpl.saveData(customer);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Customer> getDataById(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.getDataByID(custId));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData() {
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<String> updateData(@PathVariable int custId, @RequestBody Customer customer) {

        Customer customer1 = customerServiceImpl.getDataByID(custId);
        if (customer1.getCustId() == custId) {
            customer1.setCustName(customer.getCustName());
            customer1.setCustAddress(customer.getCustAddress());
            customer1.setCustContactNumber(customer.getCustContactNumber());
            customer1.setCustAccountBalance(customer.getCustAccountBalance());
            customer1.setCustDOB(customer.getCustDOB());

            customerServiceImpl.updateData(custId, customer1);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }

        return ResponseEntity.ok("Record Updated Successfully");
    }

    @DeleteMapping("/deletedatabyid/{custId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int custId) {
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Record Deleted Successfully");
    }
}
