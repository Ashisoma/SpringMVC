package com.ashisoma.demo.service;

import com.ashisoma.demo.dao.PhoneDAO;
import com.ashisoma.demo.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneService implements PhoneServiceInt {

    @Autowired
    private final PhoneDAO phoneDAO;

    public PhoneService(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }


    @Override
    public void addPhone(Phone p) {
        this.phoneDAO.addPhone(p);
    }

    @Override
    public void updatePhone(Phone p) {
        this.phoneDAO.updatePhone(p);
    }

    @Override
    public List<Phone> listPhones() {
        return this.phoneDAO.listPhones();
    }

    @Override
    public Phone getPhoneById(int id) {
        return this.phoneDAO.getPhoneById(id);
    }

    @Override
    public void removePhone(int id) {
        this.phoneDAO.removePhone(id);
    }
}
