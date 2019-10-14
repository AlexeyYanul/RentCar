package com.itacademy.dao;

import com.itacademy.model.Car;
import com.itacademy.model.CarInfo;
import com.itacademy.model.CarModel;
import com.itacademy.model.enums.Body;

import java.util.List;

public interface CarDAO extends GenericDAO<Car, Long>{
    List<Car> findByBodyType(Body bodyType, Integer firstResult, Integer maxResult);
    List<Car> findByModel(String model, Integer firstResult, Integer maxResult);
    List<CarModel> getModelList();
    CarInfo getCarInfo(Car car);
    List<Car> findAll(Integer firstResult, Integer maxResult);
}
