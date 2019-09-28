package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/*模拟一个表现层，用于调用业务层*/
public class Client {

	public static void main(String[] args) {
		//IAccountService as = new AccountServiceImpl();   //此处调用业务层
	  //错误例：IAccountService as = (AccountServiceImpl)BeanFactory.getBean("AccountServiceImpl");
		//配置文件中的结构：（容器名，类的全限定名）
		//这里传入的是容器名，工厂模式类根据容器名获取对应的容器类的全限定名
		//有了全限定名就可以通过反射的方式获取对应的class类，将其实例化返回所需要的对象
		for(int i = 0;i < 5;++i) {
			IAccountService as = (AccountServiceImpl) BeanFactory.getBean("accountService");
			System.out.println(as);
			as.saveAccount();
		}
	}
}
