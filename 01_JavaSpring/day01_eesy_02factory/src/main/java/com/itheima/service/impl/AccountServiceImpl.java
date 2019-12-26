package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
/*
账户的业务层实现
 */
public class AccountServiceImpl implements IAccountService {
	//private IAccountDao accountDao = new AccountDao();    //此处调用持久层
	//通过工厂模式获取持久层对象
	private IAccountDao accountDao = (AccountDao)BeanFactory.getBean("accountDao");
	public void saveAccount(){
		accountDao.saveAccount();
	}
}
