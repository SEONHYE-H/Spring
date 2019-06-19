package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

//사용자가 뭘 요구하는지랑 어디로 가는지!!!! 이게 너의 역할이다!
@WebServlet("/user")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 서비스 객체는 통틀어서 하나만 만들어져야한다!
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path ="/index.jsp"; //이동할 경로!!
		
//		if (act.equals("mvjoin")) {	// 이걸하면 널포인터 나옴! 하고싶다면 위에 if(act != null) 을 써야한다! 아래방법이 더 좋다!!!
		if ("mvjoin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/member/member.jsp");
		} else if ("mvlogin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/login/login.jsp");
		}else if ("idcheck".equals(act)) {				//ajax
			String sid = request.getParameter("sid");
//			System.out.println("검색아이디 : " + sid);
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);
			
			response.setContentType("text/xml; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		}else if ("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
//			System.out.println("검색 도로명 : " + doro);
			String resultXML = MemberServiceImpl.getMemberService().zipSearch(doro);
			
			response.setContentType("text/xml; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		}else if ("register".equals(act)) {
			path = MemberController.getmMemberController().register(request, response);
			MoveUrl.forward(request, response, path);	// 가자! sendredirect는 다 버리고 간다! 쟤가 가기전에 다 버리고간다 -> forward로 바꾼다..?
		}else if ("login".equals(act)) {
			System.out.println("들어왔니...?");
			path = MemberController.getmMemberController().login(request, response);
			MoveUrl.redirect(request, response, path);
		}else if ("logout".equals(act)) {
			path = MemberController.getmMemberController().logout(request, response);
			MoveUrl.redirect(request, response, path);
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}

