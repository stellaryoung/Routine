package com.itheima.service.impl;
import com.itheima.service.IAccountService;
/*
账户的业务层实现
 */
public class AccountServiceImpl implements IAccountService {
	//通过工厂模式获取持久层对象
	public void saveAccount(){
		System.out.println("账户已保存！");
	}
}
