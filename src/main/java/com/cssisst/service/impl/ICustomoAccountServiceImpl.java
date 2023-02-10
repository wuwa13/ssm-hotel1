package com.cssisst.service.impl;

import com.cssisst.dao.ICustomAccountDao;
import com.cssisst.entity.CustomAccount;
import com.cssisst.service.ICustomoAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ICustomoAccountServiceImpl implements ICustomoAccountService {

    @Resource
    private ICustomAccountDao iCustomAccountDao;

    @Override
    public List<CustomAccount> getALLcustomAccount() {
        List<CustomAccount> alLcustomAccount = iCustomAccountDao.getALLcustomAccount();
        return alLcustomAccount;
    }

    @Override
    public void cusSave(CustomAccount c) {
        iCustomAccountDao.save(c);
    }

    @Override
    public void cuDelete(int  accountid) {
        iCustomAccountDao.delete(accountid);
    }

    @Override
    public CustomAccount cuGetCustomAccountByName(String accountname) {
        return null;
    }

    @Override
    public CustomAccount getCustomAccountById(int accountid) {
        CustomAccount customAccountById = iCustomAccountDao.getCustomAccountById(accountid);
        return customAccountById;
    }

    @Override
    public CustomAccount cuGetCustomAccountBynp(String username, String password) {
        CustomAccount customAccountById = iCustomAccountDao.getCustomAccountByName(username);
        if (customAccountById!=null) {
            return customAccountById;
        }
        return null;
    }

    @Override
    public void cuUpdate(CustomAccount c) {
        iCustomAccountDao.update(c);
    }


}
