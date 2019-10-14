package com.itacademy;

import com.itacademy.dao.AddressDAO;
import com.itacademy.dao.CarDAO;
import com.itacademy.dao.UserDAO;
import com.itacademy.dao.impl.AddressDAOImpl;
import com.itacademy.dao.impl.CarDAOImpl;
import com.itacademy.dao.impl.UserDAOImpl;
import com.itacademy.model.*;
import com.itacademy.model.enums.Body;

import java.util.List;


public class App {

    public static final CarDAO carDAO = CarDAOImpl.getInstance();

    public static void main( String[] args ) {
        List<Car> cars = carDAO.findAll(0,4);

        for (Car car : cars) {
            System.out.println(car);
        }


    }

}
