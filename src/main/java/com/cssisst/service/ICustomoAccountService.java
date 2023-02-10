package com.cssisst.service;

import com.cssisst.entity.Admin;
import com.cssisst.entity.CustomAccount;

import java.util.List;

public interface ICustomoAccountService {
    List<CustomAccount> getALLcustomAccount();
    void cusSave(CustomAccount c);
    void cuDelete(int accountid);
    CustomAccount cuGetCustomAccountByName(String accountname);
    CustomAccount getCustomAccountById(int accountid);
    CustomAccount cuGetCustomAccountBynp(String username, String password);
    void cuUpdate(CustomAccount c);

}
