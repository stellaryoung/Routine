package com.itheima.dao.impl;
import com.itheima.dao.IAccountDao;
/**
 * 账户的持久层实现类
 */
public class AccountDao implements IAccountDao {
	public void saveAccount(){
		System.out.println("账户已保存");
	}
}
