package com.itheima.factory;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * 创建Bean对象的工厂
 * Bean:计算机英语中，有可重用组件的含义
 * JavaBean:用Java语言创建的可重用组件
 * 			javabean不等价与实体类，而是包含实体类
 * 	不通过new方式创建对象，那么如何创建对象
 * 	方法：
 * 	1.需要配置文件配置我们的service和dao
 * 	2.通过读取配置文件中配置的内容，反射创建对象
 *
 * 	配置文件可以时xml也可以是properties
 */
//静态代码块在虚拟机加载类的时候就执行（只执行一次）
// 非静态代码块每一次new的时候都会执行一次。
public class BeanFactory {
	private static  Map<String,Object> bean;
	private static Properties props = new Properties();
	static{
		try {
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
			props.load(in);     //此处加载了资源文件bean,properties的内容
			/*这里通过map数据结果将容器名对应的类全部实例化为对象并保存*/
			/*里面的key-value是   bean的名称-bean对象*/
			bean = new HashMap<String,Object>();
			Enumeration<Object> keys = props.keys();
			System.out.println("1111");
			while(keys.hasMoreElements()){
				//取出每一个keys
				String key = keys.nextElement().toString();
				//获取路径
				String beanPath = props.getProperty(key);
				Object value = Class.forName(beanPath).newInstance();
				bean.put(key,value);
			}
		}catch(Exception e){
			throw new ExceptionInInitializerError("初始化properties失败！");
		}
	}
	public static Object getBean(String beanName){
		return bean.get(beanName);
	}

/*
	public static Object getBean(String beanName){
		Object bean = null;
		//资源中是（类名，类的全限定名）
		try{
			String beanPath = props.getProperty(beanName);
			bean = Class.forName(beanPath).newInstance();
			//Class.forName仅仅得到是Class对象的引用，返回值必须是实例对象，因此再实例化
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}*/
}
