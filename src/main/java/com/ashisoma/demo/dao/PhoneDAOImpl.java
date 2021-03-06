package com.ashisoma.demo.dao;

import com.ashisoma.demo.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO{
    private static final Logger logger = LoggerFactory.getLogger(PhoneDAOImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    @Override
    public void addPhone(Phone p) {
        Session session = this.sessionFactory.getCurrentSession(
        );
        session.persist(p);
        logger.info("Phone saved successfully, Phone Details=" + p);
    }
    @Override
    public void updatePhone(Phone p) {
        Session session = this.sessionFactory.getCurrentSession(
        );
        session.update(p);
        logger.info("Phone updated successfully, Phone Details=" + p);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Phone> listPhones() {
        Session session = this.sessionFactory.getCurrentSession(
        );
        List<Phone> phonesList = session.createQuery("from Phone").list();
        for (Phone p : phonesList) {
            logger.info("Phone List::" + p);
        }
        return phonesList;
    }
    @Override
    public Phone getPhoneById(int id) {
        Session session = this.sessionFactory.getCurrentSession(
        );
        Phone p = (Phone) session.load(Phone.class, id);
        logger.info("Phone loaded successfully, Phone details=" + p);
        return p;
    }
    @Override
    public void removePhone(int id) {
        Session session = this.sessionFactory.getCurrentSession(
        );
        Phone p = (Phone) session.load(Phone.class, (id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Phone deleted successfully, phone details=" + p);
    }
}

