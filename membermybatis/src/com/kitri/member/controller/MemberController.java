package com.kitri.member.controller;

import javax.servlet.http.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberServiceImpl;

// Front가 하는거 빼고 한다!
public class MemberController {
	
	private static MemberController memberController;
	
	static {
		memberController = new MemberController();
	}
	
	private MemberController() {
		
	}
	
	public static MemberController getmMemberController() {
		return memberController;
	}
	
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		MemberDetailDto memberdetailDto = new MemberDetailDto();
		memberdetailDto.setName(request.getParameter("name"));
		memberdetailDto.setId(request.getParameter("id"));
		memberdetailDto.setPass(request.getParameter("pass"));
		memberdetailDto.setEmailid(request.getParameter("emailid"));
		memberdetailDto.setEmaildomain(request.getParameter("emaildomain"));
		memberdetailDto.setTel1(request.getParameter("tel1"));
		memberdetailDto.setTel2(request.getParameter("tel2"));
		memberdetailDto.setTel3(request.getParameter("tel3"));
		memberdetailDto.setZipcode(request.getParameter("zipcode"));
		memberdetailDto.setAddress(request.getParameter("address"));
		memberdetailDto.setAddressDetail(request.getParameter("address_detail"));	//웹에서만 할수있는 java(로직)
		
		int cnt = MemberServiceImpl.getMemberService().registerMember(memberdetailDto);
//		System.out.println("cnt == " + cnt);
		if(cnt != 0) {
			//상세정보 가져가야지!
			request.setAttribute("userInfo", memberdetailDto);
			path = "/user/member/registerok.jsp";	// 아직 가라! 아니고 갈거다!
		}else {
			path = "/user/member/registerfail.jsp";	// 아직 가라! 아니고 갈거다!
		}
		
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("??????");
		String path = "/index.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().loginMember(id, pass);
		if (memberDto != null) {
			//////////////////////////Cookie //////////////////////////////
			String idsv = request.getParameter("idsave");
			System.out.println(idsv);
			if("idsave".equals(idsv)) {
				System.out.println("쿠키저장되고있니...?왜 안되는거니...?");
				Cookie cookie = new Cookie("kid_inf", id);
				cookie.setDomain("localhost");
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60*24*356*50);	// 50년	// 이건 메모리에서 만들어진다?
				response.addCookie(cookie);// 클라이언트한테 보내자!
			}else {
				System.out.println("1234564");
				Cookie cookie[] = request.getCookies();
//				String svid = "";
//				String ckid = "";
				if(cookie != null){
					for(Cookie c : cookie){
						if("kid_inf".equals(c.getName())){
//							svid = c.getValue();
//							ckid = " checked";
							c.setDomain("localhost");
							c.setPath(request.getContextPath());
							c.setMaxAge(0);	// 지금 바로 죽어랏!
							response.addCookie(c);
							break;
						}
					}
				}
			}
			
			/////////////////////////////////////////////////////////////////
			
			
			////////////////////////// session //////////////////////////////
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);	// 로그인이 됐다면!
			/////////////////////////////////////////////////////////////////
			path = "/user/login/loginok.jsp";
		}else {
			path = "/user/login/loginfail.jsp";
		}
		return path;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);		// 이거보단 아래가 좋다!
//		session.removeAttribute("userInfo");	// 하나 지워라!
		session.invalidate(); 	// 세션안에 있는걸 싹다 지워라!
		return "/user/login/login.jsp";
	}


	
}