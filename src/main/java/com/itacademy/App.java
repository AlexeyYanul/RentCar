package com.itacademy;

import com.itacademy.dao.AddressDAO;
import com.itacademy.dao.UserDAO;
import com.itacademy.dao.impl.AddressDAOImpl;
import com.itacademy.dao.impl.UserDAOImpl;
import com.itacademy.model.Address;
import com.itacademy.model.User;

public class App {
    private static final UserDAO userDAO = UserDAOImpl.getInstance();
    private static final AddressDAO addressDAO = AddressDAOImpl.getInstance();

    public static void main( String[] args ) {
        User user = userDAO.getOne(2L);
        System.out.println(user);
        Address address = addressDAO.getOne(user.getHomeAddress().getId());
        System.out.println(address);
    }

    public static void createAddress(){
        Address address = new Address();
        address.setCity("City");
        address.setStreet("Street");
        address.setHome(4);
        address.setFlat(3);
        addressDAO.save(address);
    }

    public static void createUser(Address persistentAddress){
        User user = new User();
        user.setFirstName("Andre");
        user.setLastName("King");
        user.setPhone("111111");
        user.setHomeAddress(persistentAddress);
        userDAO.save(user);
    }
}
