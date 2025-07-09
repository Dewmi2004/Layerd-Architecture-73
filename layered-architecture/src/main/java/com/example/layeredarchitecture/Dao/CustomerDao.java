package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDao {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public void SaveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
    public void DeleteCustomer(String id) throws SQLException, ClassNotFoundException ;
    public String Genarateid() throws SQLException, ClassNotFoundException;
    public  CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException ;
}
