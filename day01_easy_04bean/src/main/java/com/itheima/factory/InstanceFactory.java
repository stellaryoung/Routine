package com.itheima.factory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
public class InstanceFactory {
	public IAccountService getAccountService(){
		return new AccountServiceImpl();
	}
}
