package com.cssisst.dao;


import com.cssisst.entity.CustomAccount;

import java.util.List;

public interface ICustomAccountDao {
	List<CustomAccount> getALLcustomAccount();
    void save(CustomAccount c);
    void delete(int accountid);
    void update(CustomAccount c);
	CustomAccount getCustomAccountByName(String accountname);
    CustomAccount getCustomAccountById(int accountid);
	CustomAccount getCustomAccountBynp(String username, String password);
}
