<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
<%--
MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("userInfo");
	/* String name = request.getParameter("name"); */
--%>
<c:if test="${userInfo != null}">
		<strong><%--=memberDetailDto.getName()--%>${userInfo.name}</strong>님 회원가입을 환영합니다.<br>
		가입하신 정보는 아래와 같습니다.<br>
		아이디 : <%--=memberDetailDto.getId()--%>${userInfo.id}<br>
		이메일 : <%--=memberDetailDto.getEmailid()--%>${userInfo.emailid}@<%--=memberDetailDto.getEmaildomain()--%>${userInfo.emaildomain}<br>
		전화번호 : <%--=memberDetailDto.getTel1()--%>${userInfo.tel1}-<%--=memberDetailDto.getTel2()--%>${userInfo.tel2}-<%--=memberDetailDto.getTel3()--%>${userInfo.tel3}<br>
		주소 : <%--=memberDetailDto.getZipcode()--%>${userInfo.zipcode} <%--=memberDetailDto.getAddress()--%>${userInfo.address} <%--=memberDetailDto.getAddressDetail()--%>${userInfo.addressDetail}<br>
		
		로그인 후 모든 서비스를 이용할 수 있습니다<br>
		<a href ='${root}/user/login.html'>로그인</a>
</c:if>
<%@ include file="/template/footer.jsp"%>
