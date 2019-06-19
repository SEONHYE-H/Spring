package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  // 이 클래스를 설정파일로 사용할거야~
public class HelloServiceFactory {
	
	@Bean(name = {"hs", "helloservice"})	// bean으로 사용활거야~
//	@Scope(value = "prototype")
	public HelloService getHelloService() {
		return new HelloServiceKor(); // 싱글톤 적용안했지만 스프링이 알아서 싱글톤으로 만들어준다!(@들 안하면 일반객체니까 싱글톤으로 지정이 안된다!)
	}	// 이 역할을 하는 것은 xml에서 bean과 같다
	
}
