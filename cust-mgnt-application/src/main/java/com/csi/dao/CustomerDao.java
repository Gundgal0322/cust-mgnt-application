package com.csi.dao;

import com.csi.model.Customer;

import java.util.List;

public interface CustomerDao {

    public  void saveData(Customer customer);

    public Customer getDataByID(int custId);

    public List<Customer> getAllData();

    public void updateData( Customer customer);

    public  void deleteDataById(int custId);

}
