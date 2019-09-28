package com.itheima.ui;


import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*模拟一个表现层，用于调用业务层*/
/*
ApplicationContext接口的三个常用实现类：
	ClassPathXmlApplicationContext:可以加载路径下的配置文件，要求配置文件必须在类的路径下，不在则加载不了
	FileSystemXmlApplictionContext("bean文件的路径"):可以加载磁盘任意路径下的配置文件
	AnnotationConfigApplicationContext:用于读取注解创建容器

	核心容器2个接口引发的问题：
	ApplicationContext:
		构建核心容器时，创建对象的策略时采用立即加载的方式，一旦读取完配置文件就马上创建配置文件中的对象
		上面适用于单例对象，即只需创建一次的对象
	BeanFactory:构建核心容器时，采用延迟加载的方式创建对象，也就是说，什么时候根据id获取对象，什么时候创建
		上面适用于多例对象
 */
public class Client {

	public static void main(String[] args) {
		//1.获取核心容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据id获取bean对象
		IAccountService as = (IAccountService)ac.getBean("accountService");
		System.out.println(as);
	}
}
