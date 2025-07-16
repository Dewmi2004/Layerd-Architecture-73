package com.example.layeredarchitecture.BO.custom.impl;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrderBO {
    public String GetNewIdOrder() throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException;
    public ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException;
    public boolean ExistItem(String id) throws SQLException, ClassNotFoundException;
    public boolean ExistCustomer(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String id) throws SQLException, ClassNotFoundException;
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException ;
    }
