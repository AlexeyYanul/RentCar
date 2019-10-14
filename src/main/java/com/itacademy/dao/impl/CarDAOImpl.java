package com.itacademy.dao.impl;

import com.itacademy.dao.CarDAO;
import com.itacademy.model.Car;
import com.itacademy.model.CarInfo;
import com.itacademy.model.CarModel;
import com.itacademy.model.enums.Body;
import com.itacademy.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class CarDAOImpl extends GenericDAOImpl<Car, Long> implements CarDAO {

    private static CarDAOImpl instance;

    CarDAOImpl() {
        super(Car.class);
    }

    synchronized public static CarDAOImpl getInstance(){
        if (instance == null){
            instance = new CarDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Car> findByBodyType(Body bodyType, Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car c WHERE c.body = :body";
            TypedQuery<Car> query = session.createQuery(hql, Car.class);
            query.setParameter("body", bodyType);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.getResultList();
        }
    }

    @Override
    public List<Car> findByModel(String model, Integer firstResult, Integer maxResult) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car c WHERE c.carModel.name = :model";
            TypedQuery<Car> query = session.createQuery(hql, Car.class);
            query.setParameter("model", model);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.getResultList();
        }
    }

    @Override
    public List<CarModel> getModelList() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM CarModel cm";
            TypedQuery<CarModel> query = session.createQuery(hql, CarModel.class);
            return query.getResultList();
        }
    }

    @Override
    public CarInfo getCarInfo(Car car) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM CarInfo ci WHERE ci.car = :car";
            TypedQuery<CarInfo> query = session.createQuery(hql, CarInfo.class);
            query.setParameter("car", car);
            return query.getSingleResult();
        }
    }

    @Override
    public List<Car> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car";
            TypedQuery<Car> query = session.createQuery(hql, Car.class);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.getResultList();
        }
    }
}
