package com.kitri.hello3;

public class HelloServiceKor implements HelloService{
	
	private HelloDao helloDao;
	//쉬운방법
	public HelloServiceKor (HelloDao helloDao) {
		this.helloDao = helloDao;
	}

	
//	public void setHelloDao(HelloDao helloDao) {
//		this.helloDao = helloDao;
//	}
//	
//	
//	public HelloServiceKor() {
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
