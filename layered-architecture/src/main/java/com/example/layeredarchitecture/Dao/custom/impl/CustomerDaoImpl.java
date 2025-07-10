package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.Dao.custom.CustomerDao;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exicute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> customers = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),rst.getString("name"),rst.getString("address"));
            customers.add(customerDTO);
        }
        return customers;
    }

    @Override
    public boolean Save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)"
                ,customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());

    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.exicute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public String Genaratenewid() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exicute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exicute("SELECT * FROM Customer WHERE id = ?",newValue);
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));

        return customerDTO;
    }

}
