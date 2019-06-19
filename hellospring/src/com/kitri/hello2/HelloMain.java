package com.kitri.hello2;

public class HelloMain {
	public static void main(String[] args) {
		HelloService helloService= new HelloServiceEng();
//		HelloServiceKor helloServiceKor = new HelloServiceKor();
//		String msg = helloServiceKor.helloKor("황선혜");
		
		String msg = helloService.hello("황선혜");
		
		System.out.println(msg);
	}
}
