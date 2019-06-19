package com.kitri.hello.model.service;

import com.kitri.hello.model.dao.HelloDao;

public class HelloServiceImpl implements HelloService{
	
	private HelloDao helloDao;
	//쉬운방법
	
	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}
	

	
//	public void setHelloDao(HelloDao helloDao) {
//		this.helloDao = helloDao;
//	}
//	public HelloServiceImpl() {
//		System.out.println("HelloServiceKor 생성자 호출!!!");
//	}
	

	public String hello(String name) {
		return name +"님 안녕하세요!\n" + helloDao.getGreeting();
	}



	
}

//public class Dto() {
//	private String id;
//	
//	getUserId(){
//		
//	}
//	
//	setUserId(){
//		
//	}
//}
