package com.csi.service;

import com.csi.model.Customer;

import java.util.List;

public interface CustomerService {

    public  void saveData(Customer customer);

    public Customer getDataByID(int custId);

    public List<Customer> getAllData();

    void updateData(int custId, Customer customer);

    public  void deleteDataById(int custId);


}
