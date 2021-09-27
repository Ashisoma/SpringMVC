package com.ashisoma.demo.service;

import com.ashisoma.demo.model.Phone;

import java.util.List;

public interface PhoneServiceInt {
    public void addPhone(Phone p);
    public void updatePhone(Phone p);
    public List<Phone> listPhones();
    public Phone getPhoneById(int id);
    public void removePhone(int id);
}
