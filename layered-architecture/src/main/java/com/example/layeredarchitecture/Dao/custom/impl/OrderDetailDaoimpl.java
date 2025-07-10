package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.Dao.custom.CustomerDao;
import com.example.layeredarchitecture.Dao.custom.OrderDetailDao;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public  class OrderDetailDaoimpl implements OrderDetailDao {

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Save(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate( "INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)"
                ,orderDetailDTO.getOrderId(),orderDetailDTO.getItemCode(),orderDetailDTO.getUnitPrice(),orderDetailDTO.getQty());
    }

    @Override
    public boolean update(OrderDetailDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String Genaratenewid() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public OrderDetailDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

}