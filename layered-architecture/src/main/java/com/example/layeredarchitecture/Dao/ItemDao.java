package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDao {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
    public boolean excistItem(String code) throws SQLException, ClassNotFoundException ;
    public boolean UpdateItem(ItemDTO item) throws ClassNotFoundException, SQLException ;
    public boolean DeleteItem(String item) throws ClassNotFoundException, SQLException ;
    public void SaveItem(ItemDTO item) throws ClassNotFoundException, SQLException ;
    public String genarateId( ) throws SQLException, ClassNotFoundException ;
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException ;
}
