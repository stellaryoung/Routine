package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;

/*
账户的业务层实现
 */
public class AccountServiceImpl implements IAccountService {
	private IAccountDao accountDao = new AccountDao();    //此处调用持久层
	//通过工厂模式获取持久层对象

	public void saveAccount(){
		accountDao.saveAccount();
	}
}
