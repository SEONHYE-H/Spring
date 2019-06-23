package com.kitri.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;


@Controller
@RequestMapping("/user")
@SessionAttributes("userInfo")	// session에 넣어라!
//@SessionAttributes(names = {"userInfo", "b", "c")
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
	public String register(MemberDetailDto memberDetailDto, Model model) {	// 이렇게 하면 set set set 할필요 없다! 단, form에 있는 속성의 이름과 dto의 이름이 같아야한다!
		int cnt = memberService.registerMember(memberDetailDto);
		if (cnt != 0) {
//			model.addAttribute("userInfo", memberdetailDto);
			model.addAttribute("userInfo", memberDetailDto);
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
	
	@RequestMapping("/zipsearch.kitri")
	@ResponseBody
	public String zipSearch(@RequestParam(name = "doro") String doro) {	//단순 페이지 이동은 String
		logger.info("검색 도로명 : " + doro); 
		String json = memberService.zipSearch(doro);
		return json;	// view의 이름만 적으면 된다네
	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.GET)
	public String login() {	//단순 페이지 이동은 String
		return "user/login/login";	// view의 이름만 적으면 된다네
	}
	
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
//	public String login(@RequestParam("id") String id, 
//						@RequestParam("pass") String pass,
//						HttpSession session) {	//인터셉터?가 돌아다니는 세션을 가져온다..?
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		if(memberDto != null) {
//			session.setAttribute("userInfo", memberDto); // 정상적으로 가져오지 못하면 null뜬다
//			return "user/login/loginok";
//		} else {
//			return "user/login/loginfail";
//		}
//	}

	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map,	//이렇게만 하면 모델이 된다 하지만 우리는 파라미터를 가져와야한다!
						HttpSession session
						/* Model model */) {	//인터셉터?가 돌아다니는 세션을 가져온다..?
//		MemberDto memberDto = memberService.loginMember(id, pass);	
		MemberDto memberDto = memberService.loginMember(map);
		if(memberDto != null) {
			session.setAttribute("userInfo", memberDto); // 정상적으로 가져오지 못하면 null뜬다
//			model.addAttribute("userInfo", memberDto); // 정상적으로 가져오지 못하면 null뜬다	//요긩 @SessionAttributes("userInfo")
			return "user/login/loginok";
		} else {
			return "user/login/loginfail";
		}
	}
	
//	@RequestMapping("/logout.kitri")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");
//		return "redirect:/index.jsp";	// redirct 안붙이면 이상하게 들어간다구
//	}
	
	@RequestMapping("/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus session) { //@ModelAttribute("userInfo")세션안에 있는 userInfo를 가져와라!
		session.setComplete();
		return "redirect:/index.jsp";	// redirct 안붙이면 이상하게 들어간다구
	}
	
	
	
//	1. 회원정보수정화면 띄우기
	@RequestMapping(value = "/mvmodify.kitri")
	public String modify(@ModelAttribute("userInfo") MemberDto memberDto, HttpSession session) {
		//session.setAttribute("userInfo", memberDto);
		return "user/member/modify";
	}
	
//	2. 회원정보수정하기
	@RequestMapping(value = "/modify.kitri")
	public String modifyMember(MemberDetailDto memberDetailDto, Model model, HttpSession session) {	// 이렇게 하면 set set set 할필요 없다! 단, form에 있는 속성의 이름과 dto의 이름이 같아야한다!
		int cnt = memberService.modifyMember(memberDetailDto);
		if (cnt != 0) {
			System.out.println("내가 지금 뭐하고있나 참 궁금하다");
			model.addAttribute("userInfo", memberDetailDto);
			return "user/login/loginok";	// view 가 된다 저 위에 model은 모델이 된다는데... 왜...?굳이...?
		}
		System.out.println("뭐겠어 삽질이지 ");
		return "user/member/registerfail";
	}
	
//	1. 탈퇴
	@RequestMapping(value = "/delete.kitri")
	public String deleteMember(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus session) { //@ModelAttribute("userInfo")세션안에 있는 userInfo를 가져와라!
		System.out.println(memberDto.getId());
		memberService.deleteMember(memberDto.getId());
		session.setComplete();
		return "redirect:/index.jsp";	// redirct 안붙이면 이상하게 들어간다구
	}
}
