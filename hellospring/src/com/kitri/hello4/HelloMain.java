package com.kitri.hello4;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class HelloMain {
	public static void main(String[] args) {

//		2.0에서는 xml만 사용가능
//		이후는 다 쓸수있지만 어노테이션(자바파일)?을 혼용해서 사용한다
		
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class);
		HelloService helloService = context.getBean("hs", HelloService.class);
		String msg = helloService.hello("황선혜");
		
		HelloService helloService1 = context.getBean("hs", HelloService.class);
		HelloService helloService2 = context.getBean("hs", HelloService.class);
		System.out.println(helloService1 + "    " + helloService2);

	}
}
