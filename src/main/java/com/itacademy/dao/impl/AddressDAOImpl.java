package com.itacademy.dao.impl;

import com.itacademy.dao.AddressDAO;
import com.itacademy.model.Address;

public class AddressDAOImpl extends GenericDAOImpl<Address, Long> implements AddressDAO {

    private static AddressDAOImpl instance;

    AddressDAOImpl() {
        super(Address.class);
    }

    synchronized public static AddressDAOImpl getInstance(){
        if (instance == null){
            instance = new AddressDAOImpl();
        }
        return instance;
    }

}
