package com.example.layeredarchitecture.Dao.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDao {
    public String generateNewOrderId() throws SQLException, ClassNotFoundException;
    public boolean Insertorder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    public boolean selectOId(String orderId) throws SQLException, ClassNotFoundException;
}
