package com.example.layeredarchitecture.BO.custom;

import com.example.layeredarchitecture.BO.custom.impl.CustomerBO;
import com.example.layeredarchitecture.Dao.DAOFactory;
import com.example.layeredarchitecture.Dao.custom.CustomerDao;
import com.example.layeredarchitecture.Dao.custom.impl.CustomerDaoImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDao customerDao = (CustomerDao) DAOFactory.getInstance().getDAO(DAOFactory.DAOtypes.CUSTOMER);

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDao.getAll();
    }

    @Override
    public boolean SaveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDao.Save(customerDTO);
    }

    @Override
    public boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.Delete(id);
    }

    @Override
    public boolean UpdateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDao.update(customerDTO);
    }

    @Override
    public boolean ExistCustomer(String id) throws SQLException, ClassNotFoundException {

        return customerDao.exist(id);
    }

    @Override
    public String GetNewIdCustomer() throws SQLException, ClassNotFoundException {
        return customerDao.Genaratenewid();
    }


}