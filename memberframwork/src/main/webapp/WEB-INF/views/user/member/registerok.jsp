<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%--
MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("registerInfo");
	/* String name = request.getParameter("name"); */
--%>
<%-- <c:if test="${registerInfo != null}">
		<strong>=memberDetailDto.getName()${registerInfo.name}</strong>님 회원가입을 환영합니다.<br>
		가입하신 정보는 아래와 같습니다.<br>
		아이디 : =memberDetailDto.getId()${registerInfo.id}<br>
		이메일 : =memberDetailDto.getEmailid()${registerInfo.emailid}@=memberDetailDto.getEmaildomain()${registerInfo.emaildomain}<br>
		전화번호 : =memberDetailDto.getTel1()${registerInfo.tel1}-=memberDetailDto.getTel2()${registerInfo.tel2}-=memberDetailDto.getTel3()${registerInfo.tel3}<br>
		주소 : =memberDetailDto.getZipcode()${registerInfo.zipcode} =memberDetailDto.getAddress()${registerInfo.address} =memberDetailDto.getAddressDetail()${registerInfo.addressDetail}<br>
		
		로그인 후 모든 서비스를 이용할 수 있습니다<br>
		<a href ='${root}/user/login.kitri'>로그인</a>
</c:if> --%>

<c:if test="${registerInfo != null}">
		<strong>=memberDetailDto.getName()${registerInfo.name}</strong>님 회원가입을 환영합니다.<br>
		가입하신 정보는 아래와 같습니다.<br>
		아이디 : =memberDetailDto.getId()${registerInfo.id}<br>
		이메일 : =memberDetailDto.getEmailid()${registerInfo.emailid}@=memberDetailDto.getEmaildomain()${registerInfo.emaildomain}<br>
		전화번호 : =memberDetailDto.getTel1()${registerInfo.tel1}-=memberDetailDto.getTel2()${registerInfo.tel2}-=memberDetailDto.getTel3()${registerInfo.tel3}<br>
		주소 : =memberDetailDto.getZipcode()${registerInfo.zipcode} =memberDetailDto.getAddress()${registerInfo.address} =memberDetailDto.getAddressDetail()${registerInfo.addressDetail}<br>
		
		로그인 후 모든 서비스를 이용할 수 있습니다<br>
		<a href ='${root}/user/login.kitri'>로그인</a>
</c:if>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>
