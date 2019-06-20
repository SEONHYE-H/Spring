package com.kitri.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;


@Controller
@RequestMapping("/user")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
//	@Qualifier("Impl1")	// 여러개 있을때 이거 있으면 에러난대. 이거에 따라서 들어가는게 정해진다?
	private MemberService memberService;	//root-context.xml에..... 주입시키기...?
	
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.GET)
	public String register() {	//단순 페이지 이동은 String
		return "user/member/member";	// view의 이름만 적으면 된다네
	}
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.POST)
	public String register(MemberDetailDto memberdetailDto, Model model) {	// 이렇게 하면 set set set 할필요 없다! 단, form에 있는 속성의 이름과 dto의 이름이 같아야한다!
		int cnt = memberService.registerMember(memberdetailDto);
		if (cnt != 0) {
			model.addAttribute("userInfo", memberdetailDto);
			return "user/member/registerok";	// view 가 된다 저 위에 model은 모델이 된다는데... 왜...?굳이...?
		}
		return "user/member/registerfail";
	}
	
	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)
	@ResponseBody/*여기가 json이다!라고 알려줌..?*/
	public String idcheck(@RequestParam(name = "checkid", defaultValue = "") String id) {
		logger.info("검색 아이디 : " + id);
		// 서비스로 보내자! service 변수잡자!(위!)
		String json = memberService.idCheck(id);
		return json;	//    /WEB-INF/views/{"idcount" : 0}...
	}
	
	@RequestMapping("/login.kitri")
	public String login() {	//단순 페이지 이동은 String
		return "user/login/login";	// view의 이름만 적으면 된다네
	}
	
	@RequestMapping("/zipsearch.kitri")
	@ResponseBody
	public String zipSearch(@RequestParam(name = "doro") String doro) {	//단순 페이지 이동은 String
		logger.info("검색 도로명 : " + doro); 
		String json = memberService.zipSearch(doro);
		return json;	// view의 이름만 적으면 된다네
	}
}