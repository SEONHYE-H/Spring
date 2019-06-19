package com.kitri.hello1;

public class HelloMain {
	public static void main(String[] args) {
//		HelloServiceKor helloServiceKor = new HelloServiceKor();
//		String msg = helloServiceKor.helloKor("황선혜");
		
		HelloServiceEng helloServiceEng = new HelloServiceEng();
		String msg = helloServiceEng.helloEng("황선혜");
		
		System.out.println(msg);
	}
}
