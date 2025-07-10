package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.Dao.custom.ItemDao;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDaoimpl implements ItemDao {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.exicute("SELECT * FROM Item");
        ArrayList<ItemDTO> items = new ArrayList<>();
        while (rst.next()){
            ItemDTO item = new ItemDTO(rst.getString("code"),rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
            items.add(item);
        }
        return items;
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exicute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }
    @Override
    public boolean update(ItemDTO item) throws ClassNotFoundException, SQLException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
    }
   @Override
    public boolean Delete(String item) throws ClassNotFoundException, SQLException {
      return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",item);
    }
    @Override
    public boolean Save(ItemDTO item) throws ClassNotFoundException, SQLException {
       return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());

    }
    @Override
    public String Genaratenewid( ) throws SQLException, ClassNotFoundException {
      ResultSet rst =SQLUtil.exicute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    @Override
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
       ResultSet rst = SQLUtil.exicute("SELECT * FROM Item WHERE code=?",newItemCode);
       rst.next();
        ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }
}
